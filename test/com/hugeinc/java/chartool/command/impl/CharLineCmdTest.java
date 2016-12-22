package com.hugeinc.java.chartool.command.impl;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.hugeinc.java.chartool.CharCanvas;

public class CharLineCmdTest {

	@Test
	public void testExec() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(19, 13);
		CharLineCmd cmd;
		Point p1, p2;
		// #1
		p1 = new Point(0, 1);
		p2 = new Point(18, 1);
		cmd = new CharLineCmd(p1, p2);
		cmd.exec(canvas);
		assertNotEquals('x', canvas.get(0, 0));
		assertNotEquals('x', canvas.get(0, 2));
		assertEquals('x', canvas.get(0, 1));
		assertEquals('x', canvas.get(9, 1));
		assertEquals('x', canvas.get(18, 1));
		// #2
		p1.move(9, 0);
		p2.move(9, 12);
		cmd.exec(canvas);
		assertEquals('x', canvas.get(9, 0));
		assertEquals('x', canvas.get(9, 6));
		assertEquals('x', canvas.get(9, 12));
		assertNotEquals('x', canvas.get(8, 12));
		assertNotEquals('x', canvas.get(10, 12));
		// #3
		p2.move(9, 13);
		try {
			cmd.exec(canvas);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		// #4
		p2.move(15, 5);
		try {
			cmd.exec(canvas);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
