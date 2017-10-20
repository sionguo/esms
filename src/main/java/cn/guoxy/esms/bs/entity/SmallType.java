package cn.guoxy.esms.bs.entity;

/**
 * 商品小分类实体类
 * 
 * @author gxy
 *
 */
public class SmallType {
	/**
	 * 小类型ID
	 */
	private int stId;
	/**
	 * 小类型名
	 */
	private String stName;
	/**
	 * 大类型ID
	 */
	private int btId;

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	@Override
	public String toString() {
		return "SmallType [stId=" + stId + ", stName=" + stName + ", btId=" + btId + "]";
	}
}
