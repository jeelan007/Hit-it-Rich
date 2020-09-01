import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBhomePage {

	WebDriver driver=null;
	Properties prop;


	public FBhomePage() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");

		prop=new Properties();
		prop.load(fis);


	}


	public WebDriver searchelemet(WebDriver driver) {

		WebElement search=driver.findElement(By.name("q"));

		search.click();
		search.sendKeys(prop.getProperty("URL"));

		search.sendKeys(Keys.ENTER);

		return driver;
	}
}
