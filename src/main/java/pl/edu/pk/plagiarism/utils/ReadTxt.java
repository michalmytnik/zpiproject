import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxt {
	private static String text = "";

	public String parseTxt(String path) throws IOException {

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));

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