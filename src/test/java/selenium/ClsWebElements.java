package selenium;

//Delete a import that i?m not use
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.Status;

public class ClsWebElements extends ClsBrowser {

	/**
	 * Constants
	 */
	private int DefaultTimeout = 10;
	public static Wait<WebDriver> objFluentWait;
	public static WebDriverWait objExplicitWait;
	public static String strAction = "";

	/**
	 * @param by
	 * @return
	 */

	public WebElement GetWebElement(By by) {
		try {
			//ClsReport.fnLog(Status.INFO, "Step - Get Web Element: " + by.toString(), false);
			WebElement pobjElement = ClsBrowser.objDriver.findElement(by);
			//ClsReport.fnLog(Status.PASS, "Step - The Web Element: " + by.toString() + " was found as expected.", false);
			return pobjElement;
		} catch (NoSuchElementException pobjException) {
			/*ClsReport.fnLog(Status.FAIL, "Step - The Web Element: " + by.toString()
				+ " was not found as expected. Exception: " + pobjException.getStackTrace(), true);*/
			return null;
		}
	}

	/**
	 * @param pstrLocator
	 * @return
	 */

	public WebElement GetWebElement(String pstrLocator) {
		return GetWebElement(By.xpath(pstrLocator));
	}

	/**
	 * @param by
	 * @return
	 */

	public List<WebElement> GetWebList(By by) {
		try {
			List<WebElement> pobjElement = ClsBrowser.objDriver.findElements(by);
			return pobjElement;
		} catch (Exception pobjException) {
			System.out.println("The element was (" + by.toString() + ") not located in the page");
			return null;
		}
	}

	/**
	 * @param pstrLocator
	 * @return
	 */

	public List<WebElement> GetWebList(String pstrLocator) {
		return GetWebList(By.xpath(pstrLocator));
	}

	/**
	 * @param pstrLocator
	 * @return
	 */

	public Object GetFluentWait(final String pstrLocator) {
		return GetFluentWait(By.xpath(pstrLocator));
	}

	/**
	 * @param by
	 * @return
	 */

	public Object GetFluentWait(final By by) {
		try {
			// Waiting 30 seconds for an element to be present on the page, checking
			// for its presence once every 5 seconds.
			objFluentWait = new FluentWait<WebDriver>(ClsBrowser.objDriver).withTimeout(Duration.ofSeconds(30L))
					.pollingEvery(Duration.ofSeconds(3L)).ignoring(NoSuchElementException.class);

			// Get Web Element and perform action
			WebElement objElement = objFluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});

			return objElement;
		} catch (Exception e) {
			System.out.println("The element was (" + by.toString() + ") not located in the page");
			return null;
		}
	}

	/**
	 * @param by
	 * @return
	 */

	public boolean Click(final By by) {
		try {
			WebElement objElement = (WebElement) GetFluentWait(by);
			objExplicitWait = new WebDriverWait(ClsBrowser.objDriver, DefaultTimeout);
			objExplicitWait.until(ExpectedConditions.elementToBeClickable(by));
			objElement.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param pstrLocator
	 * @return
	 */

	public boolean Click(final String pstrLocator) {
		return Click(By.xpath(pstrLocator));
	}

	/**
	 * @param by
	 * @param pValue
	 * @return
	 */

	public boolean SendKeys(final By by, String pValue) {
		try {
			WebElement objElement = (WebElement) GetFluentWait(by);
			objExplicitWait = new WebDriverWait(ClsBrowser.objDriver, DefaultTimeout);
			objExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			objElement.clear();
			objElement.sendKeys(pValue);
			return true;
		} catch (Exception e) {
			return false;
		}

		// return null; In this case this return is invalid because is outside in the
		// function
	}

	/**
	 * @param pstrLocator
	 * @param pValue
	 * @return
	 */

	public boolean SendKeys(final String pstrLocator, String pValue) {
		return SendKeys(By.xpath(pstrLocator), pValue);
	}

	/**
	 * @param by
	 * @param pMethod
	 * @param pValue
	 * @return
	 */

	public boolean SelectItem(final By by, String pMethod, String pValue) {
		try {
			WebElement objElement = (WebElement) GetFluentWait(by);
			objExplicitWait = new WebDriverWait(ClsBrowser.objDriver, 10);
			objExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Select selectObject = new Select(objElement);

			switch (pMethod.toUpperCase()) {
			case "BYVALUE":
				selectObject.selectByValue(pValue);
				break;
			case "BYINDEX":
				selectObject.selectByIndex(Integer.parseInt(pValue));
				break;
			case "BYTEXT":
				selectObject.selectByVisibleText(pValue);
				break;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param pstrLocator
	 * @param pMethod
	 * @param pValue
	 * @return
	 */

	public boolean SelectItem(final String pstrLocator, String pMethod, String pValue) {
		return SelectItem(By.xpath(pstrLocator), pMethod, pValue);
	}

	/**
	 * @param pstrLocator
	 */

	public void WaitForElement(final String pstrLocator) {
		objExplicitWait = new WebDriverWait(ClsBrowser.objDriver, 10);
		objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pstrLocator)));
	}

	/**
	 * @param by
	 */

	public void WaitForElementClickable(final By by) {
		objExplicitWait = new WebDriverWait(ClsBrowser.objDriver, 10);
		objExplicitWait.until(ExpectedConditions.presenceOfElementLocated(by));
		objExplicitWait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * @param pstrLocator
	 */

	public void WaitForElementClickable(final String pstrLocator) {
		WaitForElementClickable(By.xpath(pstrLocator));
	}

	public void WaitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(ClsBrowser.objDriver, 30);
		wait.until(pageLoadCondition);
	}

	/**
	 * @param pstrLocator
	 */

	public void LinkText(final String pstrLocator) {
		WebElement objElement = ClsBrowser.objDriver.findElement(By.linkText(pstrLocator));
		objElement.click();

	}

	public void AcceptAlert() {
		WebDriverWait wait = new WebDriverWait(ClsBrowser.objDriver, 3000);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = ClsBrowser.objDriver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @return
	 */

	public String GetAlertText() {
		WebDriverWait wait = new WebDriverWait(ClsBrowser.objDriver, 3000);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = ClsBrowser.objDriver.switchTo().alert(); // In this case a use the variable alert because isn't
																// use
		String alertMessage = alert.getText(); // Here is were you don?t use the alert and repeat the code
		return alertMessage;
	}

}
