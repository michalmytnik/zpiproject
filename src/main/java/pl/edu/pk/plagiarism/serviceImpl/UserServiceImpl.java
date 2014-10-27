package pl.edu.pk.plagiarism.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pk.plagiarism.dao.UserDao;
import pl.edu.pk.plagiarism.entities.User;
import pl.edu.pk.plagiarism.service.UserService;
import pl.edu.pk.plagiarism.vo.UserVo;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao UserDao;

	@Override
	@Transactional(readOnly = false)
	public void addUser(UserVo UserVo) {

		User User = new User();
		BeanUtils.copyProperties(UserVo, User);
		getUserDao().addUser(User);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(UserVo UserVo) {
		User User = new User();
		BeanUtils.copyProperties(UserVo, User);
		getUserDao().deleteUser(User);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(UserVo UserVo) {
		User User = new User();
		BeanUtils.copyProperties(UserVo, User);
		getUserDao().updateUser(User);
	}

	@Override
	public UserVo getUserById(int id) {
		User User = getUserDao().getUserById(id);
		UserVo UserVo = new UserVo();
		BeanUtils.copyProperties(User, UserVo);
		return UserVo;
	}

	@Override
	public List<UserVo> getUsers() {
		List<User> UserList = getUserDao().getUsers();

		List<UserVo> UserVoList = new ArrayList<UserVo>();

		for (User cust : UserList) {
			UserVo custVo = new UserVo();
			BeanUtils.copyProperties(cust, custVo);
			UserVoList.add(custVo);
		}

		return UserVoList;

	}

	@Override
	public UserDao getUserDao() {
		return UserDao;
	}

	public void setUserDao(UserDao UserDao) {
		this.UserDao = UserDao;
	}
}