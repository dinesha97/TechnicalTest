package TestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TechTest {
	
	WebDriver driver;
	@Test
	public void WebpageTest() throws InterruptedException
	{
		String expectedURL = "https://www.pearson.com/en-gb.html";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dines\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pearson.com/en-gb.html");
		driver.manage().window().maximize();
		//check the correct URL navigation
		try {
			Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			System.out.println("Naviagted to the Pearson home page");
		}
		catch(Throwable pageNavigationError) 
		{
			System.out.println("Navigated to the wrong URL");
		}
		
		//Navigate to the blackfriday offer site
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		Thread.sleep(2000);
		WebElement shop = driver.findElement(By.xpath("//*[@id=\"main-content-starts\"]/div[1]/div/div[1]/div/section/div[2]/div/div[1]/div[2]/div/div/div/div/p/a"));
		Thread.sleep(2000);
		shop.click();
		
		String ExpectedTitle = "Black Friday – Pearson.com";
		String ActualTile = driver.getTitle();
		try {
			Assert.assertEquals(ActualTile, ExpectedTitle);
			System.out.println("Navigated to the Black Friday Sale");
			
		}catch(Throwable PageNavogationError) 
		{
			System.out.println("Navigated to the wrong URL");
		}
		
	}
	
	@AfterTest
	public void closeWindow() 
	{
		driver.close();
	}
	
	
	
	
}


