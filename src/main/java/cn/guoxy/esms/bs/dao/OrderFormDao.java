package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * 订单管理持久层接口
 * 
 * @author gxy
 *
 */
public interface OrderFormDao {
	/**
	 * 查询所有订单
	 */
	List<OrderFormGoods> findAllOrderForm();

	/**
	 * 移除订单
	 * 
	 * @param orderId
	 *            订单ID
	 * @return 记录改变条数
	 */
	int removeOrderForm(int orderId);

	/**
	 * 更改订单状态
	 * 
	 * @param orderId
	 *            订单ID
	 * @param status
	 *            状态值
	 * @return 记录被改变的条数
	 */
	int updateStatus(int orderId, int status);
}
