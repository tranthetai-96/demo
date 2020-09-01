package dao;


import java.util.List;

import model.Department;

public interface DepartmentDao{
	List<Department> getAllDepartments();
	Department getDepartmentById(String Id);
	void saveDepartment(Department department);
	void updateDepartment(Department department);
	void deleteDepartment(String departId);
	
}
