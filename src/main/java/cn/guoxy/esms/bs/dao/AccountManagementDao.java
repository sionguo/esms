package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * 账号管理持久层接口
 * 
 * @author gxy
 *
 */
public interface AccountManagementDao {
	/**
	 * 得到所有的会员信息
	 * 
	 */
	List<User> findAllUser();

	/**
	 * 得到所有管理员信息
	 */
	List<Admin> findAllAdmin();

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 *            管理员对象
	 */
	int addAdmin(Admin admin);

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 *            管理员Id
	 * @return 删除的记录数
	 */
	int deleteAdmin(int adminId);
}
