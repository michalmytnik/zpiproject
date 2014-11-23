package pl.edu.pk.plagiarism.serviceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pk.plagiarism.dao.FileDao;
import pl.edu.pk.plagiarism.dao.UserDao;
import pl.edu.pk.plagiarism.entities.File;
import pl.edu.pk.plagiarism.service.FileService;

@Service
@Transactional(readOnly = true)
public class FileServiceImpl implements FileService {

	
	@Inject
	private FileDao fileDao;
	
	@Override
	@Transactional(readOnly = false)
	public boolean addFile(String name, String path) {
		File file = new File();
		file.setName(name);
		file.setPath(path);
		
		return getFileDao().addFile(file);
	}
	@Override
	public List<File> getFiles() {
		return getFileDao().getFiles();
	}
	public FileDao getFileDao() {
		return fileDao;
	}
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	
	
	


}
