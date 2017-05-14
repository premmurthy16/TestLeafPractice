package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	    
	    WebElement src1=driver.findElementById("createLeadForm_dataSourceId");
	    Select source=new Select(src1);
	    source.selectByVisibleText("Existing Customer");
	   
	    
	    WebElement src2=driver.findElementById("createLeadForm_industryEnumId");
	    Select industry=new Select(src2);
	    industry.selectByIndex(8);
	    
	    WebElement src3=driver.findElementById("createLeadForm_ownershipEnumId");
	    Select owner=new Select(src3);
	    owner.selectByValue("OWN_CCORP");
	    
	    
	    	    
	    
	    
	    //driver.close();
		

	}

}
