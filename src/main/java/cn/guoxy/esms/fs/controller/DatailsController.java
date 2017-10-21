package cn.guoxy.esms.fs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.service.GoodsService;

/**
 * 商品详情页处理
 * 
 * @author gxy
 *
 */
@Controller
public class DatailsController {
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	/**
	 * 得到商品信息并返回详情页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("details.do")
	public String details(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		goodsService.updateClickNum(goodsId);
		Goods goods = goodsService.findByGoodsId(goodsId);
		request.setAttribute("goods", goods);
		return "details";
	}
}
