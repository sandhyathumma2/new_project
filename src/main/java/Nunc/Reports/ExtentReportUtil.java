package Nunc.Reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import Nunc.Core.Libraries.Driver;

public class ExtentReportUtil {
	WebDriver driver;
	private static ExtentReportUtil extentreport;
	private static ExtentReports extent;
	public static ExtentTest test;
	// public static ExtentTest features;
	public static ExtentTest scenarioDef;
	private static final ThreadLocal<ExtentTest> extenttestThread = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> extentScenario = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> extentThreadFeatures = new ThreadLocal<ExtentTest>();

	// private static final ThreadLocal<ExtentTest> extentScenariodef=new
	// ThreadLocal<ExtentTest>();
	// private String filename = reportLocation + "\\extentreport.html";
	public ExtentReportUtil(WebDriver webDriver) {
		this.driver = webDriver;
	}

	public ExtentReportUtil() {

	}

	public static ExtentReportUtil CreateInstance() {
		if (extentreport == null) {
			extentreport = new ExtentReportUtil();
		}
		return extentreport;
	}
	public static ExtentReportUtil CreateInstance(WebDriver webDriver) {
		if (extentreport == null) {
			extentreport = new ExtentReportUtil(webDriver);
		}
		return extentreport;
	}

	public ExtentReports ExtentReport() {
		String filename = System.getProperty("user.dir") + "\\test-output\\extentreport.html";

		System.out.print(filename);
		extent = new ExtentReports(); // extent.
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.loadXMLConfig("resources\\extent-config.xml");
		extent.attachReporter(htmlReporter);
		// extentReportThread.set(extent);
		// return extentReportThread.get();
		return extent;
	}

	public void setextentTest(String testname, String featureName) throws ClassNotFoundException {
		ExtentTest features = extent.createTest(Feature.class, featureName);
		scenarioDef = features.createNode(Scenario.class, testname);

		// ExtentTest test =extent.createTest(testname);
		// extenttestThread.set(test);
		extenttestThread.set(features);
	}

	public void setextentfeature(String featureName) throws ClassNotFoundException {
		ExtentTest features = extent.createTest(Feature.class, featureName);
		// scenarioDef= features.createNode(Scenario.class,testname);
		// ExtentTest test =extent.createTest(testname);
		// extenttestThread.set(test);
		extenttestThread.set(features);
	}

	public void setextentscenario(String scenarioname) throws ClassNotFoundException {
		scenarioDef = extenttestThread.get().createNode(Scenario.class, scenarioname);
		extentScenario.set(scenarioDef);
	}

	public void setextentfeature1(String scenario) throws ClassNotFoundException {
		// features = extent.createTest(Feature.class,featureName);
		// extentThreadFeatures.set(value);
		// System.out.print("scenario name is "+extenttestThread.get().toString());
		// ExtentTest scenarioDef= extenttestThread.get().createNode(new
		// GherkinKeyword("Scenario"),scenario);
		// extentThreadFeatures.set(scenarioDef);
	}

	public void setnodetext(String testnodetext) throws ClassNotFoundException {
		// System.out.print("node text is "+extenttestThread.get().toString());
		// extenttestThread.get().createNode(testnodetext);
		// extenttestThread.get().createNode(testnodetext);
		extenttestThread.get().createNode(new GherkinKeyword("Then"), testnodetext).pass("step is passed");
	}

	public void setnodestep(String keyword, String testnodetext, String expectedStatement)
			throws ClassNotFoundException {
		extentScenario.get().createNode(new GherkinKeyword(keyword),keyword +":"+ testnodetext).pass(expectedStatement);
	}

	public void setnodefailstep(String keyword, String testnodetext, String expectedStatement)
			throws ClassNotFoundException, IOException {
		extentScenario.get().createNode(new GherkinKeyword(keyword), testnodetext).fail(expectedStatement)
				.addScreenCaptureFromPath(ExtentReportScreenShot());
	}

	public String ExtentReportScreenShot() throws IOException {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.print(System.getProperty("user.dir") + "\\test-output\\screenshot_"+ formattedDate + ".png");
		// reportLocation + "screenshot_"+formattedDate+".png";
		
		WebDriver dddriver =  Driver.getDriver();
		File scr = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File(System.getProperty("user.dir") + "\\test-output\\screenshot_"+ formattedDate + ".png"));
		return System.getProperty("user.dir") + "\\test-output\\screenshot_"+ formattedDate + ".png";

	}

	public void FlushReport() {

		extent.flush();
	}

}