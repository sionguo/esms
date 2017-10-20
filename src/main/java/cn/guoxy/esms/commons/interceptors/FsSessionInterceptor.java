package cn.guoxy.esms.commons.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ç°Ì¨sessionÀ¹½ØÆ÷
 * 
 * @author gxy
 *
 */
public class FsSessionInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			response.setHeader("sessionstatus", "timeout");
			response.setHeader("redirectUrl", request.getContextPath() + "/tologin.do");
			if (request.getHeader("ajax") != null) {
				return false;
			} else {
				response.sendRedirect("tologin.do");
				return false;
			}

		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
