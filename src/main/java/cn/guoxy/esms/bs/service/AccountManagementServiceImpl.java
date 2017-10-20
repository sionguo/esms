package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.AccountManagementDao;
import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * 账户管理业务层实现类
 * 
 * @author gxy
 *
 */
@Service("accountManagementService")
public class AccountManagementServiceImpl implements AccountManagementService {
	@Resource(name = "accountManagementDao")
	private AccountManagementDao dao;

	public List<User> findAllUser() {
		List<User> list = dao.findAllUser();
		return list;
	}

	public List<Admin> findAllAdmin() {
		List<Admin> list = dao.findAllAdmin();
		return list;
	}

	public void addAdmin(Admin admin) {
		dao.addAdmin(admin);

	}

	public void deleteAdmin(int adminId) {
		dao.deleteAdmin(adminId);

	}

}
