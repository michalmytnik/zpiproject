package pl.edu.pk.plagiarism.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TextComparison {

	public static void main(String[] args) {

		StringToArrayString b = new StringToArrayString();
//		System.out.println(Arrays.toString(b.arrayOfStrinh("text1.txt")));
//		System.out.println(Arrays.toString(b.arrayOfStrinh("text2.txt")));
		String txt1 = Arrays.toString(b.arrayOfString("text1.txt"));
		String txt2 = Arrays.toString(b.arrayOfString("text2.txt"));
//		System.out.println(txt1+" "+txt2);
		
		System.out.println("Odległość levenshteina = "+ levenstheinDistance(txt1,txt2)+" %");
		System.out.println("Procentowe podobiensto tekstu = "+textSimilarity(txt1,txt2)+" %");
		System.out.println("Procentowe podobiensto (wersów w tekscie ?) = "+pecentageOfMatchRows(b.arrayOfString("text1.txt"), b.arrayOfString("text2.txt"))+" %");
		System.out.println("Procentowe podobienstwo wyrazów = "+ pecentageOfWordMatchWords(txt1,txt2)+" %");
		
	} 
	

	public static int pecentageOfMatchRows(String[] as0, String[] as1) {
		int n = as0.length;
		Integer temp = null;

		// String frequency of as0
		HashMap<String, Integer> hm0 = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			temp = hm0.get(as0[i]);
			if (temp == null) {
				hm0.put(as0[i], new Integer(1));
			} else {
				hm0.put(as0[i], new Integer(temp.intValue() + 1));
			}
		}

		// String frequency of as1
		n = as1.length;
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			temp = hm1.get(as1[i]);
			if (temp == null) {
				hm1.put(as1[i], new Integer(1));
			} else {
				hm1.put(as1[i], new Integer(temp.intValue() + 1));
			}
		}

		// Frequency difference between hm0 and hm1 to diff
		HashMap<String, Integer> diff = new HashMap<String, Integer>();
		String key;
		Integer value, value1, rval;
		Iterator<Entry<String, Integer>> it = hm0.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>) it
					.next();
			key = pairs.getKey();
			value = pairs.getValue();
			value1 = hm1.get(key);
			it.remove();
			hm1.remove(key);
			if (value1 != null)
				rval = new Integer(Math.abs(value1.intValue()
						- value.intValue()));
			else
				rval = value;
			diff.put(key, rval);
		}

		// Sum all remaining String frequencies in hm1
		int val = 0;
		it = hm1.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>) it
					.next();
			val += pairs.getValue().intValue();
		}

		// Sum all frequencies in diff
		it = diff.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>) it
					.next();
			val += pairs.getValue().intValue();
		}

		// Calculate word match percentage
		int per = (int) ((((float) val * 100)) / ((float) (as0.length + as1.length)));
		per = 100 - per;
		return per;
	}
	
	
	  public static int pecentageOfWordMatchWords(String s0, String s1) {
	        // Trim and Replace all . ? ! with spaces to make easy to split to words 
	        s0 = s0.trim().replaceAll("[.?!]", " ");
	        s1 = s1.trim().replaceAll("[.?!]", " ");
	        //Split by space
	        String[] as0 = s0.split(" ");
	        String[] as1 = s1.split(" ");
	        return pecentageOfMatchRows(as0, as1);
	    }
	  
	  public static int levenstheinDistance(String s0, String s1) {
	        // Trim and Replace all . ? ! with ". " to make easy to split to sentences
	        s0 = s0.trim().replaceAll("[.?!]", ". ");
	        s1 = s1.trim().replaceAll("[.?!]", ". ");
	        //Split by ". "
	        String[] as0 = s0.split("(?i)(?<=[.])\\s+(?=[a-zA-Z])");
	        String[] as1 = s1.split("(?i)(?<=[.])\\s+(?=[a-zA-Z])");
	        return pecentageOfMatchRows(as0, as1);
	    }
	  
	  
	  public static int LevenshteinDistance(String s0, String s1) {

	        int len0 = s0.length() + 1;
	        int len1 = s1.length() + 1;

	        // the array of distances
	        int[] cost = new int[len0];
	        int[] newcost = new int[len0];

	        // initial cost of skipping prefix in String s0
	        for (int i = 0; i < len0; i++)
	            cost[i] = i;

	        // dynamicaly computing the array of distances

	        // transformation cost for each letter in s1
	        for (int j = 1; j < len1; j++) {

	            // initial cost of skipping prefix in String s1
	            newcost[0] = j - 1;

	            // transformation cost for each letter in s0
	            for (int i = 1; i < len0; i++) {

	                // matching current letters in both strings
	                int match = (s0.charAt(i - 1) == s1.charAt(j - 1)) ? 0 : 1;

	                // computing cost for each transformation
	                int cost_replace = cost[i - 1] + match;
	                int cost_insert = cost[i] + 1;
	                int cost_delete = newcost[i - 1] + 1;

	                // keep minimum cost
	                newcost[i] = Math.min(Math.min(cost_insert, cost_delete),
	                        cost_replace);
	            }

	            // swap cost/newcost arrays
	            int[] swap = cost;
	            cost = newcost;
	            newcost = swap;
	        }

	        // the distance is the cost for transforming all letters in both strings
	        return cost[len0 - 1];
	    }
	  
	  
	  public static int textSimilarity(String s0, String s1) {
	        int percentage = 0;
	        // Trim and remove duplicate spaces
	        s0 = s0.trim().replaceAll("\\s+", " ");
	        s1 = s1.trim().replaceAll("\\s+", " ");
	        percentage=(int) (100 - (float) LevenshteinDistance(s0, s1) * 100 / (float) (s0.length() + s1.length()));
	        return percentage;
	    }
	  
	  

}
