package cn.guoxy.esms.fs.service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.util.CodeUtil;
import cn.guoxy.esms.commons.util.SendEmail;

/**
 * 邮箱服务
 * 
 * @author gxy
 *
 */
@Service("emailService")
public class EmailService {
	/**
	 * 登录验证邮箱
	 * 
	 * @param request
	 */
	public void ckEmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		String path = request.getContextPath();
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		String real = "/ckkEmail.do?uid=" + uuid;
		request.getSession().setAttribute("uid", uuid);
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ real;
		try {
			SendEmail.sendEail(email, basePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送验证码
	 * 
	 * @param request
	 */
	public void sendYzm(HttpServletRequest request) {
		String code = CodeUtil.createCode();
		request.getSession().setAttribute("yzm", code);

		String email = request.getParameter("email");
		request.getSession().setAttribute("yzmemail", email);
		String msg = "验证码是：=========》" + code;
		try {
			SendEmail.sendEail(email, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
