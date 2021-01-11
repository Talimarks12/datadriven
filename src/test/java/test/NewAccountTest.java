package test;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.LoginPage;
import page.SiteNavigation;
import util.BrowserFactory;
import util.excelreader;

public class NewAccountTest {
WebDriver driver;
Random rnd = new Random();
excelreader reader = new excelreader("./data/Book1.xlsx");
String userName = reader.getCellData("Sheet1", "UserName", 2);
String password = reader.getCellData("Sheet1", "Password", 2);
String accounttitle = reader.getCellData("Sheet1", "AccountTitle", 2) + rnd.nextInt(999);


@Test
public void addNewContact() throws InterruptedException {
	driver = BrowserFactory.startBrowser();
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.login(userName, password);
	SiteNavigation sitenavigation = PageFactory.initElements(driver, SiteNavigation.class);
	sitenavigation.goToNewAccountPage();
	
}

}