package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.LoggerUtil;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY) {
            retryCount++;
            LoggerUtil.info("Retrying test: " + result.getName() + " | Attempt: " + retryCount);
            return true;
        }
        return false;
    }
}