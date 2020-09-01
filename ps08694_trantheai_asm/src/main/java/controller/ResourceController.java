package controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.StaffDao;
import dao.UserDao;

@Controller
@RequestMapping("/")
public class ResourceController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StaffDao staffDao;
	
	@PostMapping(value = "upload", consumes = "multipart/form-data")
	public String uploadFile(ModelMap model,@RequestParam("photo") MultipartFile photo) 
	{
		if(photo.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}else{
			try {
				String photoPath = context.getRealPath("/resources/images/avatar/"+photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
				model.addAttribute("photo_name", photo.getOriginalFilename());
				model.addAttribute("cv_size", photo.getSize());
				return "staff/staff-mgr";
			}
			catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}

		return "user/user-mgr";
	}
	
	@PostMapping(value = "{entity}/upload/{id}", consumes = "multipart/form-data")
	public String uploadFile(ModelMap model, @PathVariable String id
			, @PathVariable String entity,  @RequestParam("photo") MultipartFile photo) 
	{
		if(photo.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}else{
			try {
				String filename = photo.getOriginalFilename();
				String photoPath = context.getRealPath("/resources/images/avatar/" + filename );
				photo.transferTo(new File(photoPath));
				model.addAttribute("photo_name", filename );
				model.addAttribute("cv_size", photo.getSize());
				if(entity.equals("account")) {
					userDao.updateAvatar(id, filename );
					System.out.println("cap nhat user avatar");
					return "redirect:/user/profile/" + id  +".html";
				}
				else if(entity.equals("employee"))
				{
					staffDao.updateAvatar(Integer.valueOf(id), filename );
					System.out.println("cap nhat staff avatar");
					return "redirect:/staff/profile/" + id  +".html";
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}

		return "redirect:/user/profile/" + id  +".html";
	}
}
