package com.Login;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserCreate {
	
	public static void main (String args []) throws InterruptedException{
		
		String URL = "https://www.marathishaadi.com/";
		String Email = "test@test.com";
		String Password = "1234567890";
		String ProfileFor = "Self";
	
			String projectPath = System.getProperty("user.dir");

		
			System.out.println(projectPath);

			System.setProperty("webdriver.chrome.driver" , projectPath+"\\Drivers\\ChromeDriver\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			driver.get(URL);
			
			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);
			
			String [] SplitPageTitle = PageTitle.split(" ");
			System.out.println(SplitPageTitle[0]);
			String CommunityName = SplitPageTitle[0];
			
			driver.findElement(By.xpath("//button[@class='btn-primary form-control']")).click();
			
			WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
			email.clear();
			email.sendKeys(Email);
			
			WebElement password = driver.findElement(By.xpath("//input[@name='password1']"));
			password.clear();
			password.sendKeys(Password);
			
			driver.findElement(By.xpath("//div[@class='Dropdown-control postedby_selector']")).click();
			
			List<WebElement> list= driver.findElements(By.xpath("//div[@class='Dropdown-menu postedby_options']//div[@class='Dropdown-option']"));
			
			for (WebElement ele : list)
			{
				if (ele.getText().equalsIgnoreCase(ProfileFor))
				{
					ele.click();
					if (ProfileFor.equalsIgnoreCase("Self"))
					{
					driver.findElement(By.xpath("//input[@id='gender_male']")).click();
					}
					break;
							
			}
				
			Thread.sleep(2000);
			
			}
			
			driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
			
			Thread.sleep(2000);
			
			String MotherToung = driver.findElement(By.xpath("//div[@class='Dropdown-control mother_tongue_selector Dropdown-disabled']")).getText();
			
			System.out.println(MotherToung);
			
			if (CommunityName.equalsIgnoreCase(MotherToung))
			{
				System.out.println("Community name and Mother toung are same");
				
			} else
			{
				System.out.println("Community name and Mother toung are different");
			}
			
			
			
			
//			Thread.sleep(4000);
			
//			driver.close();
			
			
			
			}
	}



	


