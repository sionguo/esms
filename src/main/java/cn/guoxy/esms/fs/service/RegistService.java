package cn.guoxy.esms.fs.service;

import cn.guoxy.esms.fs.entity.User;

public interface RegistService {
	public boolean checkUserName(String userName);

	public boolean checkEmail(String email);

	public void save(User user);

	void updatePwd(String Pwd, String email);
}
