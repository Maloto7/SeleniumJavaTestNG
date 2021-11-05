package base.pom.selenium.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestNGListeners implements ITestListener, ISuiteListener {

    ExtentSparkReporter spark;
    ExtentReports extent;
    ExtentTest test;
    public void onStart(ISuite suite) {
        spark = new ExtentSparkReporter("./reports/extent2.xml");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    public void onFinish(ISuite suite) {
        extent.flush();
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        test.info("The test started");
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("The test passed successfully");

    }

    public void onTestFailure(ITestResult result) {
        String str = result.getThrowable().toString();
        String strNew = str.replace("<", "\"");
        strNew = strNew.replace(">", "\"");
        test.fail("The test failed; Test Name: " + result.getName()+"; Message: " + strNew);
    }

    public void onTestSkipped(ITestResult result) {
        test.info("The test Skipp");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        test.fail("Timeout");
    }
}