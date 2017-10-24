package cn.guoxy.esms.fs.entity;

/**
 * 自定义返回类型，实现返回的一致性
 * 
 * @author gxy
 *
 */
public class ReturnType {
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 信息
	 */
	private String message;

	public ReturnType(int code) {
		super();
		this.code = code;
	}

	public ReturnType(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ReturnType [code=" + code + ", message=" + message + "]";
	}

}
