package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.UserDao;
import model.User;

@Controller
@RequestMapping("/user/")
public class UserController {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@RequestMapping("user-mgr")
	public String showUserManager(ModelMap model) {
		List<User> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "user/user-mgr";
	}
	
	@GetMapping("user-form")
	public String showUserForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/user-form";
	}
	@GetMapping("user-form/{userId}")
	public String showUserForm(@PathVariable String userId, ModelMap model) {
		User user = userDao.getUserById(userId);
		if(user != null) {
			model.addAttribute("user", user);
		}
		model.addAttribute("isEdit", "true");
		return "user/user-form";
	}
	@PostMapping("save")
	public String saveUser(ModelMap model,@Valid User user, BindingResult errors) {
		if(errors.hasErrors()) {
			return "user/user-form";
		}
		try {
			userDao.saveUser(user);
			model.addAttribute("message", "global.save.success");
		} catch (Exception e) {
			model.addAttribute("message", "global.message.error");
		}
		
		return "user/user-form";
	}
	
	@GetMapping("delete/{userId}")
	public String deleteUser(@PathVariable String userId
							,RedirectAttributes ra
							, ModelMap model) {
		User user = userDao.getUserById(userId);
		if(user != null) {
			try {
				userDao.deleteUser(user);
				ra.addFlashAttribute("message", "global.delete.success");
			} catch (Exception e) {
				ra.addFlashAttribute("message", "global.message.error");
			}
			
		}
		return "redirect:/user/user-mgr";
	}
	
	@GetMapping("profile/{userId}")
	public String showProfile(@PathVariable String userId, ModelMap model) {
		User user = userDao.getUserById(userId);
		model.addAttribute("user", user);
		return "user/user-profile";
	}
}
