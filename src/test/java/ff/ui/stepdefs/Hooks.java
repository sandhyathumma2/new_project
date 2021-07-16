package ff.ui.stepdefs;

import java.net.MalformedURLException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import Nunc.Core.Libraries.BrowserTypes;
import Nunc.Core.Libraries.Driver;
import Nunc.Reports.ExtentReportUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ff.ui.pages.LoginPage;
import ff.ui.pages.LoginPageValidator;


//public class Hooks extends ITestListernerImpl{
public class Hooks{
//	private BaseUtil baseUtil= new BaseUtil();
//	 private static ExtentReports extent = ExtentReportUtil.CreateInstance();
//	public ThreadLocal<ExtentTest> extentreortTest =new ThreadLocal<ExtentTest>();
   // ExtentReportUtil extentReportUtil =new ExtentReportUtil();
   // public Hooks(BaseUtil base)
   // {
	//	this.setBase(base);
	//}
	public LoginPageValidator loginpage;
	@Before
	public void BeforeScenario(Scenario scenario) throws ClassNotFoundException, MalformedURLException
	{	
		//Driver.StartBrowser(BrowserTypes.Chrome, 15);			
		System.out.println("Before scenario "+scenario.getName());	
		ExtentReportUtil.CreateInstance().setextentscenario(scenario.getName());
	}
	
	@After
	public void AfterScenario()
	{
		System.out.println("After scenario ");	
		//Driver.StopBrowser();
//	ExtentReportUtil.CreateInstance().FlushReport();
	}
	
	
}

