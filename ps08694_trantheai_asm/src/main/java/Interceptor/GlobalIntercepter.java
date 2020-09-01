package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import model.User;

public class GlobalIntercepter extends HandlerInterceptorAdapter{
	
@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = new User();
		user.setUsername("test");
		user.setPassword("123");
		request.setAttribute("user", user);
		return true;
	}
}
