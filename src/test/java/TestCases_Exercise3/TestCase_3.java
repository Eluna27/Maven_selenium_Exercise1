package TestCases_Exercise3;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import com.aventstack.extentreports.Status;

import Exersice_3.CreateAccoundPage;
import Exersice_3.TechPandaHomePage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase_3 extends ClsWebElements {

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

	public void createAccount() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("create Account");
			URL = "http://live.techpanda.org/index.php/tv.html";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step - Wai for load page ", false);
			// Create object home
			TechPandaHomePage objHomePage = new TechPandaHomePage();
			ClsReport.fnLog(Status.PASS, "Step - Wait load page", false);
			objHomePage.goToCreateAcountPage();
			// Create Object CreateAccount
			CreateAccoundPage objCAP = new CreateAccoundPage();
			ClsReport.fnLog(Status.PASS, "Step - add credentials", false);
			objCAP.createAccount();
			ClsReport.fnLog(Status.INFO, "Step - Acount created", true);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Step - Validate account", true);
			objCAP.validadAccountCreate();
			ClsReport.fnLog(Status.INFO, "Step - Account registered", false);

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
