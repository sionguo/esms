package cn.guoxy.esms.commons.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * 
 * @author gxy
 *
 */
public class SendEmail {
	/**
	 * 创建邮件对象
	 * 
	 * @param session
	 *            邮件的session
	 * @param msg
	 *            消息
	 * @param email
	 *            发送的地址
	 * @return 邮件对象
	 * @throws Exception
	 */
	public static MimeMessage createSimpleMail(Session session, String msg, String email) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("18435114377m@sina.cn"));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		// 邮件的标题
		message.setSubject("邮箱验证");
		// 邮件的文本内容
		message.setContent(msg, "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

	/**
	 * 发送邮件
	 * 
	 * @param email
	 *            邮箱地址
	 * @param msg
	 *            消息
	 * @throws Exception
	 */
	public static void sendEail(String email, String msg) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.sina.cn");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		// 2、通过session得到transport对象
		Transport ts = session.getTransport();
		// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
		ts.connect("smtp.sina.cn", "18435114377m@sina.cn", "lin960320");
		// 4、创建邮件
		Message message = createSimpleMail(session, msg, email);
		// 5、发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
}