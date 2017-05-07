package week2Day1;

import java.util.Set;

import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindow {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		String myTitle = driver.getTitle();

		String myCurrentUrl = driver.getCurrentUrl();

		System.out.println(myTitle +"	"+ myCurrentUrl);

		String parentWindow = driver.getWindowHandle();

		System.out.println("My ParentWindow:: "+parentWindow);

		driver.findElementByLinkText("Contact Us").click();

		Set<String> allWindows = driver.getWindowHandles();

		for(String eachWindow : allWindows){

			if(eachWindow.equals(parentWindow)){
				continue;
			}
			driver.switchTo().window(eachWindow);

		}

		System.out.println("After switching");

		System.out.println(driver.getTitle()+"	"+ driver.getCurrentUrl());

		System.out.println(driver.getWindowHandle());


		for (String eachWindow : allWindows) {

			if(!eachWindow.equals(parentWindow)){
				driver.switchTo().window(eachWindow);
				if(driver.getTitle().equals("YellowWindow")){
					break;
				}
			}


		}

	}


}





















