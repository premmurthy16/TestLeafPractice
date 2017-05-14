/**
 * 
 */
package week1.homework.com;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author admin1
 *
 */
public class LearnWindowHandler {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
	
		
		driver.get("http://leaftaps.com/control/main");
		
		//maximize
		driver.manage().window().maximize();
		//LoginId
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		
		driver.findElementById("password").sendKeys("crmsfa");
		
	    driver.findElementByClassName("decorativeSubmit").click();
	    
	    driver.findElementByLinkText("CRM/SFA").click();
	    
	    driver.findElementByLinkText("Leads").click();
	    
	   driver.findElementByLinkText("Merge Leads").click();
	   
	   //Parent Window
	   
	  String parentWin= driver.getWindowHandle();

	   driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
	   Thread.sleep(3000);
	   
	   Set<String> allWin=driver.getWindowHandles();
	   
	   for( String newWin  :allWin){
		   
		   if(!newWin.contentEquals(parentWin)){
			   
			   driver.switchTo().window(newWin);
			   
			   driver.findElementByXPath("//label[contains(text(),'Lead ID:')]/following::input").sendKeys("120");
			 driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			   Thread.sleep(3000);
			   driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
			   driver.switchTo().window(parentWin);
			   
			  
		   }
		   
		   		   
	   }
			
	   
	   
			   
 		  
		   		
	
	   driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	   Thread.sleep(3000);
	   Set<String> allWinTwo=driver.getWindowHandles();
	 
	
		   
	   System.out.println(driver.getCurrentUrl());  
		   
		   Thread.sleep(5000);
		   
		   for( String new1WinTwo  :allWinTwo){
			   
			   if(!new1WinTwo.contentEquals(parentWin)){
				   driver.switchTo().window(new1WinTwo);
				   driver.findElementByXPath("//label[contains(text(),'Lead ID:')]/following::input").sendKeys("206");
			   
				   
				   driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
				   
				   Thread.sleep(5000);
				   driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
				   driver.switchTo().window(parentWin);
			   }
		   }
			 
	
	  driver.findElementByLinkText("Merge").click();
			  driver.switchTo().alert().accept();
			  
			  Thread.sleep(3000);
			  
			  driver.findElementByLinkText("Find Leads").click();
			  
			  driver.findElementByXPath("//label[contains(text(),'Lead ID:')]/following::input").sendKeys("200");
			  driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			  
			 //System.out.println(driver.findElementByXPath("//div[contains(text(),'No records to display')]").getText());
			 	   }
	   
	   
	}





		

	


