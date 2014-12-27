package pl.edu.pk.plagiarism.utils;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ReadTxt {
	private static String text = "";

	public String parseTxt(String path) throws IOException {

		BufferedReader br = null;

		try {

			String sCurrentLine;

			
			
			br = new BufferedReader(new InputStreamReader(
	                  new FileInputStream(path), Charset.forName("ISO-8859-1")));
			while ((sCurrentLine = br.readLine()) != null) {
				text += sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return text;

	}

	// public static void main(String[] args) throws IOException {
	// System.out.println(new ReadTxt().parseTxt("file.txt"));
	//
	// }
}