package com.lnovaes.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.lnovaes.core.BasePage;
import com.lnovaes.core.DriverFactory;

public class RegisterPage extends BasePage {	
	
	public void accessRegisterWindow() {
		DriverFactory.getDriver().get("https://demo.automationtesting.in/Register.html");
	}
	
	public void setFirstName(String firstName) {
		writeText(By.xpath("//input[@placeholder='First Name']"), firstName);
	}
	
	public void setLastName(String lastName) {
		writeText(By.xpath("//input[@placeholder='Last Name']"), lastName);
	}
	
	public String getFirstNameValue() {
		return getFieldValue(By.xpath("//input[@placeholder='First Name']"));
	}
	
	public String getLastNameValue() {
		return getFieldValue(By.xpath("//input[@placeholder='Last Name']"));
	}

	public void setAddress(String address) {
		writeText(By.xpath("//textarea[@ng-model='Adress']"), address);		
	}
	
	public String getAddress() {
		return getFieldValue(By.xpath("//textarea[@ng-model='Adress']"));
	}

	public void setEmail(String email) {
		writeText(By.xpath("//input[@type='email']"), email);	
	}
	
	public String getEmail() {
		return getFieldValue(By.xpath("//input[@type='email']"));
	}
	
	public String getEmailToolTip() {		
		return getTooltip(By.xpath("//input[@type='email']"), By.xpath("//div[@class='col-sm-4 col-xs-4 tooltptext']"));
	}

	public void setPhoneNumber(String phoneNumber) {
		writeText(By.xpath("//input[@type='tel']"), phoneNumber);		
	}
	
	public String getPhoneNumber() {
		return getFieldValue(By.xpath("//input[@type='tel']"));
	}
	
	public void setGender(String value) {
		clickElement(By.xpath("//input[@value='" + value +"']"));
	}
	
	public boolean getGenderSelected(String value) {
		return isRadioSelected(By.xpath("//input[@value='" + value +"']"));
	}
	
	public void setHobby(String value) {
		clickElement(By.xpath("//input[@value='" + value +"']"));
	}
	
	public boolean getHobbySelected(String value) {
		return isCheckSelected(By.xpath("//input[@value='" + value +"']"));
	}
	
	public void selectAllLanguages() {			
		selectAllOptionsMulti(By.id("msdd"), By.xpath("//div[@id='msdd']/../div/ul/li/a"));		
	}
	
	public void selectSpecificLanguages(String... languages) {
		for(String language: languages) {
		selectSpecificOptionMulti(By.id("msdd"), By.xpath("//a[text()='" + language + "']"));
		}		
	}
	
	public List<WebElement> getSelectedLanguages(){
		return getMultiValues(By.xpath("//div[@class='ui-autocomplete-multiselect-item']"));
	}
	
	public List<WebElement> getDeselectedLanguages(){
		return getMultiValues(By.xpath("//div[@id='msdd']/../div/ul/li/a"));
	}
	
	public void setSkill(String skill) {
		selectCombo(By.id("Skills"), skill);
	}
	
	public String getSkill() {
		return getComboValue(By.id("Skills"));
	}
	
	public List<WebElement> getSkillsOptions() {
		return getComboOptions(By.id("Skills"));
	}
	
	public void setCountry(String country) {
		selectCombo(By.id("country"), country);
	}
	
	public void typeCountry(String country) {
		clickElement(By.xpath("//select[@id='country']/.."));		
		writeText(By.xpath("//input[@class='select2-search__field']"), country + Keys.ENTER);
	}
	
	public String getCountry() {
		return getComboValue(By.id("country"));
	}
	
	public List<WebElement> getCountryOptions() {
		return getComboOptions(By.id("country"));
	}
	
	public void setBirthDate(String day, String month, String year) {
		selectCombo(By.id("yearbox"), year);
		selectCombo(By.xpath("//select[@placeholder='Month']"), month);
		selectCombo(By.id("daybox"), day);
	}
	
	public String getBirthDay() {
		return getComboValue(By.id("daybox"));
	}
	
	public List<WebElement> getBirthDayOptions() {
		return getComboOptions(By.id("daybox"));
	}
	
	public String getBirthMonth() {
		return getComboValue(By.xpath("//select[@placeholder='Month']"));
	}
	
	public List<WebElement> getBirthMonthOptions() {
		return getComboOptions(By.xpath("//select[@placeholder='Month']"));
	}
	
	public String getBirthYear() {
		return getComboValue(By.id("yearbox"));
	}
	
	public List<WebElement> getBirthYearOptions() {
		return getComboOptions(By.id("yearbox"));
	}
	
	public void setPassword(String password) {
		writeText(By.id("firstpassword"), password);
	}
	
	public void setConfirmPassword(String password) {
		writeText(By.id("secondpassword"), password);
	}
	
	public String getPassword() {
		return getFieldText(By.id("firstpassword"));
	}
	
	public String getConfirmPassword() {
		return getFieldText(By.id("secondpassword"));
	}
	
	public void uploadPhoto() {
		uploadFile(
				"src" + File.separator + "test" + File.separator + "resources" + File.separator + "testImage.jpg", 
				By.id("imagesrc"));
	}
	
	public String getUploadedPhotoName() {
		return getElementValue(By.id("imagesrc"));
	}
}
