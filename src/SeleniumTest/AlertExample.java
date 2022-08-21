package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
		
		WebElement alert1 = driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
		JavascriptExecutor obj =  (JavascriptExecutor) driver;
        obj.executeScript("arguments[0].scrollIntoView();", alert1);
		alert1.click();
		Alert alertbutton = driver.switchTo().alert();
		System.out.println(alertbutton.getText());
		alertbutton.accept();
		
		WebElement alert2 = driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
		JavascriptExecutor obj1 =  (JavascriptExecutor) driver;
        obj1.executeScript("arguments[0].scrollIntoView();", alert2);
		alert2.click();
		alertbutton = driver.switchTo().alert();
		System.out.println(alertbutton.getText());
		alertbutton.dismiss();
		
		WebElement alert3= driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
		JavascriptExecutor obj3 =  (JavascriptExecutor) driver;
        obj3.executeScript("arguments[0].scrollIntoView();", alert3);
		alert3.click();
		alertbutton= driver.switchTo().alert();
		System.out.println(alertbutton.getText());
		alertbutton.sendKeys("Hi Sharmila");
		alertbutton.accept();
		
	}

}
