package dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import model.Record;
import model.Staff;
import util.HibernateUtil;

@Component
public class RecordDaoImpl implements RecordDao {

	@Override
	public Record getRecordById(int recordId) {
		Record record = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		record = (Record) session.get(Record.class, recordId);
		session.getTransaction().commit();
		return record;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getAllRecords() {
		List<Record> lstRecord = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		lstRecord = session.createQuery("from Record").list();
		session.getTransaction().commit();
		return lstRecord;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getAllRecords(boolean type) {
		List<Record> lstRecord = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		lstRecord = session.createQuery("from Record r where r.recordType = :type")
										.setParameter("type", type)
										.list();
		session.getTransaction().commit();
		return lstRecord;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getRecordsOfStaff(Staff staff) {
		List<Record> lstRecord = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		lstRecord = session.createQuery("from Record r where r.staff.staffId = :staffId")
							.setParameter("staffId", staff.getStaffId())
							.list();
		session.getTransaction().commit();
		return lstRecord;
	}

	@Override
	public void saveRecord(Record record) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(record);
		session.getTransaction().commit();
	}

	@Override
	public void updateRecord(Record record) {
		saveRecord(record);

	}

	@Override
	public void deleteRecord(Record record) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(record);
		session.getTransaction().commit();
	}

}
