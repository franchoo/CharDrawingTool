package com.hugeinc.java.chartool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hugeinc.java.chartool.command.impl.CharBucketCmdTest;
import com.hugeinc.java.chartool.command.impl.CharCanvasCmdTest;
import com.hugeinc.java.chartool.command.impl.CharCommandFactoryTest;
import com.hugeinc.java.chartool.command.impl.CharLineCmdTest;
import com.hugeinc.java.chartool.command.impl.CharRectangleCmdTest;

@RunWith(Suite.class)
@SuiteClasses({ CharCanvasTest.class, CharBucketCmdTest.class, CharCanvasCmdTest.class, CharCommandFactoryTest.class,
		CharLineCmdTest.class, CharRectangleCmdTest.class })
public class CharDrawingTestSuite {

}
