package com.lnovaes.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.lnovaes.tests.register.RegisterTests;
import com.lnovaes.tests.switchto.AlertsTests;
import com.lnovaes.tests.switchto.IframesTests;
import com.lnovaes.tests.switchto.WindowsTests;
import com.lnovaes.tests.widgets.AccordionTests;
import com.lnovaes.tests.widgets.AutoCompleteTests;
import com.lnovaes.tests.widgets.DatepickerTests;

@RunWith(Suite.class)
@SuiteClasses({
	RegisterTests.class,
	AlertsTests.class,
	WindowsTests.class,
	IframesTests.class,
	AccordionTests.class,
	AutoCompleteTests.class,
	DatepickerTests.class
})
public class TestsSuite {

}
