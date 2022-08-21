package SeleniumTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsandTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String Parentwindow = driver.getWindowHandle();
		System.out.println("Before clicking the tab button the handle is " + Parentwindow);
		
		WebElement tab= driver.findElement(By.xpath("//button[@id=\"tabButton\"]"));
		tab.click();
		Set<String> allwindowhandles =driver.getWindowHandles();
		for(String eachwindowhandle : allwindowhandles)
		{
			System.out.println(eachwindowhandle);
			if(!eachwindowhandle.equals(Parentwindow))
			{
				driver.switchTo().window(eachwindowhandle);
			}
			
		}
		WebElement childheader = driver.findElement(By.id("sampleHeading"));
		System.out.println(childheader.getText());
		//driver.close();
		
		driver.switchTo().window(Parentwindow);
		WebElement backtoparent = driver.findElement(By.id("windowButton"));
		backtoparent.click();
		//driver.close();
		
		driver.switchTo().window(Parentwindow);
		WebElement backtoparent1 = driver.findElement(By.id("messageWindowButton"));
		backtoparent1.click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
		
		//WebElement backtoparent1text = driver.findElement(By.xpath("//*[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
		//System.out.println(backtoparent1text.getText());
		
	}

}
