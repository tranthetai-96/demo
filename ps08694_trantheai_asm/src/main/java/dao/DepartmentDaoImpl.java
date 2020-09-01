package dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import model.Department;
import util.HibernateUtil;

@Component
public class DepartmentDaoImpl implements DepartmentDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		List<Department> lstDepartment = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		lstDepartment = session.createQuery("from Department").list();
		session.getTransaction().commit();
		return lstDepartment;
	}

	@Override
	public Department getDepartmentById(String Id) {
		Department department = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		department = (Department) session.get(Department.class, Id);
		session.getTransaction().commit();
		return department;
	}

	@Override
	public void saveDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(department);
		session.getTransaction().commit();
	}

	@Override
	public void updateDepartment(Department department) {
		saveDepartment(department);
		
	}

	@Override
	public void deleteDepartment(String departId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Department depart = (Department) session.get(Department.class, departId);
		depart.setStatus(true);
		session.getTransaction().commit();
	}

}
