package com.demoaut.NewTours2;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base2;

public class HomePageValidation extends Base2 {

	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));

	}

	@Test
	public void validatePageTitle() {
		String title = dr.getTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");

	}

	@Test
	public void menuTabValidation() {
		HomePage hp = new HomePage(dr);
		Assert.assertTrue(hp.getMenuTab().isDisplayed());
	}

	@Test
	public void validateFooter() throws InterruptedException {
		HomePage hp = new HomePage(dr);
		Assert.assertTrue(hp.getFooter().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}

}
