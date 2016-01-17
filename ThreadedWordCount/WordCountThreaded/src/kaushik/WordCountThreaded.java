package kaushik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCountThreaded {

	public static void main(String[] args) throws InterruptedException{
		//System.out.println(calculateWords("src/testFiles/test5.txt"));
	}

	// To avoid UTF-8 characters, hard coded the accepted character
	private static String[] myAcceptedChars = { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z", "_", "-", ",", ";", "'", "(",
			")", "!", ".", "[", "]" };
	// Storing the accepted characters as Set
	static Set<String> myAcceptedSet = new HashSet<String>(
			Arrays.asList(myAcceptedChars));
	
	//Array for thread
	public static ArrayList<String[]> myStringFile = new ArrayList<String[]>();
	
	// myword integer to count word
	public static int myWords = 0;

	public  int calculateWords(String file) throws InterruptedException {
		//Setting count to 0
		myWords = 0;
		// Count lines for threading
		int lines = 0;	
	
		try {
			String sCurrentLine;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = reader.readLine()) != null){
				String trimmed = sCurrentLine.trim();
				myStringFile.add((String[]) (trimmed.trim().split("\\s+")));
				lines++;
			}

			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println("Total lines to process are " + lines);

		if (lines > 3) {
			//Lets create 4 threads
			Thread[] thrd = new Thread[4];
			int myThreadModValue = lines/4;
			int threadStartValue = 0;
			for (int i = 0; i < 4; i++) {
				if(i != 3){
					int threadLastValue = threadStartValue+myThreadModValue;
					//System.out.println("Nos "+i+ " thread has started from = "+ threadStartValue+" till "+ threadLastValue);
					thrd[i] = new MyThread(threadStartValue,threadLastValue);
                  	thrd[i].start(); //thread start
                 	 
                  	thrd[i].join(); // joining threads wait until all thread complete their work
					threadStartValue = threadLastValue;
				}
				else{
					//System.out.println("Nos "+i+ " thread has started from = "+ threadStartValue+" End "+ lines);
					thrd[i] = new MyThread(threadStartValue,lines);
                  	thrd[i].start(); //thread start                 	 
                  	thrd[i].join(); // joining threads wait until all thread complete their work
					
				}
				
			}
		} else {
			BufferedReader br = null;

			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(file));
				while ((sCurrentLine = br.readLine()) != null) {
					// String[] myArrayOfSrng = sCurrentLine.split(" ");
					String trimmed = sCurrentLine.trim();
					String[] myArrayOfSrng = (String[]) (trimmed.trim()
							.split("\\s+"));
					myWords += countWords(myArrayOfSrng);

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
		}
		return myWords;

	}

	private static int countWords(String[] s) {

		int wordCount = 0;
		for (int i = 0; i < s.length; i++) {
			boolean myCheck = false;
			char[] myChar = s[i].toCharArray();
			for (int j = 0; j < myChar.length; j++) {
				if (myAcceptedSet.contains("" + myChar[j])) {
					myCheck = true;
				} else {
					myCheck = false;
					break;
				}
			}
			if (myCheck) {
				wordCount++;
			}
		}

		return wordCount;
	}
}
