package pack_test1;

import com.skippersoft.testng.annotation.Unstable;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {
    @Test
    void passedTest() {
        System.out.println("IT'S T1 TEST");
        Assert.assertTrue(true);
    }

    @Test
    void passedTest2() {
        System.out.println("IT'S T1 and T2 TEST");
        Assert.assertTrue(true);
    }

    @Test
    @Unstable
    void failedTest3() {
        System.out.println("IT'S T2 TEST");
        Assert.fail();
    }
}
