package pl.edu.pk.plagiarism.dao;

import java.util.List;

import pl.edu.pk.plagiarism.entities.User;

public interface UserDao {

	void addUser(User User);

	void deleteUser(User User);

	void updateUser(User User);

	User getUserById(int id);

	List<User> getUsers();
}
