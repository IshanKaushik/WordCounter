package kaushik;

import java.util.ArrayList;

public class MyThread extends Thread {
	private int startIdx, endIdx;
	// Array for thread
	ArrayList<String[]> myStringFile = WordCountThreaded.myStringFile;

	public MyThread(int s, int n) {
		this.startIdx = s;
		this.endIdx = n;
	}

	@Override
	public void run() {
		for (int k = this.startIdx; k < this.endIdx; k++) {
			// countWords(myStringFile.get(i));
			String[] s = myStringFile.get(k);
			int wordCount = 0;
			for (int i = 0; i < s.length; i++) {
				boolean myCheck = false;
				char[] myChar = s[i].toCharArray();
				for (int j = 0; j < myChar.length; j++) {
					// System.out.println(myChar[j]);
					if (WordCountThreaded.myAcceptedSet.contains("" + myChar[j])) {
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

			WordCountThreaded.myWords += wordCount;
		}
	}

}