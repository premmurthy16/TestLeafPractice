package week2Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		driver.findElementByLinkText("Check Availability").click();
		
		Thread.sleep(2000);
		
		Alert alt =	driver.switchTo().alert();
		
		System.out.println(alt.getText());
		
		alt.accept();
		
		/*String txt = driver.switchTo().alert().getText();
		
		System.out.println(txt);
		
		driver.switchTo().alert().accept();
*/	}

}











