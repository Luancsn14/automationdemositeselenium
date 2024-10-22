package com.lnovaes.tests.switchto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.switchto.WindowsPage;

public class WindowsTests extends BaseTest {
	WindowsPage windowsPage = new WindowsPage();
	
	@Before
	public void start() {
		windowsPage.accessWindowsWindow();		
	}
	
	@Test
	public void testOpenNewTabbedWindows() {
		windowsPage.accessOpenNewTabbedWindowsTab();
		
		Assert.assertEquals("_blank", windowsPage.getOpenNewTabbedWindowsTarget());
		
		windowsPage.clickOpenNewTabbedWindowsButton();
		windowsPage.accessNewWindow();

		Assert.assertEquals(2, windowsPage.getWindowsOpenedNumber());
		Assert.assertEquals("https://www.selenium.dev/", windowsPage.getWindowUrl());
	}
	
	@Test
	public void testOpenNewSeperateWindows() {
		windowsPage.accessOpenNewSeperateWindowsTab();
		
		Assert.assertEquals("newwindow()", windowsPage.getOpenNewSeparateWindowsOnclick());
		
		windowsPage.clickOpenNewSeparateWindowsButton();
		windowsPage.accessNewWindow();
		
		Assert.assertEquals(2, windowsPage.getWindowsOpenedNumber());
		Assert.assertEquals("https://www.selenium.dev/", windowsPage.getWindowUrl());		
	}
	
	@Test
	public void testOpenSeperateMultipleWindows() {
		windowsPage.accessOpenSeperateMultipleWindowsTab();
		
		Assert.assertEquals("multiwindow()", windowsPage.getOpenSeperateMultipleWindowsOnclick());
		
		windowsPage.clickOpenSeperateMultipleWindowsButton();
		
		Assert.assertEquals(3, windowsPage.getWindowsOpenedNumber());		
		Assert.assertTrue(windowsPage.getUrlsList().contains("https://demo.automationtesting.in/Index.html"));
		Assert.assertTrue(windowsPage.getUrlsList().contains("https://www.selenium.dev/"));      
	}
}
