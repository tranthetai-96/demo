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
import org.springframework.web.bind.annotation.RequestParam;

import dao.StaffDao;
import dao.StaffDaoImpl;
import model.Staff;
import pojo.Pagination;


@Controller
@RequestMapping("/staff/")
public class StaffController {

	private StaffDao staffDao;
	
	@Autowired
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	@RequestMapping("staff-mgr")
	public String showStaffManager(ModelMap model, @RequestParam(defaultValue = "1") int page) {
		List<Staff> staffs = staffDao.getAllStaffs(page);
		Pagination pagination = staffDao.getPagination(page);
		model.addAttribute("staffs", staffs);
		model.addAttribute("pagination", pagination);
		return "staff/staff-mgr";
	}

	@RequestMapping("staff-mgr/{action}")
	public String showStaffManager(@PathVariable String action
								 , ModelMap model
								 , @RequestParam(defaultValue = "1") int page) {
		List<Staff> staffs = staffDao.getAllStaffs(page);
		Pagination pagination = staffDao.getPagination(page);
		model.addAttribute("staffs", staffs);
		model.addAttribute("mode", action);
		model.addAttribute("pagination", pagination);
		return "staff/staff-mgr";
	}
	
	@GetMapping("staff-form")
	public String showStaffForm(ModelMap model) {
		model.addAttribute("staff", new Staff());
		return "staff/staff-form";
	}
	
	@GetMapping("staff-form/{staffId}")
	public String showStaffForm(@PathVariable int staffId, ModelMap model) {
		Staff staff = staffDao.getStaffById(staffId);
		if(staff != null) {
			model.addAttribute("staff", staff);
		}else {
			model.addAttribute("staff", new Staff());
		}
		model.addAttribute("mode", "edit");
		return "staff/staff-form";
	}
	
	@GetMapping("profile/{staffId}")
	public String showStaffProfile(@PathVariable int staffId, ModelMap model) {
		Staff staff = staffDao.getStaffById(staffId);
		model.addAttribute("staff", staff);
		model.addAttribute("records", staff.getRecords());
		return "staff/staff-profile";
	}
	
	@GetMapping("delete/{staffId}")
	public String deleteStaff(@PathVariable int staffId) {
		staffDao.deleteStaff(staffId);
		return "redirect:/staff/staff-mgr";
	}
	
	@PostMapping("save")
	public String saveStaff(ModelMap model, @Valid Staff staff, BindingResult errors) {
		if(errors.hasErrors())
		{
			return "staff/staff-form";
		}
		staffDao.saveStaff(staff);
		model.addAttribute("message", "global.save.success");
		return "staff/staff-form";
	}

}
