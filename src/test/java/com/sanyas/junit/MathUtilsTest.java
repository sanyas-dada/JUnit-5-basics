package com.sanyas.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	TestInfo testInfo;
	TestReporter testReporter;
	MathUtils mathUtils;
	
	
	/*
	 * @BeforeAll void beforeAllinint() {
	 * System.out.println(" this need sto run before all"); }
	 */
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		
		//System.out.println("Runnig:" +testInfo.getDisplayName()+"with tags" +testInfo.getTags());
		//testReporter.publishEntry("Running" +testInfo.getDisplayName()+" with tags" +testInfo.getTags());
	}
	/*
	 * @AfterEach void cleanup() { System.out.println("Cleaning up>>>>"); }
	 */
	@Nested
	@Tag("Math")
	class add{
		@Test
		@DisplayName("when adding positive number")
		void testPositiveNumber() {
			//System.out.println("This is test running");
			// Junit hack can be used as a runner!
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected,actual, "the add method should add two numbers");
		}
		@Test
		@DisplayName("when adding negative number ")
		void testNegativeNumber() {
			//System.out.println("This is test running");
			// Junit hack can be used as a runner!
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			assertEquals(expected,actual, "the add method should add two numbers");
		}
	}
	
	@Test
	@DisplayName("multiply method")
	@Tag("Math")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4,mathUtils.mul(2,2)),
				() -> assertEquals(0,mathUtils.mul(2,0)),
				() -> assertEquals(-2,mathUtils.mul(2,-1)),
				() -> assertEquals(-2,mathUtils.mul(2,-1))
				);
	}
	@Test
	@Tag("Math")
	void testDivideRules() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		//assertThrows(NullPointerException.class,() -> mathUtils.divide(1, 0),"Divide by zero");
		assertThrows(ArithmeticException.class,() -> mathUtils.divide(1, 0),"Divide by zero");
	}
	
	@RepeatedTest(2)
	@DisplayName("area Of the Circle")
	@Tag("Circle")
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
