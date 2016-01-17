package unitTest;

import static org.junit.Assert.assertEquals;
import kaushik.WordCountThreaded;

import org.junit.Test;

public class ThreadedTestCases2 {

	//MultiThreading Testing
	
	@Test
	public void test5() throws InterruptedException{
		WordCountThreaded.myWords = 0;
		WordCountThreaded wc = new WordCountThreaded();
		int returnCount = wc.calculateWords("src/testFiles/test5.txt");
		assertEquals(23,returnCount);
	}

}
