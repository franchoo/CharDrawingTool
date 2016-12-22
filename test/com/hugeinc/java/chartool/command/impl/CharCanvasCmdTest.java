package com.hugeinc.java.chartool.command.impl;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

import com.hugeinc.java.chartool.CharCanvas;

public class CharCanvasCmdTest {

	@Test
	public void testExec() {
		CharCanvas canvas = new CharCanvas();
		CharCanvasCmd cmd = new CharCanvasCmd(new Dimension(20, 15));
		cmd.exec(canvas);
		assertFalse(canvas.contains(-1, -1));
		assertTrue(canvas.contains(0, 0));
		assertTrue(canvas.contains(19, 14));
		assertFalse(canvas.contains(19, 15));
		assertFalse(canvas.contains(20, 14));
	}

}
