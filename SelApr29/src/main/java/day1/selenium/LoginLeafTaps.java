package day1.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLeafTaps {
	
	public static void main(String[] args) {
		
		//launch the Browser - Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//sys
		//ClassName obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Load URL
		driver.get("http://leaftaps.com");
		//Maximize 
		driver.manage().window().maximize();
		//Enter the UserName
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter the Password
		driver.findElementById("password").sendKeys("crmsfa");
		//click Login Button
		driver.findElementByClassName("decorativeSubmit").click();
		//click LogOut Button
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		
	

	}

}










