package SoftwareEngineeringAssignment;

public class Fibonacci
{
    public static int fibonacciSequence(int index)
    {
        if(index==0)
            return 0;
        else if(index == 1 || index == 2)
            return 1;
        else
			//return 1; //intentionally breaking it
            return fibonacciSequence(index-1)+fibonacciSequence(index-2);
    }
    public static int sumFibonacci(int index)
    {
        int sumResult = 0;
        for(int i = 0; i <= index; i++)
            sumResult = sumResult + fibonacciSequence(i);
        return sumResult;
    }
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
    
	}


