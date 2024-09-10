package com.lnovaes.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.lnovaes.tests.RegisterTests;

@RunWith(Suite.class)
@SuiteClasses({
	RegisterTests.class
})
public class TestsSuite {

}
