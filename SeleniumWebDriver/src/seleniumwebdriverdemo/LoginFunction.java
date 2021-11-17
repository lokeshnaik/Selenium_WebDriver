package seleniumwebdriverdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.GetElementText;
import org.junit.Assert;

public class LoginFunction {

	public static void main(String[] args) throws Throwable
	{
		
       //Open the web browser
		ChromeDriver driver=new ChromeDriver();
        
		//Navigate to the web application
		driver.navigate().to("https://adactinhotelapp.com/");
		//driver.get("https://adactinhotelapp.com/");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Enter the Email address
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jack0709");
		Thread.sleep(2000);

		//Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("saikiraN07");
		Thread.sleep(2000);
		
		//Click the login button
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Thread.sleep(2000);
		
		//Get the confirmation using Assert methods
		String Actual=driver.findElement(By.xpath("//td[@class='login_title']")).getText();
		
		String Expected="Search Hotel (Fields marked with Red asterix (*) are mandatory)";
        
		Assert.assertEquals(Expected,Actual);
		
		System.out.println("Hey Lokesh");
		
		//Quit the browser
		//driver.quit();
		
		//Close the browser
		driver.close();

	}

}
