package classwork.selenium.core;

import ru.yandex.qatools.allure.annotations.Attachment;
import classwork.selenium.core.WebDriverTestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.toByteArray;
import static classwork.selenide.util.PropertiesCache.getProperty;

public class TestListener implements ITestListener {

    protected WebDriver driver;
    private String sourceScreenshot = getProperty("screenshot.source");
    private String folderScreenshot = getProperty("screenshot.folder");

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    /*@Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = ((WebDriverTestBase) iTestResult.getInstance()).webDriver;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File("c:\\tmp\\failed\\"
                            + iTestResult.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = ((WebDriverTestBase) iTestResult.getInstance()).webDriver;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File(sourceScreenshot
                            + iTestResult.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String screenshotName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,
                    new File(folderScreenshot + screenshotName + ".png"));
            return toByteArray(scrFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
