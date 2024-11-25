package for_flaky.junit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class SomeJunit4Test {

    @Rule
    public RetryRule role = new RetryRule(3);

    @Test
    public void testJunit4() {
        Assert.assertFalse(true);
    }

}