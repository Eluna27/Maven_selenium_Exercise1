package TestCases_Exercise3;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import Exersice_3.CheckoutPage;
import Exersice_3.ShoppingCartPage;
import Exersice_3.TechPandaHomePage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase_2 extends ClsWebElements {
	@Rule
	public TestName TC_Name = new TestName();
	public String URL;

	@BeforeClass
	/**
	 * start report
	 */
	public static void beforeClass() {
		ClsReport.fnSetupReport();
	}

	// Start the Chrome driver

	@Before
	public void setup() {
		ClsBrowser.BrowserName = "Chrome"; // Send the bowser name
		OpenBrowser(); // Open the browser and start the driver
	}

	@Test

	public void Test_AddToCarLG() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("Add TV LG Test");
			URL = "http://live.techpanda.org/index.php/tv.html";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step - Wai for load page ", false);
			// Create object 
			TechPandaHomePage objTvSamsung = new TechPandaHomePage();
			ClsReport.fnLog(Status.PASS, "Step - Wait load page", false);
			objTvSamsung.addToCarTvSamsung();
			// Create object shoppingCart
			ShoppingCartPage objShCart = new ShoppingCartPage();
			objShCart.proceedToCheckout();
			// Create object checkout
			CheckoutPage objCheckout =  new CheckoutPage();
			
			objCheckout.Checkout();
			ClsReport.fnLog(Status.PASS, "Step - click on checkout", false);
			objCheckout.billingInformation();
			ClsReport.fnLog(Status.PASS, "Step - send information", false);
			objCheckout.shipping();
			ClsReport.fnLog(Status.PASS, "Step - continues shippiong", false);
			objCheckout.paymentInformation();
			ClsReport.fnLog(Status.PASS, "Step - Validate payinfomation", false);
			objCheckout.orderReview();
			ClsReport.fnLog(Status.PASS, "Step - Show the order review", false);
			objCheckout.verifyOrderReceived();
			ClsReport.fnLog(Status.PASS, "Step - show in the screen the message", false);
			ClsReport.fnLog(Status.PASS, "Test complete", true);
			
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName()
					+ " was not executed successfully. \n Exception: " + e.getMessage(), false);
		}
	}

	@After
	public void tearDown() { // Finish the test
		CloseBrowser();// Close browser
		ClsReport.fnCloseReport();// end report
	}
}
