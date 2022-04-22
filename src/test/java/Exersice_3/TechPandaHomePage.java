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
		try {
			WaitForLoad();
			WaitForElementClickable(btnAddToCarProductLG);
			Click(btnAddToCarProductLG);
		} catch (Exception e) {
			System.out.print("GG");
		}
	}

	public void addToCarTvSamsung() {
		try {
			WaitForLoad();
			WaitForElementClickable(btnAddToCarProductTvSamsung);
			Click(btnAddToCarProductTvSamsung);
		} catch (Exception e) {
			System.out.print("GG");
		}
	}
	


	public void goToCreateAcountPage() throws InterruptedException {
		try {
			WaitForLoad();
			WaitForElementClickable(aAcount);
			Click(aAcount);
			Thread.sleep(2000);// Wait 3 seconds
			WaitForElementClickable(aResgiter);
			Click(aResgiter);
		} catch (Exception e) {
			System.out.print("GG");
		}
	}

}
