package variousConeptJUnitMaven;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
	
	WebDriver driver;
	
	@BeforeClass
	public static void beforeclass() {
		System.out.println("before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Before
	public void launchBrowser() {
		System.out.println("before annotation");
		  

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mwamb\\Selenium\\try\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/`");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loging() {
		System.out.println("positive test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");

		driver.findElement(By.name("login")).click();
	}

	@Test
	public void negLogTest() {
		System.out.println("negative test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	@After
	public void tearDown() {
		System.out.println("after annotation");

		driver.close();
		driver.quit();
	}
}
