package cn.guoxy.esms.bs.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.AdminDao;
import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.exception.AppException;

/**
 * 管理员登录业务层接口
 * 
 * @author gxy
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDao")
	private AdminDao dao;

	public Admin ckLogin(Admin admin) {
		Admin ad = dao.findByName(admin.getAdminName());
		if (ad == null) {
			throw new AppException("用户名不存在");
		} else if (!ad.getAdminPwd().equals(admin.getAdminPwd())) {
			throw new AppException("密码错误");
		}
		return ad;
	}

}
