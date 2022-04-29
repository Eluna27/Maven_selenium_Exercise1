package Exercise_4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsReport;
import selenium.ClsWebElements;

public class VolarisFlightPage extends ClsWebElements {

	/**
	 * Locators
	 */

	String selectFligthRecomended = "//select[contains(@id, 'mat-input-10')]";
	String optionPriceLowToHigh = "//option[contains(@value, 'PriceLowToHigh')]";
	String priceExitFligth = "(//a[@class='panel-open ng-star-inserted'])[1]";
	String btnSelectBasic = "//div[@class = 'fareTypes fareTypeRegular']//following-sibling::mat-card[@class = 'basic mat-card ng-star-inserted']";
	String priceReturnFligth = "(//a[@class='panel-open ng-star-inserted'])[1]";
	String btnSelectBasicReturn = "//div[@class = 'fareTypes fareTypeRegular']//following-sibling::mat-card[@class = 'basic mat-card ng-star-inserted']";
	By btnConfirmSelection = By.xpath("//button[@class = 'btn btn-large mat-flat-button mat-button-base mat-primary']");
	String divFlightlists = "//div[@id='Flightlists']";
	By inputPayFee = By.xpath("//input[@id='mat-checkbox-1-input']");
	String divPayFee = "//div[@class='mat-checkbox-inner-container']";
	String totalPrice = "//div[@class = 'item GrandTotal grand-total-pulse-animation']//following-sibling::div[not(contains(@class, 'grand-total-price-msg')) and not(contains(@class, 'clearfix'))]";

	/**
	 * Variables
	 */

	int budget = 1500;

	/**
	 * Methods
	 */

	public void verifyFigthListExist() {
		List<WebElement> myElements = GetWebList(divFlightlists); // find all items within our locator to create the
																	// list
		if (myElements.isEmpty()) {
			ClsReport.fnLog(Status.FAIL, "You don't have enough budget", true);
		} else {
			ClsReport.fnLog(Status.PASS, "You have a fligths", false);
		}
	}

	public void selectExitFlight() throws InterruptedException {
		WaitForLoad();
		filterFligth();
		WaitForElement(priceExitFligth);
		Click(priceExitFligth);
		Thread.sleep(1000);
		WaitForElement(btnSelectBasic);
		Click(btnSelectBasic);

	}

	public void selectReturnFlight() throws InterruptedException {
		WaitForLoad();
		Thread.sleep(1000);
		WaitForElement(priceReturnFligth);
		Click(priceReturnFligth);
		WaitForElement(btnSelectBasicReturn);
		Click(btnSelectBasicReturn);
	}

	public void addExtraBaggageConfirm() {
		WaitForLoad();
		WaitForElementClickable(btnConfirmSelection);
		Click(btnConfirmSelection);
	}

	public void addAirportFee() {
		WaitForLoad();
		Scroll(inputPayFee);
		WaitForElementClickable(divPayFee);
		Click(divPayFee);
	}

	public void verifyBudget() {
		WaitForLoad();
		WaitForElement(totalPrice);
		WebElement objTotalPrice = GetWebElement(totalPrice);
		String cantTotalPrice = objTotalPrice.getAttribute("innerText");
		cantTotalPrice = cantTotalPrice.replace("$", "");
		cantTotalPrice = cantTotalPrice.replace(",", "");
		cantTotalPrice = cantTotalPrice.replace(" MXN", "");
		int intCantTotalPrice = Integer.parseInt(cantTotalPrice);
		System.out.print(intCantTotalPrice);
		if (intCantTotalPrice <= budget) {
			ClsReport.fnLog(Status.PASS, "You have budget", false);
		} else {
			ClsReport.fnLog(Status.FAIL, "You don't have enough budget", true);
		}
	}

	private void filterFligth() {
		WaitForLoad();
		WaitForElement(selectFligthRecomended);
		Click(selectFligthRecomended);
		WaitForElement(optionPriceLowToHigh);
		Click(optionPriceLowToHigh);
	}

}
