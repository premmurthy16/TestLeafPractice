/**
 * 
 */
package week2.Homework.com;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

/**
 * @author admin1
 *
 */
public class CreateLeadWrapperClass extends GenericWrappers {

	@Test
	public  void CreateLeads() throws Exception {			
		
		
		invokeApp("chrome","http://www.leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkNoSnap("CRM/SFA");
		clickByLinkNoSnap("Create Lead");
		enterById("createLeadForm_companyName","companyNameVK");
		enterById("createLeadForm_firstName", "firstNameVK");
		enterById("createLeadForm_lastName", "lastNameVK");
		clickByXpathNoSnap("(//div[@class='fieldgroup-body'])/table/tbody/tr[1]/td[4]/a");
		Thread.sleep(3000);
		//clickByXpathNoSnap("(//*[@id='ext-gen273']");
		//*[@id="ext-gen273"]
		//getWindow();
		switchToLastWindow();
		enterByXpath("//*[@id='ext-gen25']","13246");
		clickByClassName("x-btn-text");
		Thread.sleep(2000);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		Thread.sleep(3000);
		
		switchToParentWindow();
		selectVisibileTextById("createLeadForm_dataSourceId","Conference");
		selectVisibileTextById("createLeadForm_marketingCampaignId", "Pay Per Click Advertising");			
		enterById("createLeadForm_firstNameLocal", "firstNameVK");
		enterById("createLeadForm_lastNameLocal", "lastNameVK");
		enterById("createLeadForm_personalTitle", "Mr.");
		enterById("createLeadForm_birthDate", "10/16/89");
		enterById("createLeadForm_generalProfTitle","Engineer");
		enterById("createLeadForm_departmentName","QA");
		enterById("createLeadForm_annualRevenue","100000");
		selectVisibileTextById("createLeadForm_currencyUomId","INR - Indian Rupee");
		selectVisibileTextById("createLeadForm_industryEnumId","Computer Software");
		enterById("createLeadForm_numberEmployees","100");
		selectVisibileTextById("createLeadForm_ownershipEnumId","Partnership");
		enterById("createLeadForm_sicCode","12243569");
		enterById("createLeadForm_tickerSymbol", "check");
		enterById("createLeadForm_description", "good company");
		enterById("createLeadForm_importantNote", "emminent employee");
		enterById("createLeadForm_primaryPhoneCountryCode", "91");
		enterById("createLeadForm_primaryPhoneNumber", "9876543210");
		enterById("createLeadForm_primaryPhoneAreaCode", "044");
		enterById("createLeadForm_primaryPhoneAskForName","9638527410");
		enterById("createLeadForm_primaryEmail", "test@testleaf.com");
		enterById("createLeadForm_primaryWebUrl", "www.test.com");
		enterById("createLeadForm_generalToName", "ramesh");
		enterById("createLeadForm_generalAttnName","tester");
		enterById("createLeadForm_generalAddress1", "first main road");
		enterById("createLeadForm_generalAddress2", "vivekanada road");
		enterById("createLeadForm_generalCity", "chennai");			
		enterById("createLeadForm_generalPostalCode", "600100");
		selectVisibileTextById("createLeadForm_generalCountryGeoId", "India");
		enterById("createLeadForm_generalPostalCodeExt", "111");
		selectVisibileTextById("createLeadForm_generalStateProvinceGeoId", "TAMILNADU");
		clickByClassName("smallSubmit");
		takeSnap();
		closeAllBrowsers();
		//clickByLinkNoSnap("Logout");
		// TODO Auto-generated method stub		
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();				
		//set path
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//create chrome driver object
		//ChromeDriver drive =new ChromeDriver();
		//Load URL
		driver.get("http://www.leaftaps.com");
		*///Enter the username
		
		/*driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		//click login*/
		 
	/*driver.findElementByClassName("decorativeSubmit").click();
		//click CRMSFA
		driver.findElementByLinkText("CRM/SFA").click();
		//create leads
*/			/*driver.findElementByLinkText("Create Lead").click();
		//fill company name
		driver.findElementById("createLeadForm_companyName").sendKeys("companyNameVK");
		//driver.findElementByXPath("//*[@id='createLeadForm_companyName']").sendKeys("companyNameVK");
		//fill first name
		driver.findElementById("createLeadForm_firstName").sendKeys("firstNameVK");
		//fill last name
		driver.findElementById("createLeadForm_lastName").sendKeys("lastNameVK");
		//click create lead
		driver.findElementByClassName("smallSubmit").click();			
		//click logout
		driver.findElementByLinkText("Logout").click();	*/
		
	}
}
