package pl.edu.pk.plagiarism.utils;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ReadPDF {
	/** The original PDF that will be parsed. */
	// public static final String RESULT = "PdftoTxt.txt";
	// private String filePath = "file.pdf";
	private static String text = "";

	
	// PRZZYDA

	// public String parsePdf(String pdf, String txt) throws IOException {

	public String parsePdf(String pdf) throws IOException {
		PdfReader reader = new PdfReader(pdf);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		// PrintWriter out = new PrintWriter(new FileOutputStream(txt));
		TextExtractionStrategy strategy;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			strategy = (TextExtractionStrategy) parser.processContent(i,
					new SimpleTextExtractionStrategy());
			// out.println(strategy.getResultantText());
			text += strategy.getResultantText();

		}
		// out.flush();
		// out.close();
		reader.close();
		// System.out.println(text);
		return text;
	}
	// public static void main(String[] args) throws IOException {
	// System.out.println(new ReadPDF().parsePdf("file.pdf"));
	// }
}
