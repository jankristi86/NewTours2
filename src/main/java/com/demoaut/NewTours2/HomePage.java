package com.demoaut.NewTours2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver dr;

	private By footer = By.xpath("//div[@class='footer']");
	private By menuTab = By.xpath("//body/div/table/tbody/tr/td/table/tbody/tr[2]/td[1]");
	private By regBtn = By.linkText("REGISTER");

	public HomePage() {
	}

	public HomePage(WebDriver dr) {
		this.dr = dr;
	}

	public WebElement getFooter() {
		return dr.findElement(footer);
	}

	public WebElement getMenuTab() {
		return dr.findElement(menuTab);
	}

	public WebElement getRegBtn() {
		return dr.findElement(regBtn);
	}

}
