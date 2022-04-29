package Exercise_4;

import selenium.ClsWebElements;

public class VolarisHomePage extends ClsWebElements {

	/**
	 * LOCATORS
	 */

	String btnRoundTrip = "//button[contains(@id, 'mat-button-toggle-1-button')]";
	String btnSearch = "//a[contains(@class, 'btnSearch radius-6')]";
	String inputOrigenFligthName = "//input[contains(@id, 'fnameOrigin')]";
	String inputDestinationFligthName = "//input[contains(@id, 'fnameDestination')]";
	String divGuadalajara = "//div[contains(text(), 'Guadalajara')]";
	String divCancun = "//div[contains(text(), 'Cancún')]";
	String selectDateOrigin = "//div[@class = 'dropdowns ng-star-inserted' and text() = ' abril ' ]";
	String optionOct = "//option[contains(@value, '9')]";
	String selectDateReturn = "//div[@class = 'dropdowns ng-star-inserted' and text() = ' noviembre ' ]";
	String optionNov = "//option[contains(@value, '11')]";
	String btnDone = "//button[contains(@class, 'btn-calendar d-none d-md-block mat-flat-button mat-button-base mat-secondary')]";
	String btnSearchTrips = "//button[contains(@class, 'btn btn-large col-12 search-btn mat-flat-button mat-button-base mat-primary')]";
	String tdDateOct = "//td[contains(@class, 'weekend datecell-20221029 customfare available')]";
	String tdDateNov = "//td[@class = 'datecell-20221104 returnVisible returnCustomfare available']";
	/**
	 * VARIABLES
	 */

	String textOrigenFligthName = "Guadalajara";
	String textDestinationName = "Cancún";

	/**
	 * METHODS
	 */

	public void selecOriginFligth() throws InterruptedException {
		WaitForLoad();
		WaitForElement(btnRoundTrip);
		Click(btnRoundTrip);
		WaitForElement(btnSearch);
		Click(btnSearch);
		Thread.sleep(3000);
		WaitForElement(inputOrigenFligthName);
		SendKeys(inputOrigenFligthName, textOrigenFligthName);
		WaitForElement(divGuadalajara);
		Click(divGuadalajara);
	}

	public void selectDestinationFligth() {
		WaitForElement(inputDestinationFligthName);
		SendKeys(inputDestinationFligthName, textDestinationName);
		WaitForElement(divCancun);
		Click(divCancun);
	}

	public void selectDate() {
		WaitForElement(selectDateOrigin);
		Click(selectDateOrigin);
		WaitForElement(optionOct);
		Click(optionOct);
		WaitForElement(tdDateOct);
		Click(tdDateOct);
		WaitForElement(tdDateNov);
		Click(tdDateNov);
		WaitForElement(btnDone);
		Click(btnDone);
	}

	public void searchFligth() {
		WaitForElement(btnSearchTrips);
		Click(btnSearchTrips);
	}

}
