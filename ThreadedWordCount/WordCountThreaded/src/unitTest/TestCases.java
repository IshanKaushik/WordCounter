package unitTest;

import static org.junit.Assert.assertEquals;
import kaushik.WordCountThreaded;

import org.junit.Test;

public class TestCases {

	@Test
	public void test() throws InterruptedException {
		WordCountThreaded.myWords = 0;
		WordCountThreaded wc = new WordCountThreaded();
		int returnCount = wc.calculateWords("src/testFiles/test1.txt");
		//System.out.println(returnCount);
		assertEquals(13,returnCount);
	}
	
	@Test
	public void test2() throws InterruptedException{
		WordCountThreaded.myWords = 0;
		WordCountThreaded wc = new WordCountThreaded();
		int returnCount = wc.calculateWords("src/testFiles/test2.txt");
		//System.out.println(returnCount);
		assertEquals(4,returnCount);
	}
	
	@Test
	public void test3() throws InterruptedException{
		WordCountThreaded.myWords = 0;
		WordCountThreaded wc = new WordCountThreaded();
		int returnCount = wc.calculateWords("src/testFiles/test3.txt");
		//System.out.println(returnCount);
		assertEquals(1,returnCount);
	}

}
