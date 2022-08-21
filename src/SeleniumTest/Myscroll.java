package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myscroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.nykaa.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

//to scroll to end:

//Actions action = new Actions(driver);
//action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
//Thread.sleep(5000);

//JavascriptExecutor obj= (JavascriptExecutor) driver;
//obj.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//Thread.sleep(5000);

WebElement target = driver.findElement(By.xpath("//p[@class='css-747vzb']"));
JavascriptExecutor obj= (JavascriptExecutor) driver;
obj.executeScript("arguments[0].scrollIntoView();", target);
driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
System.out.println("done");
driver.close();
	}

}
