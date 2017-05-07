package week2Day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		//Launch the Browser
		System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
	//	ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://testleaf.herokuapp.com/pages/Dropdown.html");
		
		
	// Type 1 dropdown
		// Handle the dropdown
		WebElement dd = driver.findElementByName("dropdown2");	
	
		Select dropdown = new Select(dd);
		
		 // dropdown.selectByIndex(2);		
		 // dropdown.selectByValue("3");		
			dropdown.selectByVisibleText("Appium");
				
		//Get the size of Options
		List<WebElement> allOptions = dropdown.getOptions();
		System.out.println(allOptions.size());
		
		//select the last value in Dropdown
		dropdown.selectByIndex(allOptions.size()-1);		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		// Type2 dropdown :: Multiple Select Dropdown values
		
		/*WebElement multiple = driver.findElementByXPath("//*[@id='contentblock']/section/div[6]/select");
		
		Select mul = new Select(multiple);
		System.out.println(mul.getFirstSelectedOption().getText());
		
		mul.selectByIndex(1);
		mul.selectByIndex(2);
		mul.selectByIndex(3);
		System.out.println(mul.getFirstSelectedOption().getText());		
		*/
	}
}
