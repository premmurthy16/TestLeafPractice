package day1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class sample5 {
   WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("disable-infobars");
	  options.addArguments("--disable-extensions");
	  options.addArguments("--disable-notifications");
	  options.addArguments("--start-maximized");
	  options.addArguments("--disable-web-security");
	  options.addArguments("--no-proxy-server");
	  options.addArguments("--enable-automation");
	  options.addArguments("--disable-save-password-bubble");

	  Map<String, Object> prefs = new HashMap<String, Object>();
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled", false);
	  options.setExperimentalOption("prefs", prefs);

	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	  driver = new ChromeDriver(capabilities);
	  DesiredCapabilities.chrome();
	 // driver = new ChromeDriver();
   // driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSample5() throws Exception {
   driver.get(baseUrl + "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
   // driver.findElement(By.cssSelector("span.gb_9a.gbii")).click();
   // driver.findElement(By.id("gb_71")).click();
   // driver.findElement(By.id("account-chooser-link")).click();
  //  driver.findElement(By.id("edit-account-list")).click();
    //driver.findElement(By.id("choose-account-0")).click();
   // driver.findElement(By.id("Email")).clear();
   driver.manage().window().maximize();
	  Thread.sleep(3000);
    driver.findElement(By.id("Email")).sendKeys("premmarvin16");
    Thread.sleep(3000);
    driver.findElement(By.id("next")).click();
    Thread.sleep(4000);
    driver.findElement(By.id("Passwd")).clear();
    Thread.sleep(4000);
    driver.findElement(By.id("Passwd")).sendKeys("marvin@1622");
    Thread.sleep(4000);
    driver.findElement(By.id("signIn")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div/div/div/div")).click();
    driver.findElement(By.id(":nf")).clear();
    driver.findElement(By.id(":nf")).sendKeys("prem.murthy16@gmail.com");
    driver.findElement(By.id(":o2")).click();
    driver.findElement(By.id(":mz")).clear();
    driver.findElement(By.id(":mz")).sendKeys("Good Morning");
    driver.findElement(By.id(":o2")).click();
    driver.findElement(By.id(":mp")).click();
    driver.findElement(By.xpath("//div[@id='gb']/div/div/div[2]/div[4]/div/a/span")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='gb']/div/div/div[2]/div[4]/div[2]/div[3]/div[2]/a")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
