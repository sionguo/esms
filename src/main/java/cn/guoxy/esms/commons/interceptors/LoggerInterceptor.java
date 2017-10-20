package cn.guoxy.esms.commons.interceptors;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.guoxy.esms.commons.util.LogFactory;

/**
 * 日志拦截器 拦截所有请求并将请求IP和请求路径记录到日志
 * 
 * @author gxy
 *
 */
public class LoggerInterceptor implements HandlerInterceptor {

	private static Logger log = LogFactory.getGlobalLog();

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/// esms/tobslogin.do
		log.info("" + request.getRemoteAddr());
		log.info("" + request.getRequestURL());
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
