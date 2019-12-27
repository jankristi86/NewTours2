package com.demoaut.NewTours2;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base2;

public class FlightFinderTest extends Base2 {

	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(dr);
		lp.getUserName().sendKeys("Pera24");
		lp.getPassword().sendKeys("perica");
		lp.getLogin().click();

	}

	@Test
	public void findFlight() {
		FlightFinder ff = new FlightFinder(dr);

		// from
		Select s = new Select(ff.getFrom());
		s.selectByVisibleText("Paris");

		// from month
		Select s1 = new Select(ff.getFromMonth());
		s1.selectByIndex(7);

		// from day
		Select s2 = new Select(ff.getFromDay());
		s2.selectByVisibleText("22");

		// to
		Select s3 = new Select(ff.getTo());
		s3.selectByVisibleText("London");

		// to month
		Select s4 = new Select(ff.getToMonth());
		s4.selectByIndex(10);

		// to day
		Select s5 = new Select(ff.getToDay());
		s5.selectByVisibleText("15");

		// radio btn class
		int count = ff.getServClass().size();
		for (int i = 0; i < count; i++) {
			WebElement index = ff.getServClass().get(i);
			if (index.isSelected()) {
				ff.getServClass().get(0).click();
				break;
			}

		}

		// airline preference
		Select s6 = new Select(ff.getAirline());
		s6.selectByVisibleText("No Preference");

		// continue
		ff.getFindFlight().click();
	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}

}
