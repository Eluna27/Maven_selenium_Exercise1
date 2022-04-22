package Exersice_3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class ShoppingCartPage extends ClsWebElements {

	/**
	 * LOCATORS
	 */
	String product = "//h2[@class = 'product-name']";
	String tittle = "//h1";
	By btnProccedCheckOut = By.xpath("//button[@class ='button btn-proceed-checkout btn-checkout']");
	

	/**
	 * METHODS
	 */

	public void verifyCartSection() {
		WaitForLoad();// Wait for load page
		WaitForElement(tittle); // Wait that the element is loaded
		WebElement objTittle = GetWebElement(tittle); // call the method getWebElement and found the web element
		String currentTitle = objTittle.getAttribute("innerText"); // Get text of the web element
		try {
			Assert.assertEquals("SHOPPING CART", currentTitle); // Compare the text with the text in the web element
			System.out.println(currentTitle); // show the text in the console
		} catch (Exception e) {
			System.out.println("The page no found"); // If not found the element show the message in the console
		}
	}

	public void verifyTvOnCart() {
		WaitForLoad();// Wait for load page
		WaitForElement(product); // Wait that the element is loaded
		WebElement objSpan = GetWebElement(product); // call the method getWebElement and found the web element
		String currentTitle = objSpan.getAttribute("innerText"); // Get text of the web element
		try {
			Assert.assertEquals("LG LCD", currentTitle); // Compare the text with the text in the web element
			System.out.println(currentTitle); // show the text in the console
		} catch (Exception e) {
			System.out.println("Element Not found"); // If not found the element show the message in the console
		}
	}
	
	public void proceedToCheckout() {
		WaitForLoad();
		WaitForElementClickable(btnProccedCheckOut);
		Click(btnProccedCheckOut);
	}
	
	
	
	

}
