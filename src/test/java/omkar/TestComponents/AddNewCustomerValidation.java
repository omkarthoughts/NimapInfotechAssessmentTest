package omkar.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import omkar.PageObjects.LandingPage;
import omkar.PageObjects.LoginPageObjects;
import omkar.PageObjects.NewCustomerPage;

public class AddNewCustomerValidation extends BaseTest {
	Scanner sc = new Scanner(System.in);

	@BeforeTest
	public void loginValidation(HashMap<String, String> input) throws IOException {
		LoginPage.launchApplication();
		LoginPageObjects loginApplication = new LoginPageObjects(driver);
		loginApplication.loginApplication(input.get("email"), input.get("pass"));
		// Basically We are Unable to Automate the Captcha so we have provided Scanner
		// Function to parse the Visible Captcha
		System.out.println("Enter Given Captcha");
		String captcha = sc.next();
		loginApplication.captcha().sendKeys(captcha);
		loginApplication.submition();
	}

	@Test(groups = { "AddNewCustomerValidation" })
	public void addNewCustomerValidation(HashMap<String, String> input) {
		LandingPage landingpage1 = new LandingPage(driver);
		landingpage1.goToMyCustomer();
		NewCustomerPage newCustomerPage = new NewCustomerPage(driver);
		newCustomerPage.AddNewCustomer(input.get("customerName"), input.get("contactPersonName"),
				input.get("inputAddress"), input.get("pinCode"));
		newCustomerPage.saveButton();
	}

}
