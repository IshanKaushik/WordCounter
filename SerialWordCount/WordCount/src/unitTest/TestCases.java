package unitTest;

import static org.junit.Assert.*;
import kaushik.WordCount;
import org.junit.Test;

public class TestCases {

	@Test
	public void test() {
		WordCount wc = new WordCount(); 
		int returnCount = wc.calculateWords("src/testFiles/test3.txt");
		assertEquals(2,returnCount);
	}
	
	@Test
	public void test2() {
		WordCount wc = new WordCount();
		int returnCount = wc.calculateWords("src/testFiles/test2.txt");
		assertEquals(4,returnCount);
	}
	
	@Test
	public void test3() {
		WordCount wc = new WordCount();
		int returnCount = wc.calculateWords("src/testFiles/test1.txt");
		assertEquals(13,returnCount);
	}

	
	@Test
	public void test4() {
		WordCount wc = new WordCount();
		int returnCount = wc.calculateWords("src/testFiles/test4.txt");
		assertEquals(7313,returnCount);
	}

}
