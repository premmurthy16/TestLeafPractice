package week2Day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Learnframe {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/

		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/selectable/");
		
		WebElement myFrame = driver.findElementByClassName("demo-frame");
		
		driver.switchTo().frame(myFrame);	
		
		
		driver.findElementByXPath("//*[@id='selectable']/li[2]").click();

		driver.switchTo().defaultContent();https://www.irctc.co.in/eticketing/loginHome.jsf
		
		driver.findElementByLinkText("Demos").click();

		System.out.println("done");
	}


}














