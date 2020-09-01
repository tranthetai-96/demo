package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.DepartmentDao;
import model.Department;

@Controller
@RequestMapping("/depart/")
public class DepartmentController {

	private DepartmentDao departDao;
	
	@Autowired
	public void setDepartmentDao(DepartmentDao departDao) {
		this.departDao = departDao;
	}
	
	@GetMapping("depart-mgr")
	public String showDepartmentManager(ModelMap model) {
		List<Department> departs = departDao.getAllDepartments();
		model.addAttribute("departs", departs);
		return "depart/depart-mgr";
	}
	
	@GetMapping("depart-form")
	public String showDepartForm(ModelMap model) {
		model.addAttribute("department", new Department());
		return "depart/depart-form";
	}
	
	@GetMapping("depart-form/{departId}")
	public String showDepartForm(@PathVariable String departId, ModelMap model) {
		Department department = departDao.getDepartmentById(departId);
		if(department != null) {
			model.addAttribute("department", department);
		}
		model.addAttribute("isEdit", "true");
		return "depart/depart-form";
	}
	
	@GetMapping("delete/{departId}")
	public String deleteDepart(@PathVariable String departId, RedirectAttributes ra) {

		try {
			departDao.deleteDepartment(departId);
			ra.addAttribute("message", "global.update.success");
		} catch (Exception e) {
			ra.addAttribute("message", "global.message.error");
		}
		return "redirect:/depart/depart-mgr";
	}
	
	@PostMapping("save")
	public String saveDepart(ModelMap model, @Valid Department department, BindingResult errors) {
		if(errors.hasErrors()) {
			return "depart/depart-form";
		}
		try {
			departDao.saveDepartment(department);
			model.addAttribute("message", "global.save.success");
		}catch(Exception ex) {
			model.addAttribute("message", "global.message.error");
		}
		return "depart/depart-form";
	}
}
