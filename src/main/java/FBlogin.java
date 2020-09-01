import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBlogin {
	
	WebDriver driver;
	public static WebElement element =null;
	Properties prop;
	
	public FBlogin() throws IOException{
		
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		
		prop=new Properties();
		prop.load(fis);
		
	}
	
	public WebDriver enterusername(WebDriver driver) {
		
		WebElement id =driver.findElement(By.id("email"));
		id.click();
		id.sendKeys(prop.getProperty("Username"));
	
		return driver;
	}
	
	public WebDriver enterpwd(WebDriver driver) {
		
		WebElement pwd=driver.findElement(By.id("pass"));
		
		pwd.click();
		pwd.sendKeys(prop.getProperty("Password"));
		return driver;
	}
	
	public WebDriver clicklogin(WebDriver driver) {
		
		driver.findElement(By.name("login")).click();
		return driver;
	}


}
