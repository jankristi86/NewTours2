package com.demoaut.NewTours2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightFinder {

	public WebDriver dr;

	private By type = By.cssSelector("input[name='tripType']");
	private By passCount = By.cssSelector("select[name='passCount']");
	private By fromPort = By.cssSelector("select[name='fromPort']");
	private By fromMonth = By.cssSelector("select[name='fromMonth']");
	private By fromDay = By.cssSelector("select[name='fromDay']");
	private By toPort = By.cssSelector("select[name='toPort']");
	private By toMonth = By.cssSelector("select[name='toMonth']");
	private By toDay = By.cssSelector("select[name='toDay']");
	private By servClass = By.cssSelector("input[name='servClass']");
	private By airline = By.cssSelector("select[name='airline']");
	private By findFlight = By.cssSelector("input[name='findFlights']");
	private By reserveFlight = By.cssSelector("input[name='reserveFlight']");

	// constructor
	public FlightFinder(WebDriver dr) {
		this.dr = dr;
	}

	// Flight Type
	public WebElement getType() {
		return dr.findElement(type);

	}

	// number of passengers
	public WebElement getPassCount() {
		return dr.findElement(passCount);
	}

	// from port
	public WebElement getFrom() {
		return dr.findElement(fromPort);
	}

	// from month
	public WebElement getFromMonth() {
		return dr.findElement(fromMonth);

	}

	// from Day
	public WebElement getFromDay() {
		return dr.findElement(fromDay);

	}

	// to port
	public WebElement getTo() {
		return dr.findElement(toPort);
	}

	// to month
	public WebElement getToMonth() {
		return dr.findElement(toMonth);

	}

	// to Day
	public WebElement getToDay() {
		return dr.findElement(toDay);

	}

	// Service Class
	public WebElement getServClass() {
		return dr.findElement(servClass);
	}

	// airline option
	public WebElement getAirline() {
		return dr.findElement(airline);
	}

	// continue btn
	public WebElement getFindFlight() {
		return dr.findElement(findFlight);
	}

	// reserve flight
	public WebElement getReserveFlight() {
		return dr.findElement(reserveFlight);
	}

}
