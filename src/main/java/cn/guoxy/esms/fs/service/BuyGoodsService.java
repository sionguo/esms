package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

public interface BuyGoodsService {
	void putInGwc(Gwc gwc);

	void putInOrderFrom(OrderForm from);

	void updateVip(int userId, int vip);

	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	List<GwcGoods> findByGoodsId_gwc(int userId);

	void delgwc(int gwcId);
}
