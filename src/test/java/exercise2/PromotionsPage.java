package exercise2;

import com.aventstack.extentreports.Status;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.ClsReport;
import selenium.ClsWebElements;
/**
 * 
 * @author Eduardo
 *
 */
public class PromotionsPage extends ClsWebElements {

	/**
	 * LOCATORS
	 */
	By promotionLinkText = By.linkText("Promociones");
	By lightningDealsSpan = By.xpath("//span[text() = 'Oferta relámpago']");
	By divContainOferts = By.xpath("//div[@class = 'DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']");
	By IndexNumberPage = By.xpath("//li[@class = 'a-disabled'][3]");
	By NextBtn = By.xpath("//li[@class = 'a-last']");

	/**
	 * VARIABLES
	 */
	
	int count = 0;
	
	/**
	 * METHODS
	 */
	
	/**
	 * Method that go to the promotion page and go to the section of lightning Deals
	 * @throws InterruptedException
	 */
	public void goToOffers() throws InterruptedException {
		WaitForLoad(); //Wait for load page
		WaitForElementClickable(promotionLinkText); //Wait the element promotion link
		Click(promotionLinkText); // Click in the element
		WaitForLoad(); //Wait for the page load
		Scroll(lightningDealsSpan ); // scrolls to the section that lightning Deals 
		WaitForElementClickable(lightningDealsSpan ); // Wait for the web element
		Click(lightningDealsSpan); // Click in the section
	}
	
	/**
	 * Method that get the name of all items in the pages, in the section of  lightning Deals
	 * @throws InterruptedException
	 */

	public void getListItems() throws InterruptedException {
		Scroll(IndexNumberPage); //Scrolls to the page number you are on
		Thread.sleep(3000);//Wait 3 seconds
		WebElement objText = GetWebElement(IndexNumberPage); //create object of element
		String NumberText = objText.getAttribute("innerText"); // get this object and get the text of web element
		int index = Integer.parseInt(NumberText);// convert web element format to number
		for (int i = 0; i < index; i++) { //uses the web element for our loop and is used to count how many times it will loop
			Thread.sleep(3000); //Wait 3 second 
			List<WebElement> myElements = GetWebList(divContainOferts); // find all items within our locator to create the list
			for (WebElement e : myElements) { // create a list with the found elements
				count++; //this is only a variable, uses for count the item number
				ClsReport.fnLog(Status.INFO, "No. " + count + " "+ "Product Name: " + e.getAttribute("innerText"), false);//Create the report for any item
			}
			if (i == index - 1) { //if the index is negative the report show that the page is the last page
				ClsReport.fnLog(Status.INFO, " In the last page ", false);
				ClsReport.fnLog(Status.PASS, " The last page is load correctly ", true);
			} else { // continue the loop
				Scroll(NextBtn); //Scrolls to the button next
				WaitForElementClickable(NextBtn ); // Wait for the web element
				Click(NextBtn); // Click in the button
			}

		}

	}
}
