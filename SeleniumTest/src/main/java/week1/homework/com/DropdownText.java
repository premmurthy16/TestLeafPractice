/**
 * 
 */
package week1.homework.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author admin1
 *
 */
public class DropdownText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		// TODO Auto-generated method stub
		
		
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "./geckodriver_32bit.exe");
		
				//FirefoxDriver driver=new FirefoxDriver();
		
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		//maximize
		driver.manage().window().maximize();
		
		
		//userRegistrationForm:nationalityId
		
		WebElement dropdownList=driver.findElementById("userRegistrationForm:nationalityId");
		Select list=new Select(dropdownList);
		for(int i=1;i<list.getOptions().size();i++){
		String list1=list.getOptions().get(i).getText();
		
		System.out.println(list1);
		
		}
		
		

	}

}
