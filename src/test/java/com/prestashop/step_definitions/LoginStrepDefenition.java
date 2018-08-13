package com.prestashop.step_definitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SigninPage;
import com.prestashop.utilities.BrowserUtils;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStrepDefenition {
	SigninPage signinPage = new SigninPage();
	String email;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		HomePage homePage = new HomePage();
		homePage.signin.click();
	}

	@When("I login using username {string} and password {string}")
	public void i_login_using_username_and_password(String username, String password) {
	//	 SigninPage signinPage = new SigninPage();
		 signinPage.loginEmail.sendKeys(username);
		 signinPage.password.sendKeys(password+Keys.ENTER);
//		 signinPage.submitLogin.cl
	}

	@Then("users full name {string} {string} should be displayed")
	public void users_full_name_should_be_displayed(String firstName, String lastName) {
	   String expected = firstName+" "+ lastName;
	   String actual = new MyAccountPage().fullName.getText();
	   assertEquals(expected, actual );
	}
	@When("the user tries to register an invalid email")
	public void the_user_tries_to_register_an_invalid_email() {
	//	SigninPage signinPage = new SigninPage();
		signinPage.signupEmail.sendKeys("abcdef");
		signinPage.signupEmail.submit();
	}

	@Then("the system should display error message {string}")
	public void the_system_should_display_error_message(String message) {
		BrowserUtils.waitForVisibility(signinPage.errorMessage, 5);
	  String actual = signinPage.errorMessage.getText();
	//  String expected="Invalid email address";
	  assertEquals(message, actual);
	}
	@When("the user tries to register blank email")
	public void the_user_tries_to_register_blank_email() {
	//	signinPage.signupEmail.sendKeys("");
		signinPage.signupEmail.submit();
	}
	
	@Given("there is an existing email")
	public void there_is_an_existing_email() {
		  new HomePage().signin.click();
	        
	        Faker faker = new Faker();
	        email = faker.name().username() + "@gmail.com";
	        
	        SigninPage signIn = new SigninPage();
	        signIn.signupEmail.sendKeys(email);
	        signIn.signupEmail.submit();

	        RegistrationPage registrationPage= new RegistrationPage();
	        
	        registrationPage.firstName.sendKeys(faker.name().firstName());
	        registrationPage.lastName.sendKeys(faker.name().lastName());
	        Address adress = faker.address();
	        registrationPage.password.sendKeys("admin123");
	        registrationPage.address.sendKeys(adress.buildingNumber()+ " "+adress.streetAddress());
	        registrationPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone().replaceAll(".", "-"));
	        registrationPage.city.sendKeys(adress.cityName());
	        BrowserUtils.waitFor(2);
	        Select state= new Select(registrationPage.state);
	        
	       
	        Select states =  registrationPage.stateList();
	        states.selectByValue("2");
	        
	      //state.selectByVisibleText("Texas");;
	      registrationPage.zipCode.sendKeys("22222");
	      registrationPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
	        registrationPage.register.click();
	        MyAccountPage myAccountPage= new MyAccountPage();
	        myAccountPage.logout.click();
	}

	@When("the user tries to register the same email")
	public void the_user_tries_to_register_the_same_email() {
		signinPage.signupEmail.sendKeys(email);
		//signinPage.password.sendKeys(""+Keys.ENTER);
		signinPage.signupEmail.submit();
	}
}
