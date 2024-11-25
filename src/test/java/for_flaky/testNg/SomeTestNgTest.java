package for_flaky.testNg;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SomeTestNgTest {

    @BeforeSuite
    public void setUp(ITestContext context) {
        //Arrays.stream(context.getAllTestMethods()).forEach(x -> x.setRetryAnalyzerClass(TestNgRetry.class));
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(TestNgRetry.class);
        }
    }

    @Test
    public void testNg() {
        Assert.assertFalse(true);
    }

    @Test
    public void testNg2() {
        Assert.assertFalse(true);
    }
}