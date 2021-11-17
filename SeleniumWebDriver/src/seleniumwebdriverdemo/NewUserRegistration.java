package seleniumwebdriverdemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class NewUserRegistration 
{

	public static void main(String args[])throws Throwable
	{
		//Initiate the web browser
		ChromeDriver driver=new ChromeDriver();

		//Navigate to browser URL
		driver.get("https://adactinhotelapp.com/");

		//Click on the New Registration user
		driver.findElement(By.xpath("//a[@href='Register.php']")).click();
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Enter the username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("LokeshNai5");
		Thread.sleep(1000);

		//Enter the password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lokesh7");
		Thread.sleep(1000);

		//Enter the password for the confirmation
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys("lokesh7");
		Thread.sleep(1000);

		//Enter Full name of the user
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("Lokesh Naik");
		Thread.sleep(1000);

		//Enter the valid email address
		driver.findElement(By.xpath("//input[@id='email_add']")).sendKeys("naik28476@gmail.com");
		Thread.sleep(1000);

		File src=driver.findElement(By.xpath("//img[@id='captcha']")).getScreenshotAs(OutputType.FILE);

		Thread.sleep(10000);
		String path=System.getProperty("user.dir")+"/screenshots/captcha.png";

		FileHandler.copy(src,new File(path));

		//Method for capturing the screenshot of a dynamically allocated Captcha given by the application
		ITesseract image=new Tesseract();
		image.setDatapath("C:\\Program Files\\Java\\OCR\\tessdata"); 
		image.setLanguage("eng");
		String i="";
		try 
		{
			String str=image.doOCR(new File(path));
			String[]s=str.split("   "); 
			i=s[0].replaceAll("[^a-zA-Z]","");
			System.out.println("Data from image is "+ i);
		}
		catch(TesseractException e)
		{
			e.printStackTrace();
		}

		//Click the check box to agree the conditions
		driver.findElement(By.xpath("//input[@id='tnc_box']")).click();
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Enter the captcha
		driver.findElement(By.xpath("//input[@id='captcha-form']")).sendKeys(i);     
		Thread.sleep(10000);

		//Click on submit button
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		Thread.sleep(10000);
		
		
		String Expected="Click here to login";
		
		String Actual=driver.findElement(By.xpath("//a[@href='index.php']")).getText();

		Assert.assertEquals(Expected,Actual);
		//Close the browser
		driver.close();

	}

}
