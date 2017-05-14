package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author LOKESH KUMAR T
 *
 */
public class GenericWrappers implements Wrappers {
	WebDriverWait wait;
	// Declare Driver Class
	RemoteWebDriver driver;
	int i = 1;

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param browser
	 * @param Url
	 */
	public void invokeApp(String browser, String Url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Url);
			wait = new WebDriverWait(driver, 30);
			System.out.println("The browser " + browser + " is launched with URL " + Url);
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in invokeApp() " + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param idValue
	 * @param data
	 */
	public void enterById(String idValue, String data) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idValue))).sendKeys(data);
			System.out.println("The value " + data + " is entered at element " + idValue);
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + idValue + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in entering value" + data
					+ " into element with id value : " + idValue + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param nameValue
	 * @param data
	 */
	public void enterByName(String nameValue, String data) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nameValue))).sendKeys(data);
			System.out.println("The value " + data + " is entered at element " + nameValue);
		} catch (TimeoutException e) {
			System.err.println("The element with name :" + nameValue + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in entering value" + data
					+ " into element with Name value : " + nameValue + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param xpathValue
	 * @param data
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).sendKeys(data);
			System.out.println("The value " + data + " is entered at element " + xpathValue);
		} catch (TimeoutException e) {
			System.err.println("The element with xpath value :" + xpathValue + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in entering value" + data + " into element with Xpath : "
					+ xpathValue + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");

		} finally {
			takeSnap();
		}

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param title
	 * @return
	 */
	public boolean verifyTitle(String title) {
		try {
			// wait = new WebDriverWait(driver, 30);

			if (wait.until(ExpectedConditions.titleIs(title))) {
				System.out.println("Actual Title is matched with expected title");
			} else {
				System.out.println("Actual Title doesnot matches with expected title");

			}
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in verifying title with expected tilte :" + title + " \n"
					+ e.getMessage());
			throw new RuntimeException("FAILED");

		} finally {
			takeSnap();
		}
		return true;

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param id
	 * @param text
	 */
	public void verifyTextById(String id, String text) {
		try {
			// wait = new WebDriverWait(driver, 30);
			if (wait.until(ExpectedConditions.textToBe(By.id(id), text))) {
				System.out.println("Actual text is matched with expected text");
			} else {
				System.out.println("Actual text doesnot matches with expected text");
			}
		} catch (TimeoutException e) {
			System.err.println("The element with id value: " + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception occured in verifying Text " + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param xpath
	 * @param text
	 */
	public void verifyTextByXpath(String xpath, String text) {
		try {
			// wait = new WebDriverWait(driver, 30);
			if (wait.until(ExpectedConditions.textToBe(By.xpath(xpath), text))) {
				System.out.println("Actual text is matched with expected text");
			} else {
				System.out.println("Actual text doesnot matches with expected text");
			}
		} catch (TimeoutException e) {
			System.err.println("The element with xpath value : " + xpath + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println(
					"unexpected exception occured in verifying expected text with actual text " + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param xpath
	 * @param text
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			// wait = new WebDriverWait(driver, 30);
			if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text))) {
				System.out.println("The Actual text contains the provided text");
			} else {
				System.out.println("The Actual text doesn't contains the provided text");
			}
		} catch (TimeoutException e) {
			System.err.println("The element with xpath value :" + xpath + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println(
					"unexpected exception occured in verifying  actual text contains expected text " + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param id
	 * @param text
	 */
	public void verifyTextContainsById(String id, String text) {
		try {
			// wait = new WebDriverWait(driver, 30);
			if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(id), text))) {
				System.out.println("The Actual text contains the provided the text");
			} else {
				System.out.println("The Actual text doesn't contains the provided the text");
			}
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in verifying Text contains :" + text + " in webElement by id :"
					+ id + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param id
	 */
	public void clickById(String id) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((By.id(id)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by id :" + id + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param classVal
	 */
	public void clickByClassName(String classVal) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((By.className(classVal)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with classNmae :" + classVal + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by classname :" + classVal + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param name
	 */
	public void clickByName(String name) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((By.name(name)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with Name :" + name + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by name :" + name + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param linkText
	 */
	public void clickByLink(String linkText) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((By.linkText(linkText)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with Link :" + linkText + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by Link :" + linkText + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param xpathVal
	 */
	public void clickByXpath(String xpathVal) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with Xpath Value :" + xpathVal + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by xpath :" + xpathVal + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param idVal
	 * @return
	 */
	public String getTextById(String idVal) {
		String text = null;
		try {
			// wait = new WebDriverWait(driver, 30);
			text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idVal))).getText();
			System.out.println("Returning Actual Text " + text);
		} catch (TimeoutException e) {
			System.err.println("The element with id :" + idVal + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in geting text by locator id :" + idVal + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
		return text;

	}

	public String getTextByXpath(String xpathVal) {
		String text = null;
		try {
			// wait = new WebDriverWait(driver, 30);
			text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal))).getText();
			System.out.println("Returning Actual Text " + text);
		} catch (TimeoutException e) {
			System.err.println("The element with xpath value :" + xpathVal + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println(
					"Unexpected exception in geting text by locator xpath :" + xpathVal + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
		return text;
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param id
	 * @param value
	 */
	public void selectVisibileTextById(String id, String value) {

		try {
			// wait = new WebDriverWait(driver, 30);
			Select selectJob = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			selectJob.selectByVisibleText(value);
			System.out.println("DropDown option " + value + " is selected at element " + id);
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in selecting visible option by id:" + id + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 * @param id
	 * @param Index
	 */
	public void selectIndexById(String id, int Index) {
		try {
			// wait = new WebDriverWait(driver, 30);
			Select selectJob = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			selectJob.selectByIndex(Index);
			System.out.println("The option  at index " + Index + " is selected");
		} catch (TimeoutException e) {
			System.err.println("The element with id value :" + id + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in selecting by index by id:" + id + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}

	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 */
	public void switchToParentWindow() {
		try {
			Set<String> windowhandleSet = driver.getWindowHandles();
			System.out.println("count of opened windows :" + windowhandleSet.size());
			for (String windowhandle : windowhandleSet) {
				System.out.println("navigating windows :" + windowhandle);
				driver.switchTo().window(windowhandle);
				break;
			}
			System.out.println("control is switched to parent window");
		} catch (NoSuchWindowException e) {
			System.err.println("Exception occured while switching to parent window  " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in switching to parent window:" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 */
	public void switchToParentWindow(int totalWindowExpected) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.numberOfWindowsToBe(totalWindowExpected));
			Set<String> windowhandleSet = driver.getWindowHandles();
			System.out.println("count of opened windows :" + windowhandleSet.size());
			for (String windowhandle : windowhandleSet) {
				System.out.println("navigating windows :" + windowhandle);
				driver.switchTo().window(windowhandle);
				break;
			}
			System.out.println("control is switched to parent window");
		} catch (TimeoutException e) {
			System.err.println("Expected no of windows doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (NoSuchWindowException e) {
			System.err.println("Exception occured while switching to parent window  " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in switching to parent window:" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 */
	public void switchToLastWindow() {
		try {
			Set<String> windowhandleSet = driver.getWindowHandles();
			System.out.println("count of opened windows :" + windowhandleSet.size());
			for (String windowhandle : windowhandleSet) {
				System.out.println("navigating windows :" + windowhandle);
				driver.switchTo().window(windowhandle);
			}
			System.out.println("control is switched to last window");
		} catch (NoSuchWindowException e) {
			System.err.println("Exception occured while switching window  " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in switching to Last Window:" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	/**
	 * @author LOKESH KUMAR T
	 *
	 */
	public void switchToLastWindow(int totalWindowExpected) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.numberOfWindowsToBe(totalWindowExpected));
			Set<String> windowhandleSet = driver.getWindowHandles();
			System.out.println("count of opened windows :" + windowhandleSet.size());
			for (String windowhandle : windowhandleSet) {
				// System.out.println("navigating windows :" + windowhandle);
				driver.switchTo().window(windowhandle);
			}
			System.out.println("control is switched to last window");
		} catch (TimeoutException e) {
			System.err.println("Expected no of windows doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (NoSuchWindowException e) {
			System.err.println("Exception occured while switching window  " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in switching to Last Window:" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			System.out.println("Alert accepted ");
		} catch (TimeoutException e) {
			System.err.println("Alert is not present" + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (NoAlertPresentException e) {
			System.err.println("Exception occured in accepting alert " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in accepting alert:" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
	}

	public void takeSnap() {
		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./snaps/snap" + i + ".jpeg"));
			System.out.println("Snapshot Taken");
		} catch (IOException e) {
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

	public void clickByPartialLink(String linkText) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with partail link Text :" + linkText + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println(
					"Unexpected exception in clicking by Partial Link Text :" + linkText + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		}

		takeSnap();

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathVal)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with Xpath Value :" + xpathVal + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by xpath :" + xpathVal + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
	}

	public void clickByLinkNoSnap(String linkText) {
		try {
			// wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable((By.linkText(linkText)))).click();
			System.out.println("Element clicked successfully");
		} catch (TimeoutException e) {
			System.err.println("The element with Link :" + linkText + " doesn't exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in clicking by Link :" + linkText + "\n" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
	}

	public void dismissAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
			System.out.println("Alert dismissed");
		} catch (TimeoutException e) {
			System.err.println("Alert is not present" + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in dismissing alert:" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
	}

	public String getAlertText() {
		String text = null;
		try {
			// wait = new WebDriverWait(driver, 30);
			text = wait.until(ExpectedConditions.alertIsPresent()).getText();
			System.out.println("Returning Alert Text " + text);
		} catch (TimeoutException e) {
			System.err.println("Alert is not present" + e.getMessage());
			throw new RuntimeException("FAILED");
		}  catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in retriving text from alert:" + e.getMessage());
			throw new RuntimeException("FAILED");
		}
		return null;
	}

	public void closeBrowser() {

		try {
			driver.close();
			System.out.println("Browser closed");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in Close browser:" + e.getMessage());
			throw new RuntimeException("FAILED");
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All browsers closed");
		} catch (WebDriverException e) {
			System.err.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.err.println("Unexpected exception in Quit browser:" + e.getMessage());
			throw new RuntimeException("FAILED");
		}

	}
}
