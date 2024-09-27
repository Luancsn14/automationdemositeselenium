package com.lnovaes.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.lnovaes.tests.AlertsTests;
import com.lnovaes.tests.IframesTests;
import com.lnovaes.tests.RegisterTests;
import com.lnovaes.tests.WindowsTests;

@RunWith(Suite.class)
@SuiteClasses({
	RegisterTests.class,
	AlertsTests.class,
	WindowsTests.class,
	IframesTests.class
})
public class TestsSuite {

}
