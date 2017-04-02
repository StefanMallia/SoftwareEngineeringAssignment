package SoftwareEngineeringAssignment;

import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class FactorialTest
{
    @Test
    public void test_factorialiSequence()
    {
        Assert.assertEquals(3628800, Fibonacci.fibonacciSequence(10));
        Assert.assertEquals(1, Fibonacci.fibonacciSequence(0));
        Assert.assertEquals(39916800, Fibonacci.fibonacciSequence(11));
    }
}
