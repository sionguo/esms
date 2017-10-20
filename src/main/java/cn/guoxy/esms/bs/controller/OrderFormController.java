package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.OrderFormService;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;

/**
 * 订单管理处理相关
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs")
public class OrderFormController {
	@Resource(name = "orderFormService")
	private OrderFormService ofs;
	/**
	 * 日志对象
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * 转发到订单管理
	 * 
	 * @return 视图名
	 */
	@RequestMapping("toOrderForm.do")
	public String toOrderForm() {
		return "bs/orderForm";
	}

	/**
	 * 得到所有订单信息
	 * 
	 * @return 所有订单信息
	 */
	@RequestMapping("getorderfrom.do")
	@ResponseBody
	public List<OrderFormGoods> getAllOrderFrom() {
		List<OrderFormGoods> list = ofs.findAll();
		return list;
	}

	/**
	 * 删除订单
	 * 
	 * @param request
	 * @return 自定义返回类型
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public ReturnType delect(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		ofs.removeOrderForm(orderId);
		log.info("REMOVE ORDERFORM--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "删除成功");
	}

	/**
	 * 改变订单状态
	 * 
	 * @param request
	 * @return 自定义返回类型
	 */
	@RequestMapping("ree.do")
	@ResponseBody
	public ReturnType ree(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int status = Integer.parseInt(request.getParameter("status"));
		ofs.updateStatus(orderId, status);
		log.info("MODIFY ORDERFORM--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "改变状态成功");
	}
}
