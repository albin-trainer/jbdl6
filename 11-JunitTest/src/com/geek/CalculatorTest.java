package com.geek;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.geek.exception.InvalidInputException;
class CalculatorTest {
	public CalculatorTest() {
		System.out.println("test class constructor");
	}
	static Calculator c=null;
//	@BeforeEach //runs before each test case
//	public void init() {
//		c=new Calculator();
//		System.out.println("init");
//	}
	@BeforeAll
	public static void initBeforeAll() {
		c=new Calculator();
		System.out.println("init before all ");
	}
	@Test
	void testAdd() {
		System.out.println("test add");
		int result=c.add(1,2,3,4,5);
		assertEquals(15, result);
	}
	@Test
	void testProduct() {
		System.out.println("test prod");
		int result=c.product(3*3*5);
		assertEquals(45, result);
	}
	@Test
	void testDiv() {
		int r=c.div(10, 2);
		assertEquals(5, r);
	}
	@ParameterizedTest
	@CsvSource({"5,5,10","4,8,12","9,8,17"})
	public void testWithMultipleParams(int x,int y,int r) {
		int result=c.add(x, y);
		assertEquals(r, result);
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "fortest.csv",numLinesToSkip = 1)
	public void testWithMultipleParamsWithFile(int x,int y,int r) {
		int result=c.add(x, y);
		assertEquals(r, result);
	}
	
	
	@Test
	void testDivNegative() {
		assertThrows(InvalidInputException.class, ()->c.div(10, 0));
	}

}
