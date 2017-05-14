/**
 * 
 */
package week2.Homework.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

/**
 * @author admin1
 *
 */
public class DuplicateLeads extends GenericWrappers{

RemoteWebDriver driver;
	
	
	
	@Test
	public void launchBrowser() throws InterruptedException{
		
		invokeApp("chrome", "http://leaftaps.com/control/main");
   
		
		enterById("username", "DemoCSR");
		
		
		enterById("password", "crmsfa");
	
		clickByClassName("decorativeSubmit");
	
		clickByLink("CRM/SFA");
		
		clickByLink("Leads");
		clickByLink("Find Leads");
		Thread.sleep(5000);
		
		clickById("ext-gen240__ext-gen280");
		
		System.out.println("Email button is clicked");
		Thread.sleep(3000);
		//*[@id="ext-gen289"]
		//clickByName("emailAddress");
		
		//clickByNameSendKey("emailAddress","namek1@kkk.cc");
		//Thread.sleep(3000);
		clickByXpathSendKey("//INPUT[@id='ext-gen282']", "namek1@kkk.cc");
		//enterById("ext-gen289", "namek1@kkk.cc");
		//clickByXpath("//*[@id='ext-gen289']", );
		System.out.println("Email id is sent");
		
		clickById("ext-gen334");
		System.out.println("Find Lead button is clicked");
		Thread.sleep(3000);	
		getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
		
		System.out.println("First Resulting Lead Name is captured");
		
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
		
		// verifyTextByXpath(String xpath, String text);
		clickByLink("Duplicate Lead");
		 //clickByLink("Duplicate Lead");
		 
		 clickByName("submitButton");
		 //verifyTitle("Duplicate Lead");
		 verifyTitle("Duplicate Lead");
		// verifyTextById("viewLead_firstName_sp" ,"firstResultingName");
		 verifyTextById("viewLead_firstName_sp");
		
		 
		// verifyTextContainsTitle("Duplicate Lead") ;
		 //WebElement name=driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
		// System.out.println(getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		// System.out.println(name.getText());
		 	
		// name.getText();
		///WebElement name=driver.findElementByXPath("//*[starts-with(@id, 'ext-gen')]/*[(class,'linktext')]");
		//String firstName=name.getText();	
		//System.out.println(firstName);
		
		/*driver.findElementByXPath("//*[starts-with(@id, 'ext-gen')]/*[(class=",'linktext')]")
		for (int i=1;i<=9;) {

			String mpath= "//*[@id='ext-gen90']"+i+"']";

			WebElement name=driver.findElementById(mpath);
			//*[@id="ext-gen913"]
			
		//WebElement name=driver.findElementByCssSelector(using)
		String firstName=name.getText();
	System.out.println(firstName);
		}*/
		/*
		clickByXpathName("//A[@id='ext-gen925']");
		Thread.sleep(5000);
		clickByXpathLabel("//A[@id='ext-gen925']");
		System.out.println("First id is clicked");*/
		
		
		//getTextById("ext-gen1092");
		//clickById("ext-gen1092");
		/*
		//clickByXpath("//SPAN[@id='ext-gen861']");
		//lickByName("x-tab-strip-text ");
		//clickById("ext-gen863");
		clickById("ext-gen1092");
		ext-gen1092
		//clickByXpath("//*[@id='ext-gen864']");*/
		
		//clickById("ext-gen1092");
		
		
		
		
		//clickById("ext-gen604");
		
		System.out.println("Duplicate button is clicked");
	/*
	getTextById("ext-gen930");
	
	clickById("ext-gen909");
	
	clickByLink("Duplicate Lead");
	verifyTextById("sectionHeaderTitle_leads", "Duplicate Lead");
	
	clickByClassName("smallSubmit");
	

	
	//verifyTextById("viewLead_firstName_sp", "Duplicate Lead");

	*/
	
	
	}

}


