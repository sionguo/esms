package cn.guoxy.esms.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.commons.service.GoodsService;
import cn.guoxy.esms.commons.util.OrderNumber;
import cn.guoxy.esms.fs.dao.UserDAO;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;
import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.entity.User;
import cn.guoxy.esms.fs.service.BuyGoodsService;

@Controller
public class BuyController {
	@Resource(name = "buyGoodsService")
	private BuyGoodsService buyGoodsService;
	@Resource(name = "goodsService")
	private GoodsService goodsService;
	@Resource(name = "userDAO")
	private UserDAO dao;

	@RequestMapping("putingwc.do")
	@ResponseBody
	public ReturnType putInGwc(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		Gwc gwc = new Gwc();
		gwc.setGoodsId(goodsId);
		gwc.setCount(count);
		gwc.setUserId(user.getId());
		buyGoodsService.putInGwc(gwc);
		return new ReturnType(0, "加入购物车成功");
	}

	@RequestMapping("putinorder.do")
	@ResponseBody
	public ReturnType putInOrderForm(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		OrderForm orderForm = new OrderForm();
		orderForm.setCount(count);
		orderForm.setGoodsId(goodsId);
		orderForm.setOrderNumber(OrderNumber.CreateOrderNumber(session));
		orderForm.setUserId(user.getId());
		buyGoodsService.putInOrderFrom(orderForm);
		goodsService.updateGoodsCount(goodsId, count);
		Goods goods = goodsService.findByGoodsId(goodsId);
		User user2 = dao.findByid(user.getId());
		int vip = count * goods.getGoodsPrice() + user2.getVip();
		buyGoodsService.updateVip(user.getId(), vip);
		return new ReturnType(0, "购买成功");
	}

	@RequestMapping("putinorder1.do")
	@ResponseBody
	public ReturnType putInOrderForm1(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		int gwcId = Integer.parseInt(request.getParameter("gwcId"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		OrderForm orderForm = new OrderForm();
		orderForm.setCount(count);
		orderForm.setGoodsId(goodsId);
		orderForm.setOrderNumber(OrderNumber.CreateOrderNumber(session));
		orderForm.setUserId(user.getId());
		buyGoodsService.putInOrderFrom(orderForm);
		goodsService.updateGoodsCount(goodsId, count);
		Goods goods = goodsService.findByGoodsId(goodsId);
		User user2 = dao.findByid(user.getId());
		int vip = count * goods.getGoodsPrice() + user2.getVip();
		buyGoodsService.delgwc(gwcId);
		buyGoodsService.updateVip(user.getId(), vip);
		return new ReturnType(0, "购买成功");
	}

	@RequestMapping("toorderForm.do")
	public String orderForm() {
		return "orderfrom";
	}

	@RequestMapping("getForm.do")
	@ResponseBody
	public List<OrderFormGoods> getorderForm(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		List<OrderFormGoods> list = buyGoodsService.findByGoodsId_OrderForm(user.getId());
		return list;
	}

	@RequestMapping("togwc.do")
	public String orderGwc() {
		return "gwc";
	}

	@RequestMapping("getgwc.do")
	@ResponseBody
	public List<GwcGoods> getgwc(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		List<GwcGoods> list = buyGoodsService.findByGoodsId_gwc(user.getId());
		return list;
	}

	@RequestMapping("delgwc.do")
	@ResponseBody
	public ReturnType delGwc(HttpServletRequest request) {
		int gwcId = Integer.parseInt(request.getParameter("gwcId"));
		buyGoodsService.delgwc(gwcId);
		return new ReturnType(0, "删除成功");
	}
}
