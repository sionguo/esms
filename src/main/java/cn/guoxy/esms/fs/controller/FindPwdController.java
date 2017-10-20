package cn.guoxy.esms.fs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.service.EmailService;
import cn.guoxy.esms.fs.service.RegistService;

@Controller
public class FindPwdController {
	@Resource(name = "registService")
	private RegistService registService;
	@Resource(name = "emailService")
	public EmailService emailService;

	@RequestMapping("toFind.do")
	public String find() {
		return "find";
	}

	@RequestMapping("getyzm.do")
	@ResponseBody
	public ReturnType getyzm(HttpServletRequest request) {
		String email = request.getParameter("email");
		if (registService.checkEmail(email)) {
			return new ReturnType(1, "邮箱不存在");
		} else {
			emailService.sendYzm(request);
			return new ReturnType(0);
		}

	}

	@RequestMapping("updatePwd.do")
	@ResponseBody
	public ReturnType updatePwd(HttpServletRequest request) {
		String yzm = request.getParameter("yzm");
		String pwd = request.getParameter("pwd");
		String yyzz = (String) request.getSession().getAttribute("yzm");

		String email = (String) request.getSession().getAttribute("yzmemail");
		request.getSession().removeAttribute("yzmemail");
		request.getSession().removeAttribute("yzm");
		if (yyzz.equals(yzm)) {
			registService.updatePwd(pwd, email);
			return new ReturnType(0);
		}
		return new ReturnType(1 , "验证码错误");

	}
}
