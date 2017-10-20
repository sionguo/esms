package cn.guoxy.esms.bs.entity;

/**
 * 商品大分类实体类
 * 
 * @author gxy
 *
 */
public class BigType {
	/**
	 * 大类型ID
	 */
	private int btId;
	/**
	 * 类型名
	 */
	private String btName;

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	public String getBtName() {
		return btName;
	}

	public void setBtName(String btName) {
		this.btName = btName;
	}

	@Override
	public String toString() {
		return "BigType [btId=" + btId + ", btName=" + btName + "]";
	}
}
