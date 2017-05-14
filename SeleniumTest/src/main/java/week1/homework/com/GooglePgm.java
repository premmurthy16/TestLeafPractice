/**
 * 
 */
package week1.homework.com;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author admin1
 *
 */
public class GooglePgm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();

		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=FRoOWduCGefx8AeAm4yoDA");
		driver.manage().window().maximize();
		driver.findElementByXPath("//*[@id='lst-ib']").sendKeys("veronika");
		
	}

}
