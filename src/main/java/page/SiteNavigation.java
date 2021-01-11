package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SiteNavigation {
	
	WebDriver driver;
	
	
	public SiteNavigation(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")
	WebElement BankCashModule;
	@FindBy(how = How.LINK_TEXT, using = "New Account")
	WebElement NewAccountPage;
	@FindBy(how = How.LINK_TEXT, using = "List Accounts")
	WebElement ListAccountPage;
	
	public void goToNewAccountPage() throws InterruptedException {
		BankCashModule.click();
		Thread.sleep(2000);
		NewAccountPage.click();
	}
	
	public void goToListAccountPage() {
		ListAccountPage.click();
	}

	public void goToinvoicePage() {
		// TODO Auto-generated method stub
		
	}

	public void goToinvoicesWithoutClickingOnModule() {
		// TODO Auto-generated method stub
		
	}

	
	}
	


