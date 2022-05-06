package com.sanyas.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	MathUtils mathUtils;
	
	
	/*
	 * @BeforeAll void beforeAllinint() {
	 * System.out.println(" this need sto run before all"); }
	 */
	
	@BeforeEach
	void init() {
		 mathUtils = new MathUtils();
	}
	/*
	 * @AfterEach void cleanup() { System.out.println("Cleaning up>>>>"); }
	 */
	
	@Test
	@DisplayName("testing add method")
	void test() {
		//System.out.println("This is test running");
		// Junit hack can be used as a runner!
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected,actual, "the add method should add two numbers");
	}
	@Test
	@DisplayName("multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4,mathUtils.mul(2,2)),
				() -> assertEquals(0,mathUtils.mul(2,0)),
				() -> assertEquals(-2,mathUtils.mul(2,-1)),
				() -> assertEquals(-2,mathUtils.mul(2,-1))
				);
	}
	@Test
	void testDivideRules() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		//assertThrows(NullPointerException.class,() -> mathUtils.divide(1, 0),"Divide by zero");
		assertThrows(ArithmeticException.class,() -> mathUtils.divide(1, 0),"Divide by zero");
	}
	
	@Test
	@DisplayName("area Of the Circle")
	void testComputeCircleRadius() {
		assertEquals(Math.PI,mathUtils.computeCircleArea(1),"this is the circle of the area ");
	}
	
	@Test
	@Disabled
	@DisplayName("shouldn't run")
	void testDisabled() {
		fail("This test should be disable");
	}

}
