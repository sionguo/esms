package cn.guoxy.esms.bs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.AdminService;
import cn.guoxy.esms.fs.exception.AppException;

/**
 * 后台登录处理
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class BsLoginController {
	@Resource(name = "adminService")
	private AdminService adminService;

	/**
	 * 异常处理
	 * 
	 * @param e
	 *            捕获的异常
	 * @param request
	 *            请求对象
	 * @return 视图名
	 */
	@ExceptionHandler
	public String handleEx(Exception e, HttpServletRequest request) {
		if (e instanceof AppException) {
			request.setAttribute("login_failed", e.getMessage());
			return "bs/bslogin";
		}
		return "error";
	}

	/**
	 * 转发到后台登录页面
	 * 
	 * @return 视图名
	 */
	@RequestMapping("tobslogin.do")
	public String toBsLogin() {
		return "bs/bslogin";
	}

	/**
	 * 处理登录逻辑
	 * 
	 * @param request
	 *            请求对象
	 * @param session
	 *            绑定参数是用
	 * @return 视图名
	 */
	@RequestMapping("bslogin.do")
	public String bsLogin(HttpServletRequest request, HttpSession session) {
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		Admin ad = new Admin();
		ad.setAdminName(adminName);
		ad.setAdminPwd(adminPwd);
		Admin admin = adminService.ckLogin(ad);
		session.setAttribute("admin", admin);
		return "redirect:toBsIndex.do";
	}

	/**
	 * 处理登出请求
	 * 
	 * @param session
	 *            移除参数时使用
	 * @return 视图名
	 */
	@RequestMapping("bslogout.do")
	public String bsLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:tobslogin.do";

	}
}
