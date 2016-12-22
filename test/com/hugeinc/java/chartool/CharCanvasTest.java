package com.hugeinc.java.chartool;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharCanvasTest {

	@Test
	public void testContains() {
		CharCanvas canvas = new CharCanvas();
		try {
			canvas.contains(3, 3);
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}
		canvas.setup(5, 5);
		assertTrue(canvas.contains(3, 3));
		assertFalse(canvas.contains(3, 6));
	}

	@Test
	public void testGet() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(5, 5);
		assertEquals(' ', canvas.get(4, 4));
	}

	@Test
	public void testPut() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(5, 5);
		assertTrue(canvas.put(2, 2, 'o'));
		assertFalse(canvas.put(2, 2, 'o'));
		assertEquals('o', canvas.get(2, 2));
	}

	@Test
	public void testReplace() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(5, 5);
		assertTrue(canvas.replace(2, 2, 'o', ' '));
		assertEquals('o', canvas.get(2, 2));
		assertFalse(canvas.replace(2, 2, 'x', ' '));
		assertTrue(canvas.replace(2, 2, 'x', 'o'));
		assertEquals('x', canvas.get(2, 2));
	}

	@Test
	public void testSetup() {
		CharCanvas canvas = new CharCanvas();
		try{
		canvas.setup(1, -1);
		}catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		canvas.setup(5, 5);
		assertTrue(canvas.contains(3, 3));
	}

}
