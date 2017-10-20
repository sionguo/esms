package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * 订单管理业务层接口
 * 
 * @author gxy
 *
 */
public interface OrderFormService {
	/**
	 * 得到所有订单
	 * 
	 * @return
	 */
	List<OrderFormGoods> findAll();

	/**
	 * 移除所有订单
	 * 
	 * @param orderId
	 */
	void removeOrderForm(int orderId);

	/**
	 * 更新订单状态
	 * 
	 * @param orderId
	 *            订单ID
	 * @param status
	 *            订单状态
	 */
	void updateStatus(int orderId, int status);
}
