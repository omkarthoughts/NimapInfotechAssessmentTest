package omkar.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import omkar.AbstractComponents.AbstractComponents;

public class NewCustomerPage extends AbstractComponents {

	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#mat-input-20")
	WebElement customerNameEle;

	@FindBy(css = "#mat-input-28")
	WebElement addressFieldEle;

	@FindBy(css = "#mat-input-35")
	WebElement inputAddressEle;

	@FindBy(xpath = "//span[normalize-space()='Done']")
	WebElement doneButtonEle;

	@FindBy(css = "#mat-input-23")
	WebElement contactPersonNameEle;

	@FindBy(css = "mat-option[id='mat-option-644'] span[class='mat-option-text']")
	WebElement selectCountryEle;

	@FindBy(css = ".mat-select-placeholder.ng-tns-c6-207.ng-star-inserted")
	WebElement selectStateEle;

	@FindBy(css = "#mat-input-29")
	WebElement pinCodeEle;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButtonEle;

	public NewCustomerPage AddNewCustomer(String customerName, String inputAddress, String contactPersonName, String pinCode) {

		customerNameEle.sendKeys(customerName);
		addressFieldEle.click();
		inputAddressEle.sendKeys(inputAddress);
		Select option = new Select(inputAddressEle);
		option.getFirstSelectedOption();
		doneButtonEle.click();
		contactPersonNameEle.sendKeys(contactPersonName);
		selectCountryEle.click();
		selectCountryEle.findElement(By
				.xpath("//mat-option[@id='mat-option-644']//span[@class='mat-option-text'][normalize-space()='India']"))
				.click();
		selectStateEle.click();
		selectStateEle.findElement(By.xpath("//span[normalize-space()='Maharashtra']")).click();
		pinCodeEle.sendKeys(pinCode);
		NewCustomerPage addNewCustomer = new NewCustomerPage(driver);
		return addNewCustomer;
	}
	
	public NewCustomerPage saveButton()
	{
		saveButtonEle.click();
		NewCustomerPage saveButton = new NewCustomerPage(driver);
		return saveButton;
	}

}
