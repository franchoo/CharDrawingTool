package com.hugeinc.java.chartool.command.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharCommandFactoryTest {

	@Test
	public void testGenerate() {
		try {
			CharCommandFactory.generate("XYZ");
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}
		try {
			CharCommandFactory.generate("C 25 ten");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertTrue(CharCommandFactory.generate("C 5 5") instanceof CharCanvasCmd);
		assertTrue(CharCommandFactory.generate("L 1 4 4 1") instanceof CharLineCmd);
		assertTrue(CharCommandFactory.generate("R 1 1 3 3") instanceof CharRectangleCmd);
		assertTrue(CharCommandFactory.generate("B 2 4 o") instanceof CharBucketCmd);
		assertNull(CharCommandFactory.generate("Q"));
	}

}
