package dao;

import java.util.List;

import model.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUserById(String Id);
	void saveUser(User user);
	void updateUser(User user);
	void updateAvatar(String username, String filename);
	void deleteUser(User user);
}
