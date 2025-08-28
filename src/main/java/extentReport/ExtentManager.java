package extentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();


    public synchronized static ExtentReports createExtentReports() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmmss");
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/html-reports/report.html");
        reporter.config().setReportName("API automation");
        reporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("QA", "Elyas");
        return extentReports;
    }
}
