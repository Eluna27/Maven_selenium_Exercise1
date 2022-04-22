package Exersice_3;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class CheckoutPage extends ClsWebElements {

	/**
	 * Locator
	 */

	String inputFirstName = "//input[@id ='billing:firstname']";
	String inputLastname = "//input[@id ='billing:lastname']";
	String inputEmail = "//input[@id ='billing:email']";
	String inputStreet = "//input[@id ='billing:street1']";
	String inputCity = "//input[@id ='billing:city']";
	String inputZip = "//input[@id ='billing:postcode']";
	String inputTNumber = "//input[@id ='billing:telephone']";
	String selectRegion = "//select[@id ='billing:region_id']";
	String optionRegion = "//option[text() = 'Arizona']";
	String btnContinueSetMethod = "//button[contains(@onclick, 'checkout.setMethod()')]";
	String btnContinuesBuillingSave = "//button[contains(@onclick, 'billing.save()')]";
	String btnContinueShippingMethod = "//button[contains(@onclick, 'shippingMethod.save()')]";
	String inputCheckMoneyOder = "//input[@id ='p_method_checkmo']";
	String btnContinuePaymentSave = "//button[contains(@onclick, 'payment.save()')]";
	String btnPlaceOrder = "//button[contains(@onclick, 'review.save();')]";
	String h1OrderReceived = "//h1[text() = 'Your order has been received.']";
	String h3ProductName = "//h3[@class = 'product-name']";

	/**
	 * 
	 * Variables
	 */

	String textFirstName = "Eduardo";
	String textLastname = "Luna";
	String textEmail = "elunaQA@ola.com";
	String textStreet = "Benito";
	String textCity = "Colima";
	String textFZip = "25589";
	String textTNumber = "1234567890";

	public void Checkout() {
		WaitForLoad();
		WaitForElementClickable(btnContinueSetMethod);
		Click(btnContinueSetMethod);

	}

	public void billingInformation() {
		WaitForElement(inputFirstName);
		SendKeys(inputFirstName, textFirstName);
		WaitForElement(inputLastname);
		SendKeys(inputLastname, textLastname);
		WaitForElement(inputEmail);
		SendKeys(inputEmail, textEmail);
		WaitForElement(inputStreet);
		SendKeys(inputStreet, textStreet);
		WaitForElement(inputCity);
		SendKeys(inputCity, textCity);
		WaitForElement(selectRegion);
		Click(selectRegion);
		WaitForElement(optionRegion);
		Click(optionRegion);
		WaitForElement(inputZip);
		SendKeys(inputZip, textFZip);
		WaitForElement(inputTNumber);
		SendKeys(inputTNumber, textTNumber);
		WaitForElementClickable(btnContinuesBuillingSave);
		Click(btnContinuesBuillingSave);
	}

	public void shipping() {
		WaitForElementClickable(btnContinueShippingMethod);
		Click(btnContinueShippingMethod);
	}

	public void paymentInformation() {
		WaitForElement(inputCheckMoneyOder);
		Click(inputCheckMoneyOder);
		WaitForElementClickable(btnContinuePaymentSave);
		Click(btnContinuePaymentSave);
	}

	public void orderReview() {
		verifyProductName();
		WaitForElementClickable(btnPlaceOrder);
		Click(btnPlaceOrder);
	}

	private void verifyProductName() {
		try {
			WaitForLoad();
			WaitForElement(h3ProductName);
			WebElement objproductName = GetWebElement(h3ProductName);
			String currentGreetings = objproductName.getAttribute("innerText");
			Assert.assertEquals("SAMSUNG LCD", currentGreetings);
			System.out.print("The product is correct");
		} catch (Exception e) {
			System.out.print(false);
		}

	}
	
	public void verifyOrderReceived() {
		try {
			WaitForLoad();
			WaitForElement(h1OrderReceived);
			WebElement objOrderReceived = GetWebElement(h1OrderReceived);
			String currentGreetings = objOrderReceived.getAttribute("innerText");
			Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", currentGreetings);
			System.out.print("order complete");
		} catch (Exception e) {
			System.out.print(false);
		}
	}
}
