package SeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		WebElement email= driver.findElement(By.name("email"));
		email.sendKeys("shar@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Sharmi@123");
		
	    WebElement login = driver.findElement(By.xpath("//button[@value='1']"));
	    login.click();
	    //code 31-34 doesn't work but still i have written
	    if(login.getText()=="The password that you've entered is incorrect. Forgotten password?")
	    {
	    	System.out.println("Wrong password");
	    }
	    else
	    {
	    	System.out.println("sign up");
	    	driver.get("https://www.facebook.com/signup");
	    	driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
	    	System.out.println("Signed up successfully");
	    	WebElement firstname = driver.findElement(By.name("firstname"));
		    firstname.sendKeys("Sharmila");
		    WebElement surname = driver.findElement(By.name("lastname"));
		    surname.sendKeys("Ganesan");
		    WebElement mobnum = driver.findElement(By.name("reg_email__"));
		    mobnum.sendKeys("1234567890");
		    WebElement newpass = driver.findElement(By.name("reg_passwd__"));
		    newpass.sendKeys("Shar@12345");
		    WebElement Day= driver.findElement(By.name("birthday_day"));
		    Select day = new Select(Day);
		    day.selectByVisibleText("27");
		    WebElement Month = driver.findElement(By.name("birthday_month"));
		    Select month = new Select(Month);
		    month.selectByVisibleText("Jan");
		    WebElement Year = driver.findElement(By.name("birthday_year"));
		    Select year = new Select(Year);
		    year.selectByVisibleText("1997");
		    
		    List<WebElement> monthlist= month.getOptions();
		   
		   
		    for(WebElement e : monthlist)
		    {
		    	System.out.println("the month list is "+ e.getText());
		    }
		    
		    
		    List<WebElement> AllYears = driver.findElements(By.xpath("//select[@name='birthday_year']/option[@selected='1']"));
			for(WebElement elm: AllYears)
			{
				System.out.println(elm.getText());	
				}
			
			String gender ="Male";
			if(gender=="Female")
			{
				WebElement female = driver.findElement(By.xpath("//input[@type='radio']"));
			    female.click();	
			}
			else if (gender=="Male")
			{
				WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
				male.click();
			}
			else {
				WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));
				custom.click();
			}
		    
			WebElement signup= driver.findElement(By.xpath("//button[@type='submit']"));
			signup.click();
			
		
			
	
			
	    
	    }
	 
	driver.close();
	    
	    
	    
	}

}
