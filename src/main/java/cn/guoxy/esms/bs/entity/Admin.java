package cn.guoxy.esms.bs.entity;

/**
 * 管理员实体类
 * 
 * @author gxy
 *
 */
public class Admin {
	/**
	 * 管理员ID
	 */
	private int adminId;
	/**
	 * 管理员名字
	 */
	private String adminName;
	/**
	 * 管理员密码
	 */
	private String adminPwd;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}

}
