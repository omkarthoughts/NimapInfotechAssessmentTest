package omkar.PageObjects;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import omkar.AbstractComponents.AbstractComponents;

public class LoginPageObjects extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#mat-input-0")
	WebElement emailOrPassEle;
	
	@FindBy(css = "#mat-input-1")
	WebElement passwordEle;
	
	@FindBy(css = "input[formcontrolname='captchaValue']")
	WebElement captchaEle;
	
	@FindBy(css = "#kt_login_signin_submit")
	WebElement submitEle;

	public void loginApplication(String email,String password) {
		emailOrPassEle.sendKeys(email);
		passwordEle.sendKeys(password);		
	}
	
	public WebElement captcha() {
		return captchaEle;
	}
	
	public LoginPageObjects submition() {
		submitEle.click();
		LoginPageObjects submition = new LoginPageObjects(driver);
		return submition;
	}
	
	
}
