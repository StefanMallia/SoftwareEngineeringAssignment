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
            return fibonacciSequence(index-1)+fibonacciSequence(index-2);
    }
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
    
}
