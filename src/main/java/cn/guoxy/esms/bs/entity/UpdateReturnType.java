package cn.guoxy.esms.bs.entity;

/**
 * 商品上传返回值类型实体类
 * 
 * @author gxy
 *
 */
public class UpdateReturnType {
	/**
	 * 状态码 0:正常 1：文件不存在 2：服务器错误
	 */
	private int code;
	/**
	 * 原始图片名
	 */
	private String smallImg;
	/**
	 * 大图片名
	 */
	private String bigImg;

	public UpdateReturnType() {
	}

	public UpdateReturnType(int code, String smallImg, String bigImg) {
		super();
		this.code = code;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
		return "UpdateReturnType [code=" + code + ", smallImg=" + smallImg + ", bigImg=" + bigImg + "]";
	}
}
