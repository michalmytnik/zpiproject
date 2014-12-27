package pl.edu.pk.plagiarism.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import pl.edu.pk.plagiarism.entities.File;
import pl.edu.pk.plagiarism.utils.ComparisonStorage;

public interface FileService {
	
	public boolean addFile( String name , String path);
	
	public List<File> getFiles();
	
	public Map<String,String> getAllTexts() throws IOException;
	
	public List<ComparisonStorage> compareFileToOthers (String fileName) throws IOException;

}
