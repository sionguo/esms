package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

/**
 * 购买商品相关业务层接口
 * 
 * @author gxy
 *
 */
public interface BuyGoodsService {
	/**
	 * 加入购物车
	 * 
	 * @param gwc
	 */
	void putInGwc(Gwc gwc);

	/**
	 * 购买成功放入订单
	 * 
	 * @param from
	 */
	void putInOrderFrom(OrderForm from);

	/**
	 * 更新用户等级
	 * 
	 * @param userId
	 * @param vip
	 */
	void updateVip(int userId, int vip);

	/**
	 * 查询订单
	 * 
	 * @param userId
	 * @return
	 */
	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	/**
	 * 查询购物车
	 * 
	 * @param userId
	 * @return
	 */
	List<GwcGoods> findByGoodsId_gwc(int userId);

	/**
	 * 删除购物车
	 * 
	 * @param gwcId
	 */
	void delgwc(int gwcId);
}
