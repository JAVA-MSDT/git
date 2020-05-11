package com.javamsdt.javaMaven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArithmeticTest {

	
	Arithmetic arithmetic = new Arithmetic();
	
    @Test
	public void addTest() {
		int i = 10;
		int x = 20;
		
		int actual = 30;
		int expected = arithmetic.add(i, x);
		
		assertEquals(expected, actual);
	}
	
}
