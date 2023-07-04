package omkar.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import omkar.PageObjects.LoginPageObjects;

public class LoginPage extends BaseTest {
	WebDriver driver;
	Scanner sc = new Scanner(System.in);

	@Test(groups = { "LoginValidation" })
	public void loginValidation(HashMap<String, String> input) throws IOException {
		LoginPage.launchApplication();
		LoginPageObjects loginApplication = new LoginPageObjects(driver);
		loginApplication.loginApplication(input.get("email"), input.get("pass"));
		System.out.println("Enter Given Captcha");
		String captcha = sc.next();
		loginApplication.captcha().sendKeys(captcha);
		loginApplication.submition();
	}
}
