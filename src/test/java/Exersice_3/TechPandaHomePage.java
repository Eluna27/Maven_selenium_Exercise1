package Exersice_3;

import org.openqa.selenium.By;

import selenium.ClsWebElements;

public class TechPandaHomePage extends ClsWebElements {

	/**
	 * LOCATORS
	 */
	By btnAddToCarProductLG = By.xpath("//button[contains(@onclick, 'product/4')]");
	By btnAddToCarProductTvSamsung = By.xpath("//button[contains(@onclick, 'product/5')]");
	String h2Product = "//h2[@class ='product-name']";
	By aAcount = By.xpath("//a[@class = 'skip-link skip-account']");
	By aResgiter = By.xpath("//a[@title = 'Register']");

	/**
	 * METHODS
	 */

	public void addToCarTVLG() {
		
			WaitForLoad();
			WaitForElementClickable(btnAddToCarProductLG);
			Click(btnAddToCarProductLG);
	}

	public void addToCarTvSamsung() {
		
			WaitForLoad();
			WaitForElementClickable(btnAddToCarProductTvSamsung);
			Click(btnAddToCarProductTvSamsung);
	}

	public void goToCreateAcountPage() throws InterruptedException {
		
			WaitForLoad();
			WaitForElementClickable(aAcount);
			Click(aAcount);
			Thread.sleep(2000);// Wait 3 seconds
			WaitForElementClickable(aResgiter);
			Click(aResgiter);
	}

}
