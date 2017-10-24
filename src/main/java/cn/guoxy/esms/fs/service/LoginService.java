package cn.guoxy.esms.fs.service;

import cn.guoxy.esms.fs.entity.User;

/**
 * 登录业务层接口
 * 
 * @author gxy
 *
 */
public interface LoginService {
	/**
	 * 验证登录
	 * 
	 * @param user
	 * @return
	 */
	public User cheakLogin(User user);

}
