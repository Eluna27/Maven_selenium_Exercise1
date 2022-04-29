package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import com.aventstack.extentreports.Status;

import Exercise_4.VolarisFlightPage;
import Exercise_4.VolarisHomePage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase_Exercise_4 extends ClsWebElements {
	@Rule
	public TestName TC_Name = new TestName();
	public String URL;
	// Create ObjVolarisHomePage
	VolarisHomePage objVolarisHome = new VolarisHomePage();
	// Create ObjVolarisFligthPage
	VolarisFlightPage objVolarisFligth = new VolarisFlightPage();

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

	public void volarisTest() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("volarisTest");
			URL = "https://www.volaris.com/";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url", false);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, " Step - select for origin fligth ", false);
			objVolarisHome.selecOriginFligth();
			ClsReport.fnLog(Status.PASS, " Step - Select for return fligth", false);
			objVolarisHome.selectDestinationFligth();
			ClsReport.fnLog(Status.PASS, " Step - Select date 10/29/2022 ", false);
			objVolarisHome.selectDate();
			ClsReport.fnLog(Status.PASS, " Step - Select date 11/04/2022  ", false);
			objVolarisHome.searchFligth();
			ClsReport.fnLog(Status.PASS, " Step - Search fligth ", false);
			objVolarisFligth.verifyFigthListExist();
			ClsReport.fnLog(Status.PASS, " Step - Verify that figth exist ", false);
			objVolarisFligth.selectExitFlight();
			ClsReport.fnLog(Status.PASS, " Step - Select exist fligth ", false);
			objVolarisFligth.selectReturnFlight();
			ClsReport.fnLog(Status.PASS, " Step - Select return fligth ", false);
			objVolarisFligth.addExtraBaggageConfirm();
			ClsReport.fnLog(Status.PASS, " Step - Confirm extra baggage ", false);
			objVolarisFligth.addAirportFee();
			ClsReport.fnLog(Status.PASS, " Step - Add IVA to airport ", false);
			objVolarisFligth.verifyBudget();
			ClsReport.fnLog(Status.INFO, " test complete ", false);

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
