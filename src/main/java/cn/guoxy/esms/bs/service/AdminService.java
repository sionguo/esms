package cn.guoxy.esms.bs.service;

import cn.guoxy.esms.bs.entity.Admin;

/**
 * 管理员登录业务层接口
 * 
 * @author gxy
 *
 */
public interface AdminService {
	/**
	 * 检查登录参数是否匹配
	 * 
	 * @param admin
	 *            管理员对象
	 * @return 数据库中的管理员对象，此值用于session验证
	 */
	Admin ckLogin(Admin admin);
}
