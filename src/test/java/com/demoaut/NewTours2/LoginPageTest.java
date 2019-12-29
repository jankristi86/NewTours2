package com.demoaut.NewTours2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base2;
import resources.Constant;
import resources.ExcelUtils;

public class LoginPageTest extends Base2 {
	public static Logger log = LogManager.getLogger(Base2.class.getName());


	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(dr);
		lp.getSignOn().click();

	}

	@Test
	public void loginExcelDriven() throws Exception {
		String data;
		ExcelUtils.setExcelFile(Constant.PATH_TESTDATA + Constant.FILE_DATA, Constant.SHEET2);

		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			LoginPage lp = new LoginPage(dr);
			data = ExcelUtils.getCellData(i, 0);
			lp.getUserName().sendKeys(data);
			data = ExcelUtils.getCellData(i, 1);
			lp.getPassword().sendKeys(data);
			lp.getLogin().click();
			if (lp.logConfirm().isDisplayed()) {
				RegisterPage rp = new RegisterPage(dr);
				rp.getSignOff().click();
				log.info("Successfully logged users with excelDriven data");
			}
		}

	}

	@AfterMethod
	public void signOut() {
		LoginPage lp = new LoginPage(dr);
		lp.getSignOn().click();
		log.info("Successfully logged out after every login");

	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}

}
