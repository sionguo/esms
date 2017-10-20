package cn.guoxy.esms.bs.dao;

import cn.guoxy.esms.bs.entity.Admin;

/**
 * 管理员持久层
 * 
 * @author gxy
 *
 */
public interface AdminDao {
	/**
	 * 通过管理员名查找管理员
	 * 
	 * @param name
	 *            管理员名
	 * @return 管理员对象
	 */
	Admin findByName(String name);
}
