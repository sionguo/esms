package cn.guoxy.esms.fs.service;

import javax.servlet.http.HttpSession;

public interface CodeService {
	public Object createCode(HttpSession session);
	public boolean checkCode(String vcode,HttpSession session);
}
