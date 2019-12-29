package com.demoaut.NewTours2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base2;
import resources.Constant;
import resources.ExcelUtils;

public class RegisterPageTest extends Base2 {
	public static Logger log = LogManager.getLogger(Base2.class.getName());


	@BeforeTest
	public void initialize() throws IOException {
		dr = initializeDriver();
		dr.get(prop.getProperty("url"));
		HomePage hp = new HomePage(dr);
		hp.getRegBtn().click();
		log.info("Reg btn successfully hitted");

	}

	@Test(dataProvider = "getData")
	public void registerDataProviderDriven(String fName, String lName, String phone, String email, String address,
			String city, String state, String postal, String country, String userName, String pass, String confPass) {

		RegisterPage rp = new RegisterPage(dr);
		rp.getFirstName().sendKeys(fName);
		rp.getLastName().sendKeys(lName);
		rp.getPhone().sendKeys(phone);
		rp.getEmail().sendKeys(email);
		rp.getAddress().sendKeys(address);
		rp.getCity().sendKeys(city);
		rp.getState().sendKeys(state);
		rp.getPostalCode().sendKeys(postal);
		rp.getSelectCountry().sendKeys(country);
		rp.getUserName().sendKeys(userName);
		rp.getPassword().sendKeys(pass);
		rp.getConfirmPass().sendKeys(confPass);
		rp.getSubmit().click();
		log.info("Successfully registration with data provider data");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][12];
		data[0][0] = "Joca";
		data[0][1] = "Jocic";
		data[0][2] = "0800200200";
		data[0][3] = "valid@email.com";
		data[0][4] = "My Home address";
		data[0][5] = "My City";
		data[0][6] = "My State";
		data[0][7] = "91080";
		data[0][8] = "ser";
		data[0][9] = "perica24";
		data[0][10] = "admin";
		data[0][11] = "admin";

		return data;
	}

	@Test
	public void registerExcelDriven() throws Exception {
		String data;
		ExcelUtils.setExcelFile(Constant.PATH_TESTDATA + Constant.FILE_DATA, Constant.SHEET1);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			RegisterPage rp = new RegisterPage(dr);
			data = ExcelUtils.getCellData(i, 0);
			rp.getFirstName().sendKeys(data);
			data = ExcelUtils.getCellData(i, 1);
			rp.getLastName().sendKeys(data);
			data = ExcelUtils.getCellData(i, 2);
			rp.getPhone().sendKeys(data);
			data = ExcelUtils.getCellData(i, 3);
			rp.getEmail().sendKeys(data);
			data = ExcelUtils.getCellData(i, 4);
			rp.getAddress().sendKeys(data);
			data = ExcelUtils.getCellData(i, 5);
			rp.getCity().sendKeys(data);
			data = ExcelUtils.getCellData(i, 6);
			rp.getState().sendKeys(data);
			data = ExcelUtils.getCellData(i, 7);
			rp.getPostalCode().sendKeys(data);
			rp.getSelectCountry().sendKeys("ser");
			data = ExcelUtils.getCellData(i, 8);
			rp.getUserName().sendKeys(data);
			data = ExcelUtils.getCellData(i, 9);
			rp.getPassword().sendKeys(data);
			data = ExcelUtils.getCellData(i, 10);
			rp.getConfirmPass().sendKeys(data);
			rp.getSubmit().click();
			if (rp.getRegConfirmation().isDisplayed()) {
				rp.getSignOff().click();
				rp.getRegisterBtn().click();
				log.info("Successfully registration with ExcelDriven data");


			}
		}
	}

	@AfterMethod
	public void signOut() {
		RegisterPage rp = new RegisterPage(dr);
		// rp.getSignOff().click();
		rp.getRegisterBtn().click();
	}

	@AfterTest
	public void tearDown() {
		dr.close();
		dr = null;
	}

}
