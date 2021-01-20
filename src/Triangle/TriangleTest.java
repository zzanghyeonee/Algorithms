package Triangle;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.rules.ExpectedException;

class TriangleTest {
	
	public ExpectedException expectedException = ExpectedException.none();
	
	@ParameterizedTest
	@CsvSource({" , ,"})
	void test1(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		expectedException.expect(NumberFormatException.class);
		expectedException.expectMessage("Usage: java Quadrangle <side1:int> <side2:int> <side3:int>");
	}
	
	@ParameterizedTest
	@CsvSource({"2,3,4"})
	void test2(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("scalene",tri.classify());
	}
	
	@ParameterizedTest
	@CsvSource({"3,4,5"})
	void test3(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("right-angled", tri.classify());
		assertEquals(6,tri.getArea());
	}
	
	@ParameterizedTest
	@CsvSource({"3,3,3"})
	void test4(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("equilateral", tri.classify());
	}
	
	@ParameterizedTest
	@CsvSource({"3,3,5"})
	void test5(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("isossceles", tri.classify());
	}
	
	@ParameterizedTest
	@CsvSource({"0,1,2"})
	void test6(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("impossible", tri.classify());
	}
	
	@ParameterizedTest
	@CsvSource({"a,b,c"})
	void test7(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		expectedException.expect(NumberFormatException.class);
		expectedException.expectMessage("Usage: java Quadrangle <side1:int> <side2:int> <side3:int>");
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,3"})
	void test8(String a, String b, String c) {
		Triangle tri = new Triangle(Integer.parseInt(a),Integer.parseInt(b), Integer.parseInt(c));
		assertEquals("impossible", tri.classify());
	}

}
