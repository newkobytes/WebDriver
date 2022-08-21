package SeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
		List<WebElement> rows =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")) ;
	    System.out.println("the row is " + rows.size());
	    List<WebElement> columns =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")) ;
	    System.out.println("the column is " + columns.size());
	    
	
	   //WebElement data =driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[2]")) ;
	   // System.out.println("the data is " + data.getText());
	    
	    //To print all the data
	   // List<WebElement> AllData = driver.findElements(By.xpath("//table[@id='customers']"));
	   // for(WebElement a : AllData)
	   // {
	   // System.out.println(a.getText());	
	   // }
	    
	    
	   //to iterate thro each rows and columns
	   // for(WebElement row : rows)
	   // {
	    //	List<WebElement> cells = row.findElements(By.tagName("td"));//instead of row i have given driver
	    //	for(WebElement cell: cells)
	    //	{
	    //		System.out.println(cell.getText() + "\t");
	    //	}
	    //	System.out.println();
	   // }
	    
for(int row=1; row<=rows.size();row++) {
			
			for(int col=1;col<=columns.size();col++) {
				
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + row + "]/*[" + col + "]"));
				System.out.print(cell.getText() + "\t");
			}
			
			System.out.println();

}

//to print the column names:
System.out.println("The column names are" );
for (WebElement col:columns)
{
		System.out.println(col.getText());
		
	}
	
//to find the row names:

System.out.println("The row names are");
for(WebElement row:rows)
{
	System.out.println(row.getText());
}

//to find a particular value
String Company = "Ernst Handel";

String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
WebElement Country = driver.findElement(By.xpath(Xpath));
System.out.println("The country is " + Country.getText());

//to find sibling and parent:

String contact="Roland Mendels";

String Xpathsibling = "//td[text()='" + contact + "']/following-sibling::td[1]"; ////td[text()='Maria Anders']/following-sibling::td[1]
WebElement country1 = driver.findElement(By.xpath(Xpathsibling));
System.out.println("The country name for the " + contact + " is " + country1.getText());

String Xpathparent = "//td[text()='" + contact + "']/preceding-sibling::td[1]";
WebElement company = driver.findElement(By.xpath(Xpathparent));
System.out.println("The company name for the " + contact + " is " + company.getText());


	}
	
	

}
