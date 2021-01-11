package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.invoices;
import page.LoginPage;
import page.newInvoice;
import page.SiteNavigation;
import util.BrowserFactory;

public class newInvoiceTest {
	WebDriver driver;
	Random rnd = new Random();

	@Test
	@Parameters({ "userName", "Password", "ItemName", "qty", "price" })
	public void addNewInvoice(String userName, String password, String itemName, String qty, String price)
			throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);
		SiteNavigation sideNavigation = PageFactory.initElements(driver, SiteNavigation.class);

		sideNavigation.goToinvoicePage();

		newInvoice newInvoicePage = PageFactory.initElements(driver, newInvoice.class);

		String expectedItemName = newInvoicePage.enterARandomItemName(itemName);

		newInvoicePage.enterQty(qty);
		newInvoicePage.enterPrice(price);
		newInvoicePage.selectAcustomer();
		newInvoicePage.clickSaveAndClose();

		sideNavigation.goToinvoicesWithoutClickingOnModule();

		invoices invoicePage = PageFactory.initElements(driver, invoices.class);

		List<String> amountList = invoicePage.getListOf("Amount");

		String expectedAmount = String.valueOf((Integer.parseInt(qty) * Integer.parseInt(price)));

		Assert.assertTrue(isDataMatching(expectedAmount, amountList), "Account name was not found!");
	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	private boolean isDataExist(String expectedData, List<String> actualList) {
		for (int i = 0; i < actualList.size(); i++) {
			if (expectedData.equalsIgnoreCase(actualList.get(i))) {
				return true;
			}
		}
		return false;
	}

	private boolean isDataMatching(String expectedData, List<String> actualList) {
		for (int i = 0; i < actualList.size(); i++) {
			if (expectedData.contains(actualList.get(i))) {
				return true;
			}
		}
		return false;
	}


}
