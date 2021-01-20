package Min;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class MinTC {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test 
	void test()  { //리스트 선언만 한 경우
		ArrayList<String> list = new ArrayList<String>();
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Min.min");
	}
	
	@Test
	void test2() { //여러 요소가 담긴 리스트 안에 null이 포함된 경우
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add(null);
		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("Min.min");
	}
	
	@Test
	void test3() { //리스트 안에 null 하나만 있는 경우
		ArrayList<String> list = new ArrayList<String>();
		list.add(null);
		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("Min.min");
	}
	
	@Test
	void test4() { //리스트안에 null 여러 개 있는 경우
		ArrayList<String> list = new ArrayList<String>();
		list.add(null);
		list.add(null);
		list.add(null);
		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("Min.min");
	}
	
	@Test
	void test5() { //정수값 하나만 있는 경우
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		assertEquals(1, Min.min(list));
	}
	
	@Test
	void test6() { //정수값이 여러개인 경우
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(100);
		list.add(50);
		assertEquals(10, Min.min(list));
	}
	
	@Test
	void test7() { //test6에 입력값을 순서 바꿈
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(50);
		list.add(10);
		list.add(100);
		assertEquals(10, Min.min(list));
	}
	
	@Test
	void test8() { //문자열에 대해서 테스트
		ArrayList<String> list = new ArrayList<String>();
		list.add("elephant");
		list.add("monkey");
		list.add("apple");
		assertEquals("apple", Min.min(list));
	}
}
