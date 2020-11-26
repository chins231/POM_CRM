package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.utils.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static	WebDriverWait wait ;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/sriranganathtottadi/Documents/Automation/CRMTest/src/main/java/com/crm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File error");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/sriranganathtottadi/Downloads/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "/Users/sriranganathtottadi/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);//implicit wait
		wait = new WebDriverWait(driver, 20);
		driver.get( prop.getProperty("url"));
	}

}
