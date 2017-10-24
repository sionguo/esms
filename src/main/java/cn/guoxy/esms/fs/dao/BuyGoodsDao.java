package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

/**
 * 购买商品相关持久层接口
 * 
 * @author gxy
 *
 */
public interface BuyGoodsDao {
	/**
	 * 添加到购物车
	 * 
	 * @param gwc
	 * @return
	 */
	int saveGwc(Gwc gwc);

	/**
	 * 保存到订单
	 * 
	 * @param orderFrom
	 * @return
	 */
	int saveOrderForm(OrderForm orderFrom);

	/**
	 * 根据用户ID查找商品
	 * 
	 * @param userId
	 * @return
	 */
	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	/**
	 * 根据用户ID查找商品
	 * 
	 * @param userId
	 * @return
	 */
	List<GwcGoods> findByGoodsId_gwc(int userId);

	/**
	 * 提升用户等级
	 * 
	 * @param userId
	 * @param vip
	 * @return
	 */
	int updateVip(int userId, int vip);

	/**
	 * 从购物车移除
	 * 
	 * @param gwcId
	 * @return
	 */
	int delgwc(int gwcId);
}
