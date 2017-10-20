package cn.guoxy.esms.commons.entity;

import java.sql.Date;

/**
 * 购物车商品实体类 未加注释的变量请参考{@link Goods}
 * 
 * @author gxy
 *
 */
public class GwcGoods {
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
	 * 购物车商品数量
	 */
	private int count;
	/**
	 * 购物车ID
	 */
	private int gwcId;

	public int getGwcId() {
		return gwcId;
	}

	public void setGwcId(int gwcId) {
		this.gwcId = gwcId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
