package wrappers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
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
		driver.findElementByClassName(classVal).click();
		System.out.println("The Buttton with class Name "+classVal+ " is clicked");

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

}
