package pl.edu.pk.plagiarism.service;

import java.util.List;

import pl.edu.pk.plagiarism.entities.File;

public interface FileService {
	
	public boolean addFile( String name , String path);
	
	public List<File> getFiles();

}
