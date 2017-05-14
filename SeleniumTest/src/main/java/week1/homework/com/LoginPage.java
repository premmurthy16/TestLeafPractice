/**
 * 
 */
package week1.homework.com;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author admin1
 *
 */
public class LoginPage {
	
	

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "./geckodriver_32bit.exe");
		
				//FirefoxDriver driver=new FirefoxDriver();
		
		driver.get("http://leaftaps.com/control/main");
		
		//maximize
		driver.manage().window().maximize();
		//LoginId
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		
		driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByClassName("decorativeSubmit").click();
	    
	    driver.findElementByXPath("//*[@id='label']/a").click();
	    
	    driver.findElementByLinkText("Create Lead").click();
	    
	    driver.findElementById("createLeadForm_companyName").sendKeys("TestLeafCompanyOfTestCommitee" );
	    
	    driver.findElementByXPath("//INPUT[@id='createLeadForm_firstName']").sendKeys("TestLeaf");
	    
	    driver.findElementByXPath("//INPUT[@id='createLeadForm_lastName']").sendKeys("Commetiee");
	    
	    driver.close();
		
	//System.out.println(driver.getCurrentUrl());
	//driver.findElementByClassName("decorativeSubmit").click();
	//System.out.println(driver.getCurrentUrl());
}}
