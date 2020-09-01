package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String homepage() {

		return "index";
	}
	@RequestMapping("/about")
	public String aboutpage() {

		return "about";
	}
	@RequestMapping("/login")
	public String loginpage(HttpServletResponse response
			, HttpServletRequest request
			,@ModelAttribute("message") String message) throws IOException, ServletException {
		return "forward:/WEB-INF/view/login.jsp";

	}
}
