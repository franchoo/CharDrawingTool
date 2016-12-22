package com.hugeinc.java.chartool.command.impl;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.hugeinc.java.chartool.CharCanvas;

public class CharRectangleCmdTest {

	@Test
	public void testExec() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(19, 13);
		CharRectangleCmd cmd;
		Point p1, p2;
		// #1
		p1 = new Point(2, 2);
		p2 = new Point(16, 10);
		cmd = new CharRectangleCmd(p1, p2);
		cmd.exec(canvas);
		assertNotEquals('x', canvas.get(0, 0));
		assertNotEquals('x', canvas.get(6, 6));
		assertEquals('x', canvas.get(2, 10));
		assertEquals('x', canvas.get(16, 2));
		assertEquals('x', canvas.get(9, 2));
		// #2
		p2.move(13, 13);
		try {
			cmd.exec(canvas);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
