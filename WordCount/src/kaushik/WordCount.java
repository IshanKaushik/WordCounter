package kaushik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class WordCount {
	
	// To avoid UTF-8 characters, hard coded the accepted character 
	private static String[] myAcceptedChars = { "a", "b", "c", "d", "e", "f", "g", "h",
			"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
			"v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z","_","-" };
	// Storing the accepted characters as Set
	static Set<String> myAcceptedSet = new HashSet<String>(Arrays.asList(myAcceptedChars));

	public static int calculateWords(String file) {
		// myword integer to count word
		int myWords = 0;
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				// Processing each line at a time, this approach can be use to scale 
				// application while running it in parallel manner.
				// While counter would be global in this case myWord, hence 
				// it can be updated by any thread and would be thread safe.
				String myUpdatedString = "";
				// Removing unwanted characters and recreating the string
				for (int j = 0; j < sCurrentLine.length(); j++) {
					String m = "" + sCurrentLine.charAt(j);
					if (myAcceptedSet.contains(m)) {
						myUpdatedString += m;
					} else {
						myUpdatedString += " ";
					}
				}
				myWords += countWords(myUpdatedString);
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
		 return myWords;
		
	}

	private static int countWords(String s) {

		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			char d = s.charAt(i);
			// Checking for current letter being a word, set isWord to true
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				isWord = true;
				// Monitoring end of a letter and increasing the count
			} else if (!Character.isLetter(s.charAt(i)) && isWord) {
				wordCount++;
				isWord = false;
				// Monitoring end of line and incrementing the count
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}

		}

		return wordCount;
	}
}
