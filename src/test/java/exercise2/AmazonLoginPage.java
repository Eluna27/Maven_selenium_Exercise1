package exercise2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

/**
 * 
 * @author Eduardo
 *
 */
public class AmazonLoginPage extends ClsWebElements {

	/**
	 * LOCATORS
	 */

	String email = "eluna3@ucol.mx";
	String password = "98supralalo";

	By aIdentify = By.xpath("//a[@id='nav-link-accountList']");
	By inputUserEmail = By.xpath("//input[@id='ap_email']");
	By inputBtnContinue = By.xpath("//input[@id='continue']");
	By inputUserPassword = By.xpath("//input[@id='ap_password']");
	By inputBtnSignInSubmit = By.xpath("//input[@id='signInSubmit']");
	String spanGreetings = "//span[@id='nav-link-accountList-nav-line-1']";

	/**
	 * METHODS
	 */

	/**
	 * Method that that clicks on the identify option on the amazon home page 
	 */
	public void goToLoginScreen() {
		WaitForLoad(); //Wait for load page
		WaitForElementClickable(aIdentify); //Wait that element is clickeable
		Click(aIdentify); //Click in the element
	}
	
	/**
	 * Method that put the email in the login page
	 */
	public void enterEmailCredential() {
		WaitForLoad(); //Wait for load page
		SendKeys(inputUserEmail, email); //Type the email in element
		WaitForElementClickable(inputBtnContinue); //Wait that the button is clickeable
		Click(inputBtnContinue);//Click in the button
	}
	
	/**
	 * Method that put the password in the login page
	 */

	public void enterPasswordCredential() {
		WaitForLoad(); //Wait for load page
		SendKeys(inputUserPassword, password); //Type the password in input 
		WaitForElementClickable(inputBtnSignInSubmit);//Wait that the button is clickeable
		Click(inputBtnSignInSubmit);//Click in the button
	}

	/**
	 * Method that validate that the login was complete 
	 */
	public void verifyActiveSession() {
		WaitForLoad();//Wait for load page
		WaitForElement(spanGreetings); //Wait that the element is loaded
		WebElement objSpan = GetWebElement(spanGreetings); //call the method getWebElement and found the web element
		String currentTitle = objSpan.getAttribute("innerText"); //Get text of the web element
		try {
			Assert.assertEquals("Hola Eduardo", currentTitle); // Compare the text with the text in the web element
			System.out.println(currentTitle); //show the text in the console
		} catch (Exception e) {
			System.out.println("Element Not found"); // If not found the element show the message in the console
		}

	}
	
	

}
