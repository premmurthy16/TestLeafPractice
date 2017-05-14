package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	String parentWindow;
	//String firstResultingName;
	static String name="";
	int i;
	//String titleText="Duplicate Lead";

	public void invokeApp(String browser, String url) {
		try {
			//if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				driver = new ChromeDriver(); // launch browser	
			//}else if(browser.equalsIgnoreCase("firefox")){
				//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				//driver = new FirefoxDriver(); // launch browser	
			//}		
			driver.get(url); // enter url 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" launched successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The Text field "+idValue+ " is entered with text data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		
	}
	

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(nameValue).sendKeys(data);
			System.out.println("The Text field with ClassName"+nameValue+ " is entered with text data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathValue).sendKeys(data);
		System.out.println("The Text field with xpath"+xpathValue+ " is entered with text data");

	}	


	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		if(driver.getTitle().equals(title))
			System.out.println("verified the title "+ title+"successfully" );
		else
			System.out.println("The title "+ driver.getTitle()+"does not present" );
	}	

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		if(driver.findElementById(id).getText().equals(text))
			System.out.println("verified the text "+ text+"successfully" );
		else
			System.out.println("The text "+ text+"is not present" );

	}
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		if(driver.findElementByXPath(xpath).getText().equals(text))
			System.out.println("verified the text "+ text+"successfully" );
		else
			System.out.println("The text "+ text+"is not present" );
	}
		

	public void verifyTextContainsByXpath(String xpath, String text) {		
		// TODO Auto-generated method stub
		if(driver.findElementByXPath(xpath).getText().equals(text))
			System.out.println("verified the text "+ text+"successfully" );
		else
			System.out.println("The text "+ text+"is not present" );
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		driver.findElementById(id).click();
		System.out.println("The Buttton with ID  "+id+ " is clicked");
	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		System.out.println("The Buttton with class Name "+classVal+ " is clicked");
		

	}


	public void clickByName(String name) {
		// TODO Auto-generated method stub		
		driver.findElementByName(name).click();
		System.out.println("The Buttton with Name "+name+ " is clicked");
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
driver.findElementByLinkText(name).click();
		
System.out.println("The link "+name+"is clicked");
	}


	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		driver.findElementByLinkText(name).click();
		System.out.println("The Link "+name+ " is clicked");
	}



	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The Link/button with XPath "+xpathVal+ " is clicked");
	}
	
	

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The Link/button with XPath "+xpathVal+ " is clicked");
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		System.out.println("The Text of "+idVal +" is " + driver.findElementById(idVal).getText() );
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		name=driver.findElementByXPath(xpathVal).getText();
		System.out.println("The Name Text of " +"is " + name);
		return name;
	}


	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		Select dropDowns = new Select(driver.findElementById(id));
		dropDowns.selectByVisibleText(value);
		System.out.println("Selected "+value +"from dropdown " + id );
	}
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		Select dropDowns = new Select(driver.findElementById(id));
		dropDowns.selectByIndex(value);
		System.out.println("Selected "+value +"from dropdown " + id );
		
	}
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		driver.switchTo().window(parentWindow);
		System.out.println("Switched to Parent Window "+driver.getCurrentUrl());
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		Set<String> allWindows = driver.getWindowHandles();
		for ( String eachwindow : allWindows) {
			
			if(eachwindow!=parentWindow){
			driver.switchTo().window(eachwindow);
			
			}
		}
		System.out.println("Switched to "+driver.getCurrentUrl()+ " window");
		
		
			
		
	}
	public void acceptAlert() {
		// TODO Auto-generated method stub
		String alertText=  driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(" The alert " + alertText + " is accepted ");
	}
		public void dismissAlert() {
			// TODO Auto-generated method stub
			String alertText=  driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.println(" The alert "+ alertText+ " is dismissed ");
		}

		public String getAlertText() {
			// TODO Auto-generated method stub
			System.out.println(" The alert is  " + driver.switchTo().alert().getText() );
			return null;
		}

		public void takeSnapAll() throws Exception {
			// TODO Auto-generated method stub
			 //Convert web driver object to TakeScreenshot
			Date date = new Date();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			String d = date.toString().replace(" ","" ).replace(":", "");
	           FileUtils.copyFile(scrFile, new File("D:\\screenshot1\\screenshot"+d+".png"));
		}
		public void closeBrowser() {
			// TODO Auto-generated method stub
			driver.close();
		}

		public void closeAllBrowsers() {
			// TODO Auto-generated method stub
			driver.quit();
		}
	
	public void clickByXpathSendKey(String xpathVal, String value) {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath(xpathVal).sendKeys(value);
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		try {
			File src=driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./snaps/snap" + i + ".jpeg"));

	//FileUtils.copyDirectory(temp, dest);
	System.out.println("Snapshot Taken");
} 
		
	catch (IOException e) {
		System.err.println("IOException occured in taking snap " + e.getMessage());
		throw new RuntimeException("FAILED");
	} catch (WebDriverException e) {
		System.err.println("The Browser could not be found " + e.getMessage());
		throw new RuntimeException("FAILED");
	} catch (Exception e) {
		System.err.println("Unexpected exception in taking snap :" + e.getMessage());
		throw new RuntimeException("FAILED");
	}

	i++;
	
	
	}
	public void verifyTextContainsTitle(String text) {		
		// TODO Auto-generated method stub
		
		String title=driver.getTitle();
		if(title.equalsIgnoreCase(text)){
			System.out.println("verified the text "+ text+"successfully" );
		}
		else{
			System.out.println("The text "+ text+"is not present" );
	}
}
	
	public void verifyTextById(String id) {
		// TODO Auto-generated method stub
		if(driver.findElementById(id).getText().equals(name))
			System.out.println("verified the text "+ name+"successfully" );
		else
			System.out.println("The text "+ name+"is not present" );

	}
}
	
	//************************************
	
/*
package GenericMethodPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
static String parentWin;
static String textValue;
static String textValue2;

	public void invokeApp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			
			//ChromeDriver driver=new ChromeDriver();
			
			driver = new ChromeDriver(); // launch browser	
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver(); // launch browser	
		}		
		driver.get(url); // enter url 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("The Browser "+browser+" launched successfully");
	}

	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).click();
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text field "+idValue+ " is entered with text data");

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
      String caption=driver.findElementById(id).getText();

		if(caption.equalsIgnoreCase(text)){
			
			System.out.println("User landed to Duplicate Lead page");
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
driver.findElementById(id).click();
	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		System.out.println("The Buttton with class Name "+classVal+ " is clicked");

	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
driver.findElementByClassName(name).click();
	}

	
	public void clickByNameSendKey(String name,String keyVal) {
		// TODO Auto-generated method stub
driver.findElementByClassName(name).sendKeys(keyVal);
	}
	public void clickByLink(String name) {
		// TODO Auto-generated method stub

		driver.findElementByLinkText(name).click();
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpathLabel(String xpathVal) {
		
						// TODO Auto-generated method stub
	driver.findElementByXPath(xpathVal).click();
		
 

	}

	public void clickByXpathNoSnap(String xpathVal) {
		
	
		// TODO Auto-generated method stub
driver.findElementByXPath(xpathVal).click();
		
	}
	
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		textValue=driver.findElementById(idVal).getText();
		//return null;
		System.out.println(textValue);
		return textValue;
		
		
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
		//String parentWin= driver.getWindowHandle();
		 Set<String> allWin=driver.getWindowHandles();
		
		   for( String newWin  :allWin){
			  
			   if(!newWin.contentEquals(parentWin)){
				   
				   driver.switchTo().window(newWin);
			   }
	}
	}
	public void acceptAlert() {
		// TODO Auto-generated method stub
		 driver.switchTo().alert().accept();
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

	
	public void clickByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).sendKeys(value);
		
		
	}


	public WebElement clickByXpathSendKey(String xpathVal) {
		
		
		// TODO Auto-generated method stub
		
		
		return driver.findElementByXPath(xpathVal);
	}


	public void clickByXpathSendKey(String xpathVal, String value) {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath(xpathVal).sendKeys(value);
	}


	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
	}

	
	public void getParentWindow() {
		// TODO Auto-generated method stub
		parentWin= driver.getWindowHandle();
	}


	public void switchbackParentWindow() {
		// TODO Auto-generated method stub
		
		
		 driver.switchTo().window(parentWin);
	}

	
	public void switchToAlert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchAlert() {
		// TODO Auto-generated method stub
		
	}


	public void clickById() {
		// TODO Auto-generated method stub
		
	}


	public void verifyTextByIdbetweebmethod(String textVa1ue,String textValue2) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void verifyTextByIdbetweebmethod() {
		// TODO Auto-generated method stub
		
	}


	public void clickByXpathName(String xpathVal) {
		// TODO Auto-generated method stub
		String textName=driver.findElementByXPath(xpathVal).getText();
		
		System.out.println(textName);
	}
	
	public void clickByClassLinkText(String name) {
		// TODO Auto-generated method stub

		String nameText=driver.findElementByClassName(name).getText();
		
		System.out.println(nameText);
		
		driver.findElementByClassName(name).click();
		
	}


	public void clickByidClassname(String id) {
		
		
		// TODO Auto-generated method stub
		
		
		WebElement firstElementName=driver.findElementById(id);
		
		//WebElement name=idblock.findElement(By.className(cName));
		
		String ElementName=firstElementName.getText();
		
		System.out.println(ElementName);
	}

	@Override
	public void clickByLinkText(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickByidClassname(String id, String cName) {
		// TODO Auto-generated method stub
		
	}	
	
	public void clickByXpathSendKey(String xpathVal, String value) {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath(xpathVal).sendKeys(value);
	}
	
}
	//****************************
/*
package GenericMethodPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
static String parentWin;
static String textValue;
static String textValue2;

	public void invokeApp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			
			//ChromeDriver driver=new ChromeDriver();
			
			driver = new ChromeDriver(); // launch browser	
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver(); // launch browser	
		}		
		driver.get(url); // enter url 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("The Browser "+browser+" launched successfully");
	}

	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).click();
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text field "+idValue+ " is entered with text data");

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
      String caption=driver.findElementById(id).getText();

		if(caption.equalsIgnoreCase(text)){
			
			System.out.println("User landed to Duplicate Lead page");
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
driver.findElementById(id).click();
	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		System.out.println("The Buttton with class Name "+classVal+ " is clicked");

	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
driver.findElementByClassName(name).click();
	}

	
	public void clickByNameSendKey(String name,String keyVal) {
		// TODO Auto-generated method stub
driver.findElementByClassName(name).sendKeys(keyVal);
	}
	public void clickByLink(String name) {
		// TODO Auto-generated method stub

		driver.findElementByLinkText(name).click();
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpathLabel(String xpathVal) {
		
						// TODO Auto-generated method stub
	driver.findElementByXPath(xpathVal).click();
		
 

	}

	public void clickByXpathNoSnap(String xpathVal) {
		
	
		// TODO Auto-generated method stub
driver.findElementByXPath(xpathVal).click();
		
	}
	
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		textValue=driver.findElementById(idVal).getText();
		//return null;
		System.out.println(textValue);
		return textValue;
		
		
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
		//String parentWin= driver.getWindowHandle();
		 Set<String> allWin=driver.getWindowHandles();
		
		   for( String newWin  :allWin){
			  
			   if(!newWin.contentEquals(parentWin)){
				   
				   driver.switchTo().window(newWin);
			   }
	}
	}
	public void acceptAlert() {
		// TODO Auto-generated method stub
		 driver.switchTo().alert().accept();
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

	
	public void clickByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).sendKeys(value);
		
		
	}


	public WebElement clickByXpathSendKey(String xpathVal) {
		
		
		// TODO Auto-generated method stub
		
		
		return driver.findElementByXPath(xpathVal);
	}


	public void clickByXpathSendKey(String xpathVal, String value) {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath(xpathVal).sendKeys(value);
	}


	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		driver.findElementByXPath(xpathVal).click();
	}

	
	public void getParentWindow() {
		// TODO Auto-generated method stub
		parentWin= driver.getWindowHandle();
	}


	public void switchbackParentWindow() {
		// TODO Auto-generated method stub
		
		
		 driver.switchTo().window(parentWin);
	}

	
	public void switchToAlert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchAlert() {
		// TODO Auto-generated method stub
		
	}


	public void clickById() {
		// TODO Auto-generated method stub
		
	}


	public void verifyTextByIdbetweebmethod(String textVa1ue,String textValue2) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void verifyTextByIdbetweebmethod() {
		// TODO Auto-generated method stub
		
	}


	public void clickByXpathName(String xpathVal) {
		// TODO Auto-generated method stub
		String textName=driver.findElementByXPath(xpathVal).getText();
		
		System.out.println(textName);
	}
	
	public void clickByClassLinkText(String name) {
		// TODO Auto-generated method stub

		String nameText=driver.findElementByClassName(name).getText();
		
		System.out.println(nameText);
		
		driver.findElementByClassName(name).click();
		
	}


	public void clickByidClassname(String id) {
		
		
		// TODO Auto-generated method stub
		
		
		WebElement firstElementName=driver.findElementById(id);
		
		//WebElement name=idblock.findElement(By.className(cName));
		
		String ElementName=firstElementName.getText();
		
		System.out.println(ElementName);
	}

	@Override
	public void clickByLinkText(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickByidClassname(String id, String cName) {
		// TODO Auto-generated method stub
		
	}
	
}*/
	
	


