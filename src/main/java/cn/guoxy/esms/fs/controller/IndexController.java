package cn.guoxy.esms.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.service.GoodsService;

@Controller
public class IndexController {
	@Resource(name = "goodsService")
	private GoodsService goodsService;

	@RequestMapping("/toindex.do")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/getNewGoods.do")
	@ResponseBody
	public List<Goods> getNewGoods(HttpServletRequest request) {
		Integer season = Integer.parseInt(request.getParameter("season"));
		List<Goods> list = goodsService.getNewGoods(season);
		return list;
	}

	@RequestMapping("/getHotGoods.do")
	@ResponseBody
	public List<Goods> getHotGoods(HttpServletRequest request) {
		List<Goods> list = goodsService.getHotGoods();
		return list;
	}
}
