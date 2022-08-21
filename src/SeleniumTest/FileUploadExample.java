package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
		
		WebElement upload = driver.findElement(By.name("uploadfile_0"));
		upload.sendKeys("C:\\Users\\S141\\Desktop\\Sample\\Sample.txt");
		
		WebElement terms = driver.findElement(By.id("terms"));
		terms.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submit.click();
		
		Thread.sleep(10000);
		WebElement txt = driver.findElement(By.xpath("//*[@class='formbuttons']/h3[@class='demo']"));
		System.out.println(txt.getText());
		
		
	}

}
