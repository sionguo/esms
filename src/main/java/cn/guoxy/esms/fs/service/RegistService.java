package cn.guoxy.esms.fs.service;

import cn.guoxy.esms.fs.entity.User;

/**
 * 注册业务层接口
 * 
 * @author gxy
 *
 */
public interface RegistService {
	/**
	 * 检查用户名是否重复
	 * 
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName);

	/**
	 * 检查邮箱
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * 更新密码
	 * 
	 * @param Pwd
	 * @param email
	 */
	void updatePwd(String Pwd, String email);
}
