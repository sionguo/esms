package Test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.guoxy.esms.bs.dao.AdminDao;
import cn.guoxy.esms.bs.dao.GoodsTypeDao;
import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.bs.service.AdminService;

public class Testcase {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		AdminService a = ac.getBean("adminService",AdminService.class);
		Admin add = new Admin();
		add.setAdminName("admin");
		add.setAdminPwd("admin");
		System.out.println(a.ckLogin(add));
	}

	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		AdminDao dao = ac.getBean("adminDao", AdminDao.class);
		System.out.println(dao.findByName("admin"));
	}

}
