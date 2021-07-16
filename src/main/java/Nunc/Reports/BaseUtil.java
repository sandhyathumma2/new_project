package Nunc.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseUtil {
	
	//public WebDriver browser;
	public  ExtentReports extent =new ExtentReports();	
	public  ExtentTest scenarioDef;
	public  ExtentTest features;
	public  String reportLocation="test-output\\";
	public static String featureName="";

}