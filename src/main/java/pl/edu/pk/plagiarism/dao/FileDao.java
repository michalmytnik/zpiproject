package pl.edu.pk.plagiarism.dao;

import java.util.List;

import pl.edu.pk.plagiarism.entities.File;

public interface FileDao {
	
	public boolean addFile(File file);	
	public List<File> getFiles();
	public File getFileByName(String fileName);

}
