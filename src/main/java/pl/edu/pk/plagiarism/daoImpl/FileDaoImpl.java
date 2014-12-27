package pl.edu.pk.plagiarism.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pl.edu.pk.plagiarism.dao.FileDao;
import pl.edu.pk.plagiarism.entities.File;

@Repository
public class FileDaoImpl extends BaseDaoImpl implements FileDao {

	@Override
	public boolean addFile(File file) {
		try
		{
		sessionFactory.getCurrentSession().save(file);
		return true;
		}
		catch( Exception e)
		{
			System.out.println("exception : " + e.getMessage());
		}
		return false;
	}

	
	public List<File> getFiles() {
		Criteria criteria = getSession().createCriteria(File.class);	
		return criteria.list();
	}
	
	public File getFileByName(String fileName)
	{
		Query query = getSession().createQuery("from File where name = :name ");
		query.setParameter("name", fileName);
		List<File> list = query.list();
		return list.get(0);
		
	}
	
	

}
