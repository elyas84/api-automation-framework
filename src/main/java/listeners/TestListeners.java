package listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import extentReport.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static extentReport.ExtentTestManager.getTest;
import static extentReport.ExtentTestManager.startTest;

public class TestListeners implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListeners.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        startTest(result.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        result.getStatus();
        getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.YELLOW));
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("{} is started", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        result.getStatus();
        getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
    }
}
