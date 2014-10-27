package pl.edu.pk.plagiarism.daoImpl;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.edu.pk.plagiarism.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

	@Inject
	protected SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
