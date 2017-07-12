package cn.test.email.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.test.email.model.Users;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url=request.getRequestURI();
		
		if(url.indexOf("login.do")>0){
			return true;
		}else if(url.indexOf("register.do")>0){
			return true;
		}
		
		HttpSession session=request.getSession();
		
		Users user=(Users) session.getAttribute("user");
		
		if(user!=null){
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
