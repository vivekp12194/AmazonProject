package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonBaseClass {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	Actions action;
	
	public AmazonBaseClass() {
		
		try {	
			
		FileInputStream file = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Amazon_Ecommerce\\src\\test\\java\\envoirnmentsetup\\config.properties");
		prop.load(file);
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
	}
		public static void initialization() {
			String browsername = prop.getProperty("browser");
			if(browsername.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
	}
		public static void login() throws InterruptedException {
			
			driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div")).click();
			driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("email"));
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("signInSubmit")).click();
			Thread.sleep(5000);
			
		}
}
