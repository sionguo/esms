package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

public interface BuyGoodsDao {
	int saveGwc(Gwc gwc);

	int saveOrderForm(OrderForm orderFrom);

	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	List<GwcGoods> findByGoodsId_gwc(int userId);

	int updateVip(int userId, int vip);

	int delgwc(int gwcId);
}
