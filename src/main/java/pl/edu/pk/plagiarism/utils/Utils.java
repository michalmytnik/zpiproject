package pl.edu.pk.plagiarism.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Utils {
	
	public final String UPLOADED_FILE_PATH = "D:\\studiaIIstopien\\ZPI\\baza_tresci\\";
	
	//UNUSED
	public String getRepositoryPath(){
		try {
			InputStream istream = getClass().getResourceAsStream("properties.xml");
//			File file = new File("..\\properties.xml");
//			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(istream);
			istream.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "D:\\studia II stopie�\\ZPI\\baza_tresci\\";
	}

}
