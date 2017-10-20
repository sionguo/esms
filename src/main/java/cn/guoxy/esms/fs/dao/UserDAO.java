package cn.guoxy.esms.fs.dao;

import cn.guoxy.esms.fs.entity.User;

public interface UserDAO {
	public User findByname(String userName);

	public User findByEmail(String email);

	public void save(User user);

	public User findByid(int id);

	int updatePwd(String Pwd, String email);
}
