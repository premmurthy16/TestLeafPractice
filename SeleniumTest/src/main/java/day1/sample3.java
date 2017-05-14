package day1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class sample3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	  driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
    driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("premkumar.m@ind");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("premkumar.m@indiaproperty.com");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("Elshaddaij16");
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.cssSelector("a.gb_b.gb_5b")).click();
    driver.findElement(By.cssSelector("#gb283 > span.gb_3")).click();
    driver.findElement(By.cssSelector("div.docs-homescreen-search-item-view-title")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("staging");
    driver.findElement(By.xpath("//div[@id=':5y']/div/span")).click();
    driver.findElement(By.id(":17.to")).clear();
    driver.findElement(By.id(":17.to")).sendKeys("pre");
    driver.findElement(By.id(":2g")).click();
    driver.findElement(By.id(":e.message")).clear();
    driver.findElement(By.id(":e.message")).sendKeys("test");
  }

  @After
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
