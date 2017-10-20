package cn.guoxy.esms.bs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.bs.entity.UpdateReturnType;
import cn.guoxy.esms.bs.service.UpdateService;
import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.resources.EsmsResource;
import cn.guoxy.esms.commons.util.ImageUtil;
import cn.guoxy.esms.commons.util.LogFactory;

/**
 * 上传商品吃力相关
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class UpdateController {
	@Resource(name = "updateService")
	private UpdateService updateService;
	/**
	 * 日志
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * 上传页面
	 * <p>
	 * 进入上传页面时会在session中绑定一个token，此token是为了防止表单的重复提交
	 * 在页面中这个token会放置到表单的隐藏域中，表单提交时一同提交
	 * 
	 * @return 视图名
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(HttpSession session) {
		String token = Long.toString(System.currentTimeMillis());
		session.setAttribute("token", token);
		return "bs/update";
	}

	/**
	 * 图片上传 返回值是一个自定义类型
	 * 
	 * @param request
	 *            请求对象
	 * @param file
	 *            文件
	 * @return 自定义上传返回类型
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public UpdateReturnType update(MultipartFile file) {
		String realPath = EsmsResource.map.get("imgPath");
		String originalFilename = null;
		UpdateReturnType updateReturnType = new UpdateReturnType();
		if (file.isEmpty()) {
			updateReturnType.setCode(1);
			return updateReturnType;
		} else {
			originalFilename = file.getOriginalFilename();
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			String newFileNamebig = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			String filePathbig = realPath;
			try {
				ImageUtil.resize(file.getInputStream(), filePathbig, newFileNamebig);
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, newFileName));
				updateReturnType.setCode(0);
				updateReturnType.setSmallImg(newFileName);
				updateReturnType.setBigImg(newFileNamebig);
			} catch (IOException e) {
				updateReturnType.setCode(2);
				e.printStackTrace();
				return updateReturnType;
			}
		}
		return updateReturnType;

	}

	/**
	 * 下拉选获得参数
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getType.do")
	@ResponseBody
	public List<SmallType> getType(HttpServletRequest request) {
		int btId = Integer.parseInt(request.getParameter("btId"));
		List<SmallType> list = updateService.getSmallType(btId);
		return list;

	}

	/**
	 * 表单提交，提交时会判断表单是否重复提交,若重复提交则不执行保存方法
	 * 
	 * @param request
	 *            请求对象
	 * @param response
	 *            响应对象
	 * @throws IOException
	 *             io异常
	 */

	@RequestMapping("/formupdate.do")
	public void formupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (updateService.isRepeatSubmit(request)) {
			return;
		}
		request.getSession().removeAttribute("token");// 移除session中的token
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Goods goods = new Goods();
		goods.setGoodsName(request.getParameter("goodsName"));
		goods.setGoodsShow(request.getParameter("goodsShow"));
		goods.setBtId(Integer.parseInt(request.getParameter("bigType")));
		goods.setStId(Integer.parseInt(request.getParameter("smallType")));
		goods.setSeason(Integer.parseInt(request.getParameter("season")));
		goods.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		goods.setGoodsCount(Integer.parseInt(request.getParameter("goodsCount")));
		goods.setBigImg(request.getParameter("bigImg"));
		goods.setSmallImg(request.getParameter("smallImg"));
		goods.setUpdateTime(new java.sql.Date(System.currentTimeMillis()));
		ImageUtil.addShow(goods);
		updateService.saveGoods(goods);
		log.info("UPDATE GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		out.println("商品上传成功");
	}

}
