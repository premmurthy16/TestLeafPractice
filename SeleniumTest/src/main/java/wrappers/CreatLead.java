/**
 * 
 */
package wrappers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

/**
 * @author admin1
 *
 */
public class CreatLead implements Wrappers{
	
	RemoteWebDriver driver;
	
	@Test

	public void invokeApp(String browser, String url) {
if(browser.equalsIgnoreCase("chrome")){	
		
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//ChromeDriver driver=new ChromeDriver();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
}

else if(browser.equalsIgnoreCase("gecko")){
	
	System.setProperty("webdriver.gecko.driver", "./geckodriver_32bit.exe");
	
	//ChromeDriver driver=new ChromeDriver();
	
	driver=new FirefoxDriver();
	
	driver.manage().window().maximize();
		
	}

/*
		driver.get("http://leaftaps.com/control/main");
		
		//maximize
		
	
	
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	/*public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "./geckodriver_32bit.exe");
		
				//FirefoxDriver driver=new FirefoxDriver();
		
		driver.get("http://leaftaps.com/control/main");
		
		//maximize
		driver.manage().window().maximize();*/
	
	
		//LoginId
		/*driver.findElementById("username").sendKeys("DemoSalesManager");
		
		
		driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByClassName("decorativeSubmit").click();
	    
	    driver.findElementByXPath("//*[@id='label']/a").click();
	    
	    driver.findElementByLinkText("Create Lead").click();
	    
	    driver.findElementById("createLeadForm_companyName").sendKeys("TestLeafCompanyOfTestCommitee" );
	    
	    driver.findElementByXPath("//INPUT[@id='createLeadForm_firstName']").sendKeys("TestLeaf");
	    
	    driver.findElementByXPath("//INPUT[@id='createLeadForm_lastName']").sendKeys("Commetiee");
	    
	    driver.close();*/
		
	//System.out.println(driver.getCurrentUrl());
	//driver.findElementByClassName("decorativeSubmit").click();
	//System.out.println(driver.getCurrentUrl());
}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}}
