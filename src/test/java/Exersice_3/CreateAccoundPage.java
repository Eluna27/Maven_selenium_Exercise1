package Exersice_3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class CreateAccoundPage extends ClsWebElements {

	/**
	 * Locators
	 */

	String inputFirtsName = "//input[@id='firstname']";
	String inputLastNameText = "//input[@id='lastname']";
	String inputEmailText = "//input[@id='email_address']";
	String inputPassword = "//input[@id='password']";
	String pHello = "//p[@class ='hello']";
	String inputConfirmPassword = "//input[@id='confirmation']";
	By inputCheckBox = By.xpath("//input[@id='is_subscribed']");
	By btnRegister = By.xpath("//button[@title='Register']");

	// Variables
	String firtsNameText = "Eduardo";
	String LastNameText = "Luna";
	String emailText = "EduLunaHRZ@gmail.com";
	String passwordText = "test123";

	/**
	 * Methods
	 */

	public void createAccount() {
		WaitForLoad();
		SendKeys(inputFirtsName, firtsNameText);
		SendKeys(inputLastNameText, LastNameText);
		SendKeys(inputEmailText, emailText);
		SendKeys(inputPassword, passwordText);
		SendKeys(inputConfirmPassword, passwordText);
		Click(inputCheckBox);
		Click(btnRegister);

	}

	public void validadAccountCreate() {
		WaitForLoad();
		WaitForElement(pHello);
		WebElement objGreetings = GetWebElement(pHello);
		String currentGreetings = objGreetings.getAttribute("innerText");
		Assert.assertEquals("Hello, Eduardo Luna!", currentGreetings);
		System.out.print("Greetings");

	}

}
