package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static Properties pro = new Properties();
	public static Properties loc = new Properties();
	
	@BeforeMethod
	public void setUp() throws IOException{
		FileInputStream input = new FileInputStream("/Users/murariguragain/eclipse-workspace/testcasesAutomation/src/test/resources/configFiles/feature.properties");
		pro.load(input);
		FileInputStream input1 = new FileInputStream("/Users/murariguragain/eclipse-workspace/testcasesAutomation/src/test/resources/configFiles/locators.properties");
		loc.load(input1);
		
		if(pro.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(pro.getProperty("baseUrl"));
		}
		else if(pro.getProperty("browser").equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(pro.getProperty("baseUrl"));
	}

		else if(pro.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pro.getProperty("baseUrl"));	
		}
		}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
