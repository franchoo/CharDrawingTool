package com.hugeinc.java.chartool.command.impl;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import com.hugeinc.java.chartool.CharCanvas;

public class CharBucketCmdTest {

	@Test
	public void testExec() {
		CharCanvas canvas = new CharCanvas();
		canvas.setup(11, 3);
		canvas.put(5, 0, 'x');
		canvas.put(5, 1, 'x');
		canvas.put(5, 2, 'x');
		CharBucketCmd cmd;
		Point p;
		// #1
		p = new Point(6, 1);
		cmd = new CharBucketCmd(p, 'o');
		cmd.exec(canvas);
		assertEquals(' ', canvas.get(4, 0));
		assertEquals('x', canvas.get(5, 1));
		assertEquals('o', canvas.get(6, 2));
		assertEquals('o', canvas.get(10, 0));
		// #2
		p.move(13, 13);
		try {
			cmd.exec(canvas);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
