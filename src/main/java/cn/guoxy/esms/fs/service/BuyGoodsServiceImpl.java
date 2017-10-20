package cn.guoxy.esms.fs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.dao.BuyGoodsDao;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

@Service("buyGoodsService")
public class BuyGoodsServiceImpl implements BuyGoodsService {
	@Resource(name = "buyGoodsDao")
	private BuyGoodsDao dao;

	public void putInGwc(Gwc gwc) {
		dao.saveGwc(gwc);
	}

	public void putInOrderFrom(OrderForm form) {
		dao.saveOrderForm(form);

	}

	public void updateVip(int userId,int vip) {
		dao.updateVip(userId, vip);
		
	}

	public List<OrderFormGoods> findByGoodsId_OrderForm(int userId) {
		List<OrderFormGoods> list = dao.findByGoodsId_OrderForm(userId);
		return list;
	}

	public List<GwcGoods> findByGoodsId_gwc(int userId) {
		List<GwcGoods> list = dao.findByGoodsId_gwc(userId);
		return list;
	}

	public void delgwc(int gwcId) {
		dao.delgwc(gwcId);
	}

}
