package Largest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LargestTC {

	@Test
	void test() {
		assertEquals(9, Largest.largest(new int[] {7, 8, 9}));
	}
	
	@Test
	void test2() {
		assertEquals(9, Largest.largest(new int[] {9, 8, 7}));
	}
	
	@Test
	void test3() {
		assertEquals(9, Largest.largest(new int[] {7, 9, 8}));
	}

}
