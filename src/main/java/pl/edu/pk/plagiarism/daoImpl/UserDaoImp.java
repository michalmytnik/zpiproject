package pl.edu.pk.plagiarism.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.edu.pk.plagiarism.dao.UserDao;
import pl.edu.pk.plagiarism.entities.User;

@Repository
public class UserDaoImp extends BaseDaoImpl implements UserDao {

	@Override
	public void addUser(User User) {
		sessionFactory.getCurrentSession().save(User);
	}

	@Override
	public void deleteUser(User User) {
		sessionFactory.getCurrentSession().delete(User);
	}

	@Override
	public void updateUser(User User) {
		sessionFactory.getCurrentSession().update(User);
	}

	@Override
	public User getUserById(int id) {
		
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.idEq(id));
		return  (User) criteria.uniqueResult();	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {

		Criteria criteria = getSession().createCriteria(User.class);		
		return criteria.list();
	}
}