package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.OrderFormDao;
import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * 订单管理业务层实现类
 * 
 * @author gxy
 *
 */
@Service("orderFormService")
public class OrderFormServiceImpl implements OrderFormService {
	@Resource(name = "orderDao")
	private OrderFormDao dao;

	public List<OrderFormGoods> findAll() {
		List<OrderFormGoods> list = dao.findAllOrderForm();
		return list;
	}

	public void removeOrderForm(int orderId) {
		dao.removeOrderForm(orderId);
	}

	public void updateStatus(int orderId, int status) {
		dao.updateStatus(orderId, status);

	}

}
