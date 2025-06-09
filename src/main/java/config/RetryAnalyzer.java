package config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int attempt = 0;
    private final int maxRetry;

    public RetryAnalyzer() {
        this.maxRetry = ConfigLoader.getConfig().retryCount;
    }

    @Override
    public boolean retry(ITestResult result) {
        if (attempt < maxRetry) {
            attempt++;
            return true;
        }
        return false;
    }
}
