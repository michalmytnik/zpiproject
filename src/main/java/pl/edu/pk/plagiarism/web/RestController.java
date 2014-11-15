package pl.edu.pk.plagiarism.web;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.pk.plagiarism.service.UserService;
import pl.edu.pk.plagiarism.vo.Status;
import pl.edu.pk.plagiarism.vo.UserVo;

@Controller
@RequestMapping("/User")
public class RestController implements Serializable {

	private static final long serialVersionUID = -2050042525534142020L;
	private static final Logger logger = Logger.getLogger(RestController.class);

	@Inject
	private UserService UserService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody UserVo getUser(@PathVariable("id") int id) {
		UserVo User = null;
		try {
			User = UserService.getUserById(id);
		} catch (Exception e) {
			logger.error(e);
		}
		return User;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addUser(@RequestBody UserVo User) {
		try {
			UserService.addUser(User);
			return new Status(1, "User added successfully.");
		} catch (Exception e) {
			logger.error(e);
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteUser(@PathVariable("id") int id) {
		
		UserVo User = new UserVo();
		User.setId(id);
		
		try {
			UserService.deleteUser(User);
			return new Status(1, "User deleted successfully.");
		} catch (Exception e) {
			logger.error(e);
			return new Status(0, e.toString());
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<UserVo> getUsers() {

		List<UserVo> UserList = null;
		try {
			UserList = UserService.getUsers();
			System.out.println(UserList);

		} catch (Exception e) {
			logger.error(e);
		}
		return UserList;
	}

	public UserService getUserService() {
		return UserService;
	}

	public void setUserService(UserService UserService) {
		this.UserService = UserService;
	}
	
	

}