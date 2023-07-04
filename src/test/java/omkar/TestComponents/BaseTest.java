package omkar.TestComponents;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage LoginPage;

	public WebDriver WebDiverInitialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public void goTo(WebDriver driver) {
		driver.get("https://testffc.nimapinfotech.com/");
	}

	public List<HashMap<String, String>> getLoginData() {
		HashMap<String, String> data = new HashMap<String, String>();
		// Login Details
		data.put("email", "omkarpatil2552@gmail.com");
		data.put("pass", "Test@1234");

		// Add New Customer Details
		data.put("customerName", "Rakesh Jadhav");
		data.put("contactPersonName", "Omkar Patil");
		data.put("inputAddress", "pune");
		data.put("pinCode", "415112");
		return (List<HashMap<String, String>>) data;
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		driver = WebDiverInitialization();
		LoginPage = new LoginPage();
		LoginPage.goTo(driver);
		return LoginPage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
