package com.demoaut.NewTours2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver dr;

	private By signOn = By.xpath("//a[contains(text(),'SIGN-ON')]");
	private By userName = By.cssSelector("input[name='userName']");
	private By password = By.cssSelector("input[name='password']");
	private By login = By.cssSelector("input[name='login']");
	private By logConfirm = By.xpath("//font[contains(text(),'Use our Flight Finder')]");

	// constructor
	public LoginPage(WebDriver dr) {
		this.dr = dr;
	}

	// signOn Btn
	public WebElement getSignOn() {
		return dr.findElement(signOn);
	}

	// userName
	public WebElement getUserName() {
		return dr.findElement(userName);
	}

	// password
	public WebElement getPassword() {
		return dr.findElement(password);
	}

	// LogIn
	public WebElement getLogin() {
		return dr.findElement(login);
	}

	public WebElement logConfirm() {
		return dr.findElement(logConfirm);
	}

}
