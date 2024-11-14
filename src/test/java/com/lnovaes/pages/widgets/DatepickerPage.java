package com.lnovaes.pages.widgets;

import java.util.Date;

import org.openqa.selenium.By;

import com.lnovaes.core.BasePage;

public class DatepickerPage extends BasePage {
	
	public void accessDatepickerWindow() {
		accessUrl("https://demo.automationtesting.in/Datepicker.html");
	}
	
	public void setDatePickerDisabled(int selectedYear, int selectedMonth, int selectedDay) {
		
		clickElement(By.id("datepicker1"));
		
		int currentYear = Integer.parseInt(getElementText(By.className("ui-datepicker-year")));
		int currentMonth = convertMonth(getElementText(By.className("ui-datepicker-month")));
		
		if(selectedYear == currentYear && selectedMonth == currentMonth) {
			waitElementVisibility(By.id("ui-datepicker-div"), 5);
			clickElement(By.xpath("//a[@class='ui-state-default'][text()='" + selectedDay + "']"));
		}
		else if(currentYear > selectedYear || (selectedYear == currentYear && currentMonth > selectedMonth)) {
			while(true) {
				waitElementVisibility(By.xpath("//a[@data-handler='prev']"), 5);
				clickElement(By.xpath("//a[@data-handler='prev']"));
				currentYear = Integer.parseInt(getElementText(By.className("ui-datepicker-year")));
				currentMonth = convertMonth(getElementText(By.className("ui-datepicker-month")));
				if(selectedYear == currentYear && currentMonth == selectedMonth) {
					break;
				}
			}				
			clickElement(By.xpath("//a[@class='ui-state-default'][text()='" + selectedDay + "']"));			
		}
		else if(currentYear < selectedYear || (selectedYear == currentYear && currentMonth < selectedMonth)) {
			while(true) {
				waitElementVisibility(By.xpath("//a[@data-handler='next']"), 5);
				clickElement(By.xpath("//a[@data-handler='next']"));
				currentYear = Integer.parseInt(getElementText(By.className("ui-datepicker-year")));
				currentMonth = convertMonth(getElementText(By.className("ui-datepicker-month")));
				if(selectedYear == currentYear && currentMonth == selectedMonth) {
					break;
				}
			}				
			clickElement(By.xpath("//a[@class='ui-state-default'][text()='" + selectedDay + "']"));			
		}
	}
	
	public String getDatePickerDisabled() {
		return getElementValue(By.id("datepicker1"));
	}
	
	public Date startDate(int year) {
		return setStartDate(year);
	}
	
	public Date endDate(int year) {
		return setEndDate(year);
	}
	
	public void typeDate(String date) {
		writeText(By.id("datepicker2"), date);		
	}
	
	public String getDatePickerEnabled() {
		return getElementValue(By.id("datepicker2"));		
	}
	
	public void clickToday() {
		clickElement(By.id("datepicker2"));
		waitElementVisibility(By.xpath("//a[text()='Today']"), 5);
		clickElement(By.xpath("//a[text()='Today']"));
	}
	
	public String getDatePickerEnabledHighlighted() {		
		return getElementTitle(By.xpath("//a[contains(@class, 'datepick-today')]"));
	}
	
	public void setDatePickerEnabledClicking(int selectedYear, int selectedMonth, int selectedDay) {
	
		selectedMonth = selectedMonth + 1;
		
		clickElement(By.id("datepicker2"));
		String monthYear = getElementValue(By.xpath("//select[@title='Change the year']"));
		int yearStart = monthYear.lastIndexOf('/');
		
		int currentMonth = Integer.parseInt(monthYear.substring(0, yearStart));
		int currentYear = Integer.parseInt(monthYear.substring(yearStart + 1));
		
		if(selectedYear == currentYear && selectedMonth == currentMonth) {
			waitElementVisibility(By.xpath("//div[@class='datepick-nav']"), 5);
			clickElement(By.xpath("//table/tbody/tr/td/a[text()='" + selectedDay + "']"));
		}
		else if(currentYear > selectedYear || (selectedYear == currentYear && currentMonth > selectedMonth)) {
			while(true) {
				waitElementVisibility(By.xpath("//a[text()='<Prev']"), 5);
				clickElement(By.xpath("//a[text()='<Prev']"));
				monthYear = getElementValue(By.xpath("//select[@title='Change the year']"));
				yearStart = monthYear.lastIndexOf('/');
				currentYear = Integer.parseInt(monthYear.substring(yearStart + 1));
				currentMonth = Integer.parseInt(monthYear.substring(0, yearStart));
				if(selectedYear == currentYear && currentMonth == selectedMonth) {
					break;
				}
			}				
			clickElement(By.xpath("//table/tbody/tr/td/a[text()='" + selectedDay + "']"));			
		}
		else if(currentYear < selectedYear || (selectedYear == currentYear && currentMonth < selectedMonth)) {
			while(true) {
				waitElementVisibility(By.xpath("//a[text()='Next>']"), 5);
				clickElement(By.xpath("//a[text()='Next>']"));
				monthYear = getElementValue(By.xpath("//select[@title='Change the year']"));
				yearStart = monthYear.lastIndexOf('/');
				currentYear = Integer.parseInt(monthYear.substring(yearStart + 1));
				currentMonth = Integer.parseInt(monthYear.substring(0, yearStart));
				if(selectedYear == currentYear && currentMonth == selectedMonth) {
					break;
				}
			}				
			clickElement(By.xpath("//table/tbody/tr/td/a[text()='" + selectedDay + "']"));		
		}
	}
}
