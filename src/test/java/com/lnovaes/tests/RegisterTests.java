package com.lnovaes.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.RegisterPage;

public class RegisterTests extends BaseTest {
	RegisterPage registerPage = new RegisterPage();
	Faker faker = new Faker();
	
	@Before
	public void start() {
		registerPage.accessRegisterWindow();
	}
	
	@Test
	public void testFullName() {
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		
		Assert.assertEquals(firstName, registerPage.getFirstNameValue());
		Assert.assertEquals(lastName, registerPage.getLastNameValue());		
	}
	
	@Test
	public void testAddress() {
		String address = faker.address().fullAddress();
		
		registerPage.setAddress(address);
		
		Assert.assertEquals(address, registerPage.getAddress());
	}
	
	@Test
	public void testEmailAddress() {
		String email = faker.internet().emailAddress();
		
		registerPage.setEmail(email);
		
		Assert.assertEquals(email, registerPage.getEmail());		
	}
	
	@Test
	public void testEmailAdressTooltip() {
		Assert.assertEquals("Provide a valid email id for further updates", registerPage.getEmailToolTip());
	}
	
	@Test
	public void testPhone() {
		String phoneNumber = faker.phoneNumber().phoneNumber();
		
		registerPage.setPhoneNumber(phoneNumber);
		
		Assert.assertEquals(phoneNumber, registerPage.getPhoneNumber());
	}
	
	@Test
	public void testSelectGenderMale() {
		registerPage.setGender("Male");
		
		Assert.assertTrue(registerPage.getGenderSelected("Male"));
	}
	
	@Test
	public void testSelectGenderFemale() {
		registerPage.setGender("FeMale");
		
		Assert.assertTrue(registerPage.getGenderSelected("FeMale"));
	}
	
	@Test
	public void testSelectHobbies() {
		registerPage.setHobby("Cricket");
		registerPage.setHobby("Movies");
		registerPage.setHobby("Hockey");
		
		Assert.assertTrue(registerPage.getHobbySelected("Cricket"));
		Assert.assertTrue(registerPage.getHobbySelected("Movies"));
		Assert.assertTrue(registerPage.getHobbySelected("Hockey"));		
	}
	
	@Test
	public void testSelectAllLanguages() {		
		registerPage.selectAllLanguages();
		
		Assert.assertEquals(41, registerPage.getSelectedLanguages().size());
		
		String[] allLanguages = 
				{"Arabic", "Bulgarian", "Catalan", "Croatian", "Czech", "Danish", "Dutch", "English",
				"Estonian", "Filipino", "Finnish", "French", "German", "Greek", "Hebrew", "Hindi", 
				"Hungarian", "Icelandic", "Indonesian", "Italian", "Japanese", "Korean", "Latvian",
				"Lithuanian", "Malay", "Norwegian", "Persian", "Polish", "Portuguese", "Romanian",
				"Russian", "Serbian", "Slovak", "Slovenian", "Spanish", "Swedish", "Thai", "Turkish",
				"Ukrainian", "Urdu", "Vietnamese"};
		
		List<String> languages = Arrays.asList(allLanguages);
		
		List<WebElement> allSelected = registerPage.getSelectedLanguages();
		
		for(WebElement selected: allSelected) {
			Assert.assertTrue(languages.contains(selected.getText()));
		}
		
		List<WebElement> deselectedList = registerPage.getDeselectedLanguages();
		for(WebElement item: deselectedList){
			Assert.assertTrue(!item.isDisplayed());
		}
	}
	
	@Test
	public void testSelectSpecificLanguages() {
		String[] selectedLanguages = {"Arabic", "German", "Polish"};
		
		registerPage.selectSpecificLanguages(selectedLanguages);
		
		Assert.assertEquals(3, registerPage.getSelectedLanguages().size());
		
		List<String> languages = Arrays.asList(selectedLanguages);
		
		List<WebElement> allSelected = registerPage.getSelectedLanguages();
		
		for(WebElement selected: allSelected) {
			Assert.assertTrue(languages.contains(selected.getText()));
		}
		
		List<WebElement> deselectedList = registerPage.getDeselectedLanguages();
		for(String language: languages) {
			for(WebElement item: deselectedList){
				if(item.getText() == language)
				Assert.assertTrue(!item.isDisplayed());
			}
		}
	}
	
	@Test
	public void testSelectSkills() {
		List<WebElement> options = registerPage.getSkillsOptions();
		
		Assert.assertEquals(78, options.size());
	
		for (WebElement option : options) {
          String optionText = option.getText();
          registerPage.setSkill(optionText);
          
          Assert.assertEquals(optionText, registerPage.getSkill());
		}
	}
	
	@Test
	public void testSelectCountry() {
		List<WebElement> options = registerPage.getCountryOptions();
		
		Assert.assertEquals(11, options.size());
	
		for (WebElement option : options) {
          String optionText = option.getText();
          registerPage.setCountry(optionText);
          
          Assert.assertEquals(optionText, registerPage.getCountry());
		}
	}
	
	@Test
	public void testSelectCountryTyping() {
		List<WebElement> options = registerPage.getCountryOptions();
		
		Assert.assertEquals(11, options.size());
	
		for (WebElement option : options) {
          String optionText = option.getText();
          registerPage.typeCountry(optionText);
          
          Assert.assertEquals(optionText, registerPage.getCountry());
		}
	}
	
	@Test
	public void testBirthDate() {
		String birthDay = "14";
		String birthMonth = "September";
		String birthYear = "1991";
		
		registerPage.setBirthDate(birthDay, birthMonth, birthYear);
		
		Assert.assertEquals(birthDay, registerPage.getBirthDay());
		Assert.assertEquals(birthMonth, registerPage.getBirthMonth());
		Assert.assertEquals(birthYear, registerPage.getBirthYear());
		
		Assert.assertEquals(32, registerPage.getBirthDayOptions().size());
		Assert.assertEquals(13, registerPage.getBirthMonthOptions().size());
		Assert.assertEquals(101, registerPage.getBirthYearOptions().size());
	}
}
