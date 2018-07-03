package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
			prop.load(fis);
			
		}catch(IOException e) {
			e.getMessage();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
}
