import java.io.*;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadDoc {
	private static String text = "";

	public String parseDoc(String doc) throws IOException {
		File file = null;
		WordExtractor extractor = null;
		try {

			file = new File(doc);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			HWPFDocument document = new HWPFDocument(fis);
			extractor = new WordExtractor(document);
			String[] fileData = extractor.getParagraphText();
			for (int i = 0; i < fileData.length; i++) {
				if (fileData[i] != null) {
					text = fileData[i];
					System.out.println(fileData[i]);
				}

			}
		} catch (Exception exep) {
		}
		return text;
	}

	// public static void main(String[] args) throws IOException {
	// System.out.println(new ReadDoc().parseDoc("file.doc"));
	// }

}