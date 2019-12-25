package com.demoaut.NewTours2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	public WebDriver dr;
	private By register = By.xpath("//a[contains(text(),'REGISTER')]");
	private By firstName = By.cssSelector("input[name=firstName]");
	private By lastName = By.cssSelector("input[name=lastName]");
	private By phone = By.cssSelector("input[name='phone']");
	private By email = By.cssSelector("input[id=userName]");
	private By address = By.cssSelector("input[name='address1']");
	private By city = By.cssSelector("input[name='city']");
	private By state = By.cssSelector("input[name='state']");
	private By postalCode = By.cssSelector("input[name='postalCode']");
	private By selectCountry = By.cssSelector("select[name='country']");
	private By userName = By.cssSelector("input[id='email']");
	private By password = By.cssSelector("input[name='password']");
	private By confirmPass = By.cssSelector("input[name='confirmPassword']");
	private By submit = By.cssSelector("input[name='register']");
	private By regConfirmation = By.xpath("//font[contains(text(),'Thank you for registering.')]");
	private By signOff = By.linkText("SIGN-OFF");

	// constructor
	public RegisterPage(WebDriver dr) {
		this.dr = dr;
	}

	// register btn
	public WebElement getRegisterBtn() {
		return dr.findElement(register);
	}

	// firstName
	public WebElement getFirstName() {
		return dr.findElement(firstName);
	}

	// lastName
	public WebElement getLastName() {
		return dr.findElement(lastName);
	}

	// Phone
	public WebElement getPhone() {
		return dr.findElement(phone);
	}

	// Email
	public WebElement getEmail() {
		return dr.findElement(email);
	}

	// address
	public WebElement getAddress() {
		return dr.findElement(address);
	}

	// city
	public WebElement getCity() {
		return dr.findElement(city);
	}

	// state
	public WebElement getState() {
		return dr.findElement(state);
	}

	// postal
	public WebElement getPostalCode() {
		return dr.findElement(postalCode);
	}

	// selectCountry
	public WebElement getSelectCountry() {
		return dr.findElement(selectCountry);
	}

	// userName
	public WebElement getUserName() {
		return dr.findElement(userName);
	}

	// password
	public WebElement getPassword() {
		return dr.findElement(password);
	}

	// confirmPass
	public WebElement getConfirmPass() {
		return dr.findElement(confirmPass);
	}

	// submitBtn
	public WebElement getSubmit() {
		return dr.findElement(submit);
	}

	public WebElement getRegConfirmation() {
		return dr.findElement(regConfirmation);
	}

	public WebElement getSignOff() {
		return dr.findElement(signOff);
	}

}
