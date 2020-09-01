package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import model.User;
import util.HibernateUtil;

@Component
public class UserDaoImpl implements UserDao{
	
	/**
	 * Lấy tất cả users
	 * @return danh sách users
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> lstUser = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		lstUser = query.list();
		session.getTransaction().commit();
		return lstUser;
	}
	/**
	 * Lấy user theo username
	 * @param username 
	 * @return user
	 */
	@Override
	public User getUserById(String Id) {
		User account = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		account = (User) session.get(model.User.class, Id);
		session.getTransaction().commit();
		return account;
	}
	/**
	 * Lưu một user vào db
	 * @param user
	 */
	@Override
	public void saveUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		
	}
	/**
	 * Cập nhật user
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		saveUser(user);
		
	}
	/**
	 * Xóa user
	 * @param user
	 */
	@Override
	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();		
	}
	
	@Override
	public void updateAvatar(String username, String filename) {
		User account = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		account = (User) session.get(model.User.class, username);
		account.setImg(filename);
		session.getTransaction().commit();	
	}
}
