package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.UserDao;
import model.User;


@Controller
@SessionAttributes("account")
public class AccountController {

	private UserDao dao;
	
	@Autowired
	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}
	
	@PostMapping("signin")
	public String signin(	 @RequestParam String username
							,@RequestParam String password
							,RedirectAttributes ra
							,ModelMap model ) {
		User user = dao.getUserById(username);
		if(user != null && user.getPassword().equals(password)) {
			model.addAttribute("account", user);

			return "redirect:/index.html";
		}
		ra.addFlashAttribute("message", "Username or password incorrect");
		return "redirect:/login.html";
	}
	
	@GetMapping("signout")
	public String signout(WebRequest request, SessionStatus status) {
		status.setComplete();
	    request.removeAttribute("account", WebRequest.SCOPE_SESSION);
		return "redirect:/login.html";
	}
}
