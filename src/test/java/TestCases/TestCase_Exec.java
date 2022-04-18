package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;
import POM.AtLoginPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase_Exec extends ClsWebElements {
	@Rule
	public TestName TC_Name = new TestName();
	public String URL;

	@BeforeClass
	public static void beforeClass() {
		ClsReport.fnSetupReport();
	}

	@Before
	public void setup() {
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	}

	@Test
	public void FirstTC() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step - Wai for load page ", false);
			AtLoginPage objLogin = new AtLoginPage();
			ClsReport.fnLog(Status.PASS, "Step - Wait load page", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter credentials", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Start the first session", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step - Keep session", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step - Verify that session is active", true);
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName()
					+ " was not executed successfully. \n Exception: " + e.getMessage(), false);
		}
	}

	
	@Test
	public void SecondTest() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("Second Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, " Step - Go to the url in the Second Test", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, " Step -Wai for load page in the Second Test", false);
			AtLoginPage objLogin = new AtLoginPage();
			ClsReport.fnLog(Status.PASS, " Step - Wait load page", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, " Step - Enter credentials in the Second Test", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Start the first session  in the Second Test", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step -Keep session  in the Second Test", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step -Verify that session is active  in Second Test", true);
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName()
					+ " was not executed successfully. \n Exception: " + e.getMessage(), false);
		}
	}

	
	@Test
	public void Thirdest() {
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("Third Test");
			URL = "https://positionsapp-uat.azurewebsites.net/#";
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to the url in the Three Test", false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, "Step - Wai for load page in the Three Test", false);
			AtLoginPage objLogin = new AtLoginPage();
			ClsReport.fnLog(Status.PASS, "Step - Wait load page in the Three Test", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter credentials in the Three Test", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Start the first session  in Three Test", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step - Keep session  in the Three Test", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step - Verify that session is active  in the Three Test", true);
		} catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName()
					+ " was not executed successfully. \n Exception: " + e.getMessage(), false);
		}
	}

	// Delete the other tearDown because you can't repeat method

	@After
	public void tearDown() {
		CloseBrowser();
		ClsReport.fnCloseReport();
	}

}
