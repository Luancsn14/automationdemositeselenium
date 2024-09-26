package com.lnovaes.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.lnovaes.core.BasePage;

public class WindowsPage extends BasePage {
	
	public void accessWindowsWindow() {
		accessBaseWindow("https://demo.automationtesting.in/Windows.html");
	}
	
	public void accessOpenNewTabbedWindowsTab() {
		clickLink("Open New Tabbed Windows");
	}
	
	public void clickOpenNewTabbedWindowsButton() {
		clickButton(By.xpath("//a[@href='http://www.selenium.dev']"));
	}
	
	public void accessNewWindow() {		
		browserToNewWindow();
	}
	
	public String getOpenNewTabbedWindowsTarget() {
		return getElementTarget(By.xpath("//a[@href='http://www.selenium.dev']"));
	}
	
	public void accessOpenNewSeperateWindowsTab() {
		clickLink("Open New Seperate Windows");
	}
	
	public String getWindowUrl() {
		return getUrl();
	}
	
	public void accessOpenNewSeparateWindowsTab() {
		clickLink("Open New Tabbed Windows");
	}
	
	public String getOpenNewSeparateWindowsOnclick() {
		return getElementOnclick(By.xpath("//div[@id='Seperate']/button"));
	}
	
	public void clickOpenNewSeparateWindowsButton() {
		clickButton(By.xpath("//div[@id='Seperate']/button"));
	}
	
	public void accessOpenSeperateMultipleWindowsTab() {
		clickLink("Open Seperate Multiple Windows");
	}
	
	public String getOpenSeperateMultipleWindowsOnclick() {
		return getElementOnclick(By.xpath("//div[@id='Multiple']/button"));
	}
	
	public void clickOpenSeperateMultipleWindowsButton() {
		clickButton(By.xpath("//div[@id='Multiple']/button"));
	}
	
	public int getWindowsOpenedNumber() {		
		return getWindowsAmount();
	}
	
	public List<String> getUrlsList(){
		return getWindowsUrls();
	}
}
