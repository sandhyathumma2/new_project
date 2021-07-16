package nunc.automation.listeners;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;

import Nunc.Core.Libraries.Driver;
import Nunc.Reports.ExtentReportUtil;





public class ITestListernerImpl implements ITestListener {
	//private static  ExtentReports extent = ExtentReportUtil.CreateInstance();
	    
	// private static ThreadLocal<ExtentTest> extentTestThread =new ThreadLocal<ExtentTest>(); work
	private static boolean isReportRunning;
	//private static ExtentTest test;
	public void onFinish(ITestContext iTestContext) {
	ExtentReportUtil.CreateInstance().FlushReport();
		//ExtentReportUtil.FlushReport();
		//extent.flush();
		System.out.print("On finish from listener");
	}

	public void onStart(ITestContext iTestContext) {
		ExtentReportUtil.CreateInstance().ExtentReport();
		//if(!isReportRunning) {			
		//	extentreportUtil.ExtentReport();
		 //   isReportRunning = true;				
		//}
		
		System.out.print("from on start");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	
		System.out.print("from on nTestFailedButWithinSuccessPercentage");
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		
			 try {				
				 System.out.print("from onTestFailure "+iTestResult.getMethod().getMethodName()+" name "+iTestResult.getTestName()+" Status "+iTestResult.getThrowable());
				 ExtentReportUtil.CreateInstance().setnodefailstep("When", iTestResult.getMethod().getMethodName() , iTestResult.getThrowable().getMessage());
				 
		//	ExtentReportUtil.scenarioDef.createNode(iTestResult.getTestName()).fail(iTestResult.getThrowable());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
					
	} 


	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}


	public void onTestStart(ITestResult result) {
	//	ExtentTest test = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
	//	extentTestThread.set(test);
		 System.out.print("from teststart feature name "+ result.getMethod() +" is name");
		// TODO Auto-generated method stub
	 // ExtentReportUtil.test =	extent.createTest(iTestResult.getTestName());
	 //	extentTestThread.get().createNode("this is test name");
	}


	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		// System.out.print("from testsuccess "+ extentTestThread.get());
	//	extentTestThread.get().createNode("Node is created");
	//s	extentTestThread.get().createNode(iTestResult.getTestName()).pass("This step is passed");
	}



}
