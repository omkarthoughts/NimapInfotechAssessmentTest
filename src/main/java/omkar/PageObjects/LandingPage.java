package omkar.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import omkar.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//span[normalize-space()='My Customers']")
	WebElement myCustomerEle;
	
	@FindBy (xpath = "//span[normalize-space()='New Customer']")
	WebElement newCustomerEle;
	
	@FindBy (css = ".toast-message")
	WebElement toastMsgEle;
	
	
	public LandingPage goToMyCustomer()
	{
		myCustomerEle.click();
		toastMsgEle.click();
		toastMsgEle.isDisplayed();
		LandingPage goToNewCustomerPage = new LandingPage(driver);
		return goToNewCustomerPage;
	}
	
	
}
