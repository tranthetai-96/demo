package dao;

import java.util.List;

import model.Staff;
import pojo.Pagination;

public interface StaffDao {
	List<Staff> getAllStaffs();
	List<Staff> getAllStaffs(int page);
	Staff getStaffById(int id);
	void saveStaff(Staff staff);
	void updateStaff(Staff staff);
	void deleteStaff(int staffId);
	void updateAvatar(int id, String filename);
	Pagination getPagination(int current);
}
