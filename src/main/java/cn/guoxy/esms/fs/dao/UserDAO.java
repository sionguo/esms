package cn.guoxy.esms.fs.dao;

import cn.guoxy.esms.fs.entity.User;

/**
 * 用户相关持久层接口
 * 
 * @author gxy
 *
 */
public interface UserDAO {
	/**
	 * 通过用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public User findByname(String userName);

	/**
	 * 通过邮箱查找用户
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * 通过用户ID查找用户
	 * 
	 * @param id
	 * @return
	 */
	public User findByid(int id);

	/**
	 * 更改密码
	 * 
	 * @param Pwd
	 * @param email
	 * @return
	 */
	int updatePwd(String Pwd, String email);
}
