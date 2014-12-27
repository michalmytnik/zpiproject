package pl.edu.pk.plagiarism.utils;

public class ComparisonStorage {
	
	private int levenstheinDistance;
	private int textSimilarity;
	private int pecentageOfMatchRows;
	private int pecentageOfWordMatchWords;
	private double levenstheinDistanceBinary;
	private String fileName;
	
	
	public int getLevenstheinDistance() {
		return levenstheinDistance;
	}
	public void setLevenstheinDistance(int levenstheinDistance) {
		this.levenstheinDistance = levenstheinDistance;
	}
	public int getTextSimilarity() {
		return textSimilarity;
	}
	public void setTextSimilarity(int textSimilarity) {
		this.textSimilarity = textSimilarity;
	}
	public int getPecentageOfMatchRows() {
		return pecentageOfMatchRows;
	}
	public void setPecentageOfMatchRows(int pecentageOfMatchRows) {
		this.pecentageOfMatchRows = pecentageOfMatchRows;
	}
	public int getPecentageOfWordMatchWords() {
		return pecentageOfWordMatchWords;
	}
	public void setPecentageOfWordMatchWords(int pecentageOfWordMatchWords) {
		this.pecentageOfWordMatchWords = pecentageOfWordMatchWords;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getLevenstheinDistanceBinary() {
		return levenstheinDistanceBinary;
	}
	public void setLevenstheinDistanceBinary(double levenstheinDistanceBinary) {
		this.levenstheinDistanceBinary = levenstheinDistanceBinary;
	}

	


}
