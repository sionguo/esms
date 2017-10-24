package cn.guoxy.esms.fs.entity;

import java.util.Date;

/**
 * 订单实体类
 * 
 * @author gxy
 *
 */
public class OrderForm {
	/**
	 * 订单ID
	 */
	private int orderId;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 商品ID
	 */
	private int goodsId;
	/**
	 * 订单状态
	 */
	private int status;
	/**
	 * 订单创建时间
	 */
	private Date CreateTime;
	/**
	 * 商品数量
	 */
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
}
