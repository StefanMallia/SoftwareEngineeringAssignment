package SoftwareEngineeringAssignment;

import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class FactorialTest
{
    @Test
    public void test_factorial()
    {
        Assert.assertEquals(3628800, Factorial.factorial(10));
        Assert.assertEquals(1, Factorial.factorial(0));
        Assert.assertEquals(39916800, Factorial.factorial(11));
    }
}
