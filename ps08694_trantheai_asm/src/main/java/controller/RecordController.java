package controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import dao.RecordDao;
import dao.StaffDao;
import model.Record;
import model.Staff;

@Controller
@RequestMapping("/record/")
public class RecordController {
	
	private RecordDao recordDao;
	private StaffDao staffDao;
	
	@Autowired
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	@Autowired
	public void setRecordDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	@GetMapping("record-mgr")
	public String showRecordManager(ModelMap model) {
		List<Record> records = recordDao.getAllRecords();
		model.addAttribute("records", records);
		return "record/record-mgr";
	}
	
	@GetMapping("record-form")
	public String showRecordForm(ModelMap model) {
		List<Staff> staffs = staffDao.getAllStaffs();
		model.addAttribute("staffs", staffs);
		model.addAttribute("record", new Record());
		return "record/record-form";
	}
	
	@GetMapping("record-form/{recordId}")
	public String showRecordForm(@PathVariable int recordId, ModelMap model) {
		List<Staff> staffs = staffDao.getAllStaffs();
		Record rec = recordDao.getRecordById(recordId);
		model.addAttribute("staffs", staffs);
		model.addAttribute("record", rec);
		return "record/record-form";
	}
	
	@PostMapping("save")
	public String saveRecord(ModelMap model, @Valid Record record
			, BindingResult errors) 
	{
		List<Staff> staffs = staffDao.getAllStaffs();
		model.addAttribute("staffs", staffs);
		if(errors.hasErrors()) {
			return "record/record-form";
		}
		if(record.getStaff().getStaffId() < 0) {
			model.addAttribute("error_choose", "global.record.staff.choose");
			return "record/record-form";
		}
		try {
			recordDao.saveRecord(record);
			model.addAttribute("message", "global.save.success");
		} catch (Exception e) {
			model.addAttribute("message", "global.message.error");
		}
		return "record/record-form";
	}
	
	@GetMapping("delete/{recordId}")
	public String deleteRecord(@PathVariable int recordId, RedirectAttributes ra) {
		Record rec = recordDao.getRecordById(recordId);
		try {
			if(rec != null) {
				recordDao.deleteRecord(rec);
				ra.addFlashAttribute("message", "global.delete.success");
			}
		} catch (Exception e) {
			ra.addFlashAttribute("message", "global.message.error");
		}
	
		return "redirect:/record/record-mgr";
	}
	public Map<Staff, String> convertListAfterJava8(List<Staff> list) {
	    Map<Staff, String> map = list.stream()
	      .collect(Collectors.toMap(staff -> staff, Staff::getFullname));
	    return map;
	}
}
