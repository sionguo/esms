package cn.guoxy.esms.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.service.GoodsService;

/**
 * 主页请求相关处理
 * 
 * @author gxy
 *
 */
@Controller
public class IndexController {
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	/**
	 * 转发到首页
	 * 
	 * @return
	 */
	@RequestMapping("/toindex.do")
	public String toIndex() {
		return "index";
	}

	/**
	 * 得到最新商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getNewGoods.do")
	@ResponseBody
	public List<Goods> getNewGoods(HttpServletRequest request) {
		Integer season = Integer.parseInt(request.getParameter("season"));
		List<Goods> list = goodsService.getNewGoods(season);
		return list;
	}

	/**
	 * 得到最热商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getHotGoods.do")
	@ResponseBody
	public List<Goods> getHotGoods(HttpServletRequest request) {
		List<Goods> list = goodsService.getHotGoods();
		return list;
	}
}
