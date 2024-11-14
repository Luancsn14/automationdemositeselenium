package com.lnovaes.tests.widgets;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.widgets.DatepickerPage;

public class DatepickerTests extends BaseTest {
	DatepickerPage datepickerPage = new DatepickerPage();
	Faker faker = new Faker();
	
	@Before
	public void start() {
		datepickerPage.accessDatepickerWindow();
	}
	
	@Test
	public void testDatePickerDisabled() {
		
		Date selectedDate = faker.date().between(datepickerPage.startDate(2014), datepickerPage.endDate(2034));
		
		SimpleDateFormat fd = new SimpleDateFormat("MM/dd/yyyy");
		
		Calendar c = Calendar.getInstance();
        c.setTime(selectedDate);        
        
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		datepickerPage.setDatePickerDisabled(year, month, day);
		
		Assert.assertEquals(fd.format(selectedDate), datepickerPage.getDatePickerDisabled());
	}
	
	@Test
	public void testDatePickerEnabledSelectingToday() {
		
		datepickerPage.clickToday();
		
		Date today = new Date();
		SimpleDateFormat f = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.ENGLISH);
		
		Assert.assertEquals("Select " + f.format(today), datepickerPage.getDatePickerEnabledHighlighted());		
	}
	
	@Test
	public void testDatePickerEnabledTyping() {
		
		Date selectedDate = faker.date().between(datepickerPage.startDate(2014), datepickerPage.endDate(2034));
		
		SimpleDateFormat fd = new SimpleDateFormat("MM/dd/yyyy"); 
        
        datepickerPage.typeDate(fd.format(selectedDate));
        
        Assert.assertEquals(fd.format(selectedDate), datepickerPage.getDatePickerEnabled());		
	}
	
	@Test
	public void testDatePickerEnabledClicking() {
		
        Date selectedDate = faker.date().between(datepickerPage.startDate(2014), datepickerPage.endDate(2034));
		
		SimpleDateFormat fd = new SimpleDateFormat("MM/dd/yyyy");
		
		Calendar c = Calendar.getInstance();
        c.setTime(selectedDate);        
        
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		datepickerPage.setDatePickerEnabledClicking(year, month, day);
		
		Assert.assertEquals(fd.format(selectedDate), datepickerPage.getDatePickerEnabled());
	}
}
