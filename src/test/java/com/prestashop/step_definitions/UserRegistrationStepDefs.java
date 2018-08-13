package com.prestashop.step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.github.javafaker.Faker;
import com.prestashop.beans.User;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SigninPage;

import cucumber.api.java.en.Given;

public class UserRegistrationStepDefs {

	SigninPage signinPage = new SigninPage();
	RegistrationPage registrationPage = new RegistrationPage();
   MyAccountPage myAccountPage= new MyAccountPage();
	
   @Given("the user enters a random email")
	public void the_user_enters_a_random_email() {
		String emailAddress = new Faker().internet().emailAddress();
		signinPage.signupEmail.sendKeys(emailAddress + Keys.ENTER);

	}

	@Given("the user enters personal information")
	public void the_user_enters_personal_information(Map<String, String> user) {
		System.out.println(user);
		registrationPage.firstName.sendKeys(user.get("First Name"));
		registrationPage.lastName.sendKeys(user.get("Last Name"));
		registrationPage.address.sendKeys(user.get("Address"));
		registrationPage.city.sendKeys(user.get("City"));
		registrationPage.company.sendKeys(user.get("Company"));

	}

	@Given("the user enters user information")
	public void the_user_enters_user_information(List<User> users) {
		for (User user : users) {
			System.out.println(user.getFirstname());
			System.out.println(user.getLastName());
			System.out.println(user.getAddress());
			System.out.println(user.getCity());
			System.out.println(user.getCompany());
			registrationPage.firstName.sendKeys(user.getFirstname());
			registrationPage.lastName.sendKeys(user.getLastName());
			registrationPage.address.sendKeys(user.getAddress());
			registrationPage.city.sendKeys(user.getCity());
			registrationPage.company.sendKeys(user.getCompany());
		}
	}

}
