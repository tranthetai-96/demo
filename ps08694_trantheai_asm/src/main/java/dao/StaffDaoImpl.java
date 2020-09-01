package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import model.Staff;
import model.User;
import pojo.Pagination;
import util.HibernateUtil;

@Component
public class StaffDaoImpl implements StaffDao {
	
	public static int maxRow = 5;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getAllStaffs() {
		List<Staff> lstStaff = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		lstStaff = session.createQuery("from Staff s where s.deleted = false").list();
		session.getTransaction().commit();
		return lstStaff;
	}
	@Override
	public void updateAvatar(int id, String filename) {
		Staff staff = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		staff = (Staff) session.get(model.Staff.class, id);
		staff.setPhoto(filename);
		session.getTransaction().commit();	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getAllStaffs(int page) {
		List<Staff> lstStaff = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Staff s where s.deleted = false");
		query.setFirstResult(getFirstRow(page));
		query.setMaxResults(maxRow);
		lstStaff = query.list();
		session.getTransaction().commit();
		return lstStaff;
	}
	
	@Override
	public Pagination getPagination(int current) {
		Pagination pagination = new Pagination(current);
		int rows = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(s) from Staff s where s.deleted = false");
	    rows =  ((Number) query.uniqueResult()).intValue();
		session.getTransaction().commit();
		pagination.setRows(rows);
		pagination.setMax(maxRow);
		return pagination;
	}
	
	public int getFirstRow(int page) {
		return (page * maxRow) - maxRow;
	}

	@Override
	public Staff getStaffById(int Id) {
		Staff staff = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		staff = (Staff) session.get(Staff.class, Id);
		Hibernate.initialize(staff.getRecords());
		session.getTransaction().commit();
		return staff;
	}

	@Override
	public void saveStaff(Staff staff) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(staff);
		session.getTransaction().commit();
	}

	@Override
	public void updateStaff(Staff staff) {
		saveStaff(staff);

	}

	@Override
	public void deleteStaff(int staffId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Staff staff = (Staff) session.get(Staff.class, staffId);
		staff.setDeleted(true);
		session.getTransaction().commit();
	}

}
