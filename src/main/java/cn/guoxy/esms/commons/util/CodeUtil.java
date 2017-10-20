package cn.guoxy.esms.commons.util;

import java.util.Random;

/**
 * 找回密码时，邮件发送验证码的工具类
 * 
 * @author gxy
 *
 */
public class CodeUtil {
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static String createCode() {
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			int n = ran.nextInt(chars.length);
			sb.append(chars[n]);
		}
		return sb.toString();
	}
}
