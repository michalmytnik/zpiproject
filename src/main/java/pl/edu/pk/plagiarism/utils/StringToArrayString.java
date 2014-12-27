package pl.edu.pk.plagiarism.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringToArrayString {

	private BufferedReader buffer;

	public String[] arrayOfString(String text) {

		String[] arr = null;
		List<String> itemsSchool = new ArrayList<String>();

		try {
			FileInputStream fstream_school = new FileInputStream(text);
			DataInputStream data_input = new DataInputStream(fstream_school);
			buffer = new BufferedReader(new InputStreamReader(data_input));
			String str_line;

			while ((str_line = buffer.readLine()) != null) {
				str_line = str_line.trim();
				if ((str_line.length() != 0)) {
					itemsSchool.add(str_line);
				}
			}

			arr = (String[]) itemsSchool
					.toArray(new String[itemsSchool.size()]);

			// System.out.println(Arrays.toString(arr));
		} catch (Exception e) {
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return arr;

	}

}
