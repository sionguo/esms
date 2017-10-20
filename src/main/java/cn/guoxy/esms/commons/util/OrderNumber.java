package cn.guoxy.esms.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import cn.guoxy.esms.fs.entity.User;

/**
 * 订单号生成工具类
 * 
 * @author gxy
 *
 */
public class OrderNumber {
	/**
	 * 生成订单号，格式是：yyyyMMddHHmmss + 8位用户Id + 2位随机数
	 * 
	 * @param session
	 * @return
	 */
	public static String CreateOrderNumber(HttpSession session) {
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		User user = (User) session.getAttribute("user");
		String id = String.format("%8d", user.getId()).replace(" ", "0");
		Random ran = new Random();
		String r = String.format("%2d", ran.nextInt(100)).replace(" ", "0");
		String orderNumber = date + id + r;
		return orderNumber;
	}
}
