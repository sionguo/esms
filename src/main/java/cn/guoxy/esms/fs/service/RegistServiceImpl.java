package cn.guoxy.esms.fs.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.util.PasswordUtil;
import cn.guoxy.esms.fs.dao.UserDAO;
import cn.guoxy.esms.fs.entity.User;

@Service("registService")
public class RegistServiceImpl implements RegistService {
	@Resource(name = "userDAO")
	private UserDAO dao;

	public boolean checkUserName(String userName) {
		User user = dao.findByname(userName);
		if (user == null) {
			return true;
		}
		return false;
	}

	public boolean checkEmail(String email) {
		User user = dao.findByEmail(email);
		if (user == null) {
			return true;
		}
		return false;
	}

	public void save(User user) {
		user.setPwd(PasswordUtil.generate(user.getPwd()));
		dao.save(user);
	}

	public void updatePwd(String Pwd, String email) {
		dao.updatePwd(Pwd, email);
	}

}
