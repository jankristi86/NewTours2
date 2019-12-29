package com.demoaut.NewTours2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base2;

public class HomePageValidation extends Base2 {
	public static Logger log = LogManager.getLogger(Base2.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
		log.info("navigated to home page");
	}

	@Test
	public void validatePageTitle() {
		String title = dr.getTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		log.info("Successfully validated page title");
	}

	@Test
	public void menuTabValidation() {
		HomePage hp = new HomePage(dr);
		Assert.assertTrue(hp.getMenuTab().isDisplayed());
		log.info("Succesfully menu tab validated");
	}

	@Test
	public void validateFooter() throws InterruptedException {
		HomePage hp = new HomePage(dr);
		Assert.assertTrue(hp.getFooter().isDisplayed());
		log.info("Successfully validated footer");
	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
		log.info("After HomePage test, driver closed");
	}

}
