package cn.guoxy.esms.fs.service;

import javax.servlet.http.HttpSession;

/**
 * 验证码业务层接口
 * 
 * @author gxy
 *
 */
public interface CodeService {
	/**
	 * 生成验证码
	 * 
	 * @param session
	 * @return
	 */
	public Object createCode(HttpSession session);

	/**
	 * 检查验证码
	 * 
	 * @param vcode
	 * @param session
	 * @return
	 */
	public boolean checkCode(String vcode, HttpSession session);
}
