package pl.edu.pk.plagiarism.service;

import java.util.List;

import pl.edu.pk.plagiarism.dao.UserDao;
import pl.edu.pk.plagiarism.vo.UserVo;

public interface UserService {

	void addUser(UserVo UserVo);

	void deleteUser(UserVo UserVo);

	void updateUser(UserVo UserVo);

	UserVo getUserById(int id);

	List<UserVo> getUsers();

	UserDao getUserDao();

}
