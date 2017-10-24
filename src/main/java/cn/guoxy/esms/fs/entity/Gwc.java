package cn.guoxy.esms.fs.entity;

/**
 * 购物车实体类
 * 
 * @author gxy
 *
 */
public class Gwc {
	/**
	 * 购物车ID
	 */
	private int gwcId;
	/**
	 * 商品ID
	 */
	private int goodsId;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 商品数量
	 */
	private int count;

	public int getGwcId() {
		return gwcId;
	}

	public void setGwcId(int gwcId) {
		this.gwcId = gwcId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
