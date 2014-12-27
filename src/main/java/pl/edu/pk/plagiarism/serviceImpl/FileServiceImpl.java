package pl.edu.pk.plagiarism.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.pk.plagiarism.dao.FileDao;
import pl.edu.pk.plagiarism.dao.UserDao;
import pl.edu.pk.plagiarism.entities.File;
import pl.edu.pk.plagiarism.service.FileService;
import pl.edu.pk.plagiarism.utils.ComparisonStorage;
import pl.edu.pk.plagiarism.utils.ReadTxt;
import pl.edu.pk.plagiarism.utils.TextComparison;
import pl.edu.pk.plagiarism.utils.Utils;

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
	
	public File getFileByName(String fileName)
	{
		return getFileDao().getFileByName(fileName);
		
	}
	
	public Map<String,String> getAllTexts() throws IOException
	{
		List<File> allFiles = getFiles();
		Map<String,String> nameAndConent = new HashMap<String, String>();
		for ( File f : allFiles ){
			ReadTxt read = new ReadTxt();
			nameAndConent.put(f.getName(),read.parseTxt(f.getPath()));
		}
		
		for (Map.Entry<String,String> entry : nameAndConent.entrySet()) {
			  // do stuff
			}

		return nameAndConent;
	}
	
	public List<ComparisonStorage> compareFileToOthers( String fileName) throws IOException
	{
		List<File> files = getFiles();
		System.out.println("size of files " + files.size());
		List<ComparisonStorage> cs = new ArrayList<ComparisonStorage>();
		File mainFile = getFileByName(fileName);
		Map<String,String> namesAndTexts = getAllTexts();
		String mainText = namesAndTexts.get(fileName);
		for( File f : files)
		{
			System.out.println(f.getPath());
			if(!f.getName().equals(mainFile.getName()))
			{
				ComparisonStorage temp = new ComparisonStorage();
				temp.setFileName(f.getName());
				String textTocompare = namesAndTexts.get(f.getName());
				System.out.println("text to compare" + textTocompare);
				
				temp.setLevenstheinDistance(TextComparison.LevenshteinDistance(mainText, textTocompare));
				System.out.println("levensthein binary : " + ((temp.getLevenstheinDistance())/Math.max(mainText.length(), textTocompare.length())));
				temp.setLevenstheinDistanceBinary((temp.getLevenstheinDistance())/Math.max(mainText.length(), textTocompare.length()));
				temp.setTextSimilarity(TextComparison.textSimilarity(mainText, textTocompare));
				temp.setPecentageOfMatchRows(TextComparison.pecentageOfMatchRows(mainText.split(""), textTocompare.split("")));
				temp.setPecentageOfWordMatchWords(TextComparison.pecentageOfWordMatchWords(mainText, textTocompare));
				cs.add(temp);
				
				
			}
				
		}
		System.out.println("cs size()+ " + cs.size());
		return cs;
		
	}
	
	

	
	
	
	
	
	


}
