import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	private WebDriver driver;

	@BeforeSuite
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setupTest() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(options);
		
		
	}

	  @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	  }

	@Test

	public void execute() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		FBlogin fb=new FBlogin();
		fb.enterusername(driver);
		fb.enterpwd(driver);
		fb.clicklogin(driver);
		
		FBhomePage fbg=new FBhomePage();
		fbg.searchelemet(driver);
		
		Thread.sleep(5000);
		
		String pagetitle=driver.getTitle();
		System.out.println(driver.getTitle());
		
		assertEquals(pagetitle, "hir staging mobile – Facebook Search");
		





	}

}
