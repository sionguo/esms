package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * 账户管理业务层
 * 
 * @author gxy
 *
 */
public interface AccountManagementService {
	/**
	 * 得到所有会员
	 */
	List<User> findAllUser();

	/**
	 * 得到所有管理员
	 * 
	 * @return
	 */
	List<Admin> findAllAdmin();

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 *            管理员对象
	 */
	void addAdmin(Admin admin);

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 *            管理员ID
	 */
	void deleteAdmin(int adminId);
}
