package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.AccountManagementService;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.entity.User;

/**
 * 后台账号管理类
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class AccountManagementController {
	@Resource(name = "accountManagementService")
	private AccountManagementService accountManagementService;
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * 转发到后台会员管理界面
	 * 
	 * @return会员管理页面
	 */
	@RequestMapping("toUser.do")
	public String toUser() {
		return "bs/user";
	}

	/**
	 * 转发到管理员管理界面
	 * 
	 * @return 管理员管理页面
	 */
	@RequestMapping("toAdmin.do")
	public String toAdmin() {
		return "bs/admin";
	}

	/**
	 * 获得所有会员信息
	 * 
	 * @return 所有的会员信息
	 */
	@RequestMapping("getuser.do")
	@ResponseBody
	public List<User> getUser() {
		List<User> list = accountManagementService.findAllUser();
		return list;
	}

	/**
	 * 得到所有的管理员信息
	 * 
	 * @return 管理员信息
	 */
	@RequestMapping("getadmin.do")
	@ResponseBody
	public List<Admin> getAdmin() {
		List<Admin> list = accountManagementService.findAllAdmin();
		return list;
	}

	/**
	 * 添加管理员
	 * 
	 * @param request
	 * @return 自定义返回类型
	 */
	@RequestMapping("updateadmin.do")
	@ResponseBody
	public ReturnType updateAdmin(HttpServletRequest request) {
		Admin admin = new Admin();
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		accountManagementService.addAdmin(admin);
		log.info("ADD ADMIN--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName() + "--->"
				+ admin.getAdminName());
		return new ReturnType(0, "添加成功");
	}

	/**
	 * 删除管理员
	 * 
	 * @param request
	 * @return 自定义返回类型
	 */
	@RequestMapping("deleteadmin.do")
	@ResponseBody
	public ReturnType deleteAdmin(HttpServletRequest request) {
		Admin admin = new Admin();
		List<Admin> list = accountManagementService.findAllAdmin();
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		for (Admin admin2 : list) {
			if (admin2.getAdminId() == adminId) {
				admin = admin2;
			}
		}
		accountManagementService.deleteAdmin(adminId);
		log.info("DELETE ADMIN--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName() + "--->"
				+ admin.getAdminName());
		return new ReturnType(0, "删除成功");
	}
}
