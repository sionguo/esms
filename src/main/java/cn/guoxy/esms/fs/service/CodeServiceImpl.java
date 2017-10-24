package cn.guoxy.esms.fs.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.util.ImageUtil;

/**
 * 验证码业务层实现类
 * 
 * @author gxy
 *
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

	public Object createCode(HttpSession session) {
		Object[] objs = ImageUtil.createImage();
		BufferedImage image = (BufferedImage) objs[1];
		session.setAttribute("code", objs[0]);
		return image;
	}

	public boolean checkCode(String vcode, HttpSession session) {
		vcode = vcode.toUpperCase();
		String code = session.getAttribute("code").toString().toUpperCase();
		if (vcode.equals(code)) {
			return true;
		} else {
			return false;
		}
	}

}
