package for_flaky.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class SomeJunit5Test {

    @RepeatedTest(5)
    public void testJunit5() {
        Assertions.assertFalse(true);
    }

}