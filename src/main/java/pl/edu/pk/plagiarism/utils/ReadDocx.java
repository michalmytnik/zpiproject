import java.io.*;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.POITextExtractor;

public class ReadDocx {
	String text = "";

	// public static void main(String[] args) {
	// }

	public String parseDocx(String docx) throws IOException {
		try {
			File inputFile = new File(docx);
			POITextExtractor extractor = ExtractorFactory
					.createExtractor(inputFile);
			System.out.println("Word Document Text: ");
			System.out.println("====================");
			text = extractor.getText();
			// System.out.println(extractor.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;
	}
}