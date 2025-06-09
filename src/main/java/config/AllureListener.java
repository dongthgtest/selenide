package config;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.*;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setStatus(Status.FAILED);
        });
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setStatus(Status.PASSED);
        });
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setStatus(Status.SKIPPED);
        });
    }
}
