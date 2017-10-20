package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.KuCunService;
import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;

/**
 * 处理库存管理相关逻辑
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class KuCunController {
	@Resource(name = "kuCunService")
	private KuCunService kuCunService;
	/**
	 * 日志对象
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * 转发到库存管理页面
	 * 
	 * @return 视图名
	 */
	@RequestMapping("toKuCun.do")
	public String toKuCun() {
		return "bs/kucun";
	}

	/**
	 * 获得商品库存信息
	 * 
	 * @return 商品库存信息
	 */
	@RequestMapping("/getkucun.do")
	@ResponseBody
	public List<Goods> getKucun() {
		List<Goods> list = kuCunService.getKuCun();
		return list;
	}

	/**
	 * 更新商品库存信息
	 * 
	 * @param request
	 *            请求对象
	 * @return 自定义返回类型
	 */
	@RequestMapping("updateGoodsCount.do")
	@ResponseBody
	public ReturnType updateGoodsCount(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		kuCunService.updateGoodsCount(goodsId, count);
		log.info("MODIFY GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "更改成功");
	}

	/**
	 * 删除商品
	 * 
	 * @param request
	 *            请求对象
	 * @return 自定义返回类型
	 */
	@RequestMapping("deleteGoods.do")
	@ResponseBody
	public ReturnType deleteGoods(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		kuCunService.deleteGoods(goodsId);
		log.info("REMOVE GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "更改成功");
	}
}
