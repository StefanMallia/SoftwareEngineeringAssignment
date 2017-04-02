package SoftwareEngineeringAssignment;

import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class FibonacciTest
{
    @Test
    public void testFib()
    {
        Assert.assertEquals(55, Fibonacci.fibonacciSequence(10));
    }

}
