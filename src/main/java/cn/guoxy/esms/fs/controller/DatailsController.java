package cn.guoxy.esms.fs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.service.GoodsService;

@Controller
public class DatailsController {
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	@RequestMapping("details.do")
	public String details(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		goodsService.updateClickNum(goodsId);
		Goods goods = goodsService.findByGoodsId(goodsId);
		request.setAttribute("goods", goods);
		return "details";
	}
}
