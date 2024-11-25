package for_flaky.testNg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgRetry implements IRetryAnalyzer {

    private int countRetry = 0;
    private int maxCountRetry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (countRetry < maxCountRetry) {
                countRetry++;
                return true;
            }
        }
        return false;
    }
}