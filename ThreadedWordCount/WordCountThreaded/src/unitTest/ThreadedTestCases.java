package unitTest;

import static org.junit.Assert.assertEquals;
import kaushik.WordCountThreaded;

import org.junit.Test;

public class ThreadedTestCases {

	//MultiThreading Testing
	@Test
	public void test() throws InterruptedException{
		WordCountThreaded.myWords = 0;
		WordCountThreaded wc = new WordCountThreaded();
		int returnCount = wc.calculateWords("src/testFiles/test4.txt");
		assertEquals(6532,returnCount);
	}
}
