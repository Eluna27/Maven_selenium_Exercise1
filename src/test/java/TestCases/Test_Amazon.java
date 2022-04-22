package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import exercise2.AmazonLoginPage;
import exercise2.PromotionsPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

/**
 * 
 * @author Eduardo
 *
 */
public class Test_Amazon extends ClsWebElements {

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
	public void AmazonTest() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("Amazon Test");
			URL = "https://www.amazon.com.mx/";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step - Wai for load page ", false);
			// Object login
			AmazonLoginPage objLogin = new AmazonLoginPage();
			objLogin.goToLoginScreen();
			ClsReport.fnLog(Status.PASS, "Step - Page load", false);
			objLogin.enterEmailCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter credentials", false);
			objLogin.enterPasswordCredential();
			ClsReport.fnLog(Status.PASS, "Step - Start the first session", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step - Verify that session is active ", true);
			objLogin.verifyActiveSession();
			WaitForLoad();
			// Object promotions
			PromotionsPage objPromotions = new PromotionsPage();
			ClsReport.fnLog(Status.PASS, " Step - Got to the offers page ", false);
			objPromotions.goToOffers();
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, " Step - Get item list ", true);
			objPromotions.getListItems();
			ClsReport.fnLog(Status.INFO, " Step - Test complete", false);
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
