package ff.ui.testrunner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


import Nunc.Reports.BaseUtil;
import Nunc.Reports.ExtentReportUtil;
import Nunc.Core.Libraries.BrowserTypes;
import Nunc.Core.Libraries.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
//import uiautomation.automation.utility.BrowserTypes;
//import uiautomation.automation.utility.Driver;
@Listeners(nunc.automation.listeners.ITestListernerImpl.class)

@CucumberOptions (
        features = "./features/"
        ,glue = {"ff.ui.stepdefs"}
        ,tags = {"@addnewcient,@clientinfo"}	)

public class testrunner extends AbstractTestNGCucumberTests{
	 private TestNGCucumberRunner testNGCucumberRunner;
	    //private static ExtentReportUtil extentreportUtil=new ExtentReportUtil();
	    
	  // public static ThreadLocal<ExtentTest> extentTestThread =new ThreadLocal<>();
		//private static boolean isReportRunning;
	 // private static  ExtentReports extent = ExtentReportUtil.CreateInstance();
	    
	// private static ThreadLocal<ExtentTest> extentTestThread =new ThreadLocal<ExtentTest>();
	   @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {      	
	       testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	       Driver.StartBrowser(BrowserTypes.Chrome, 15);	
	       //scenaraioDef = BaseUtil.features.createNode( )
	    }
	    
	  
	    @Test(dataProvider = "features")    
	    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
	    
	    	BaseUtil.featureName =cucumberFeature.toString();			
	    	ExtentReportUtil.CreateInstance().setextentfeature(cucumberFeature.toString());	    	
	    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	    }
	   
	  @DataProvider(parallel=false)
	    public Object[][] features() {
	       //return testNGCucumberRunner.provideFeatures();   
		//  Object[][] sce=  testNGCucumberRunner.provideScenarios();
		//  scenarios().getClass().getName();
	    	 return testNGCucumberRunner.provideScenarios();
	    } 
	    
	    
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass(ITestContext text) throws IOException{            
	       testNGCucumberRunner.finish();        
	       Driver.StopBrowser();
	       
	    }
	    
	 
}
