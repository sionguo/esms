package cn.guoxy.esms.commons.entity;

import java.sql.Date;

/**
 * 订单商品实体类 未加注释的参数参考{@link Goods}
 * 
 * @author gxy
 *
 */
public class OrderFormGoods {
	private int goodsId;
	private String goodsName;
	private String goodsShow;
	private int goodsPrice;
	private int goodsCount;
	private int season;
	private int btId;
	private int stId;
	private String smallImg;
	private String bigImg;
	private int clickNum;
	private Date updateTime;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 订单状态
	 */
	private int status;
	/**
	 * 订单商品数量
	 */
	private int count;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 购物车ID
	 */
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsShow() {
		return goodsShow;
	}

	public void setGoodsShow(String goodsShow) {
		this.goodsShow = goodsShow;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsShow=" + goodsShow + ", goodsPrice="
				+ goodsPrice + ", goodsCount=" + goodsCount + ", season=" + season + ", btId=" + btId + ", stId=" + stId
				+ ", smallImg=" + smallImg + ", bigImg=" + bigImg + "]";
	}
}
