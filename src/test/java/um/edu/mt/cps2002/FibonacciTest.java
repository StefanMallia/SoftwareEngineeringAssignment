package SoftwareEngineeringAssignment;

import org.junit.Assert;
import org.junit.Test;



public class FibonacciTest
{
    @Test
    public void test_fibonacciSequence()
    {
        Assert.assertEquals(55, Fibonacci.fibonacciSequence(10));
    }
    @Test
    public void test_sumFibonacci()
    {
        Assert.assertEquals(12, Fibonacci.sumFibonacci(5));
    }

}
