import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = true;

        System.out.println("Enter 1 for simple try demo");
        System.out.println("Enter 2 for simple try and multi catch demo");
        System.out.println("Enter 3 for nested try-catch demo");
        System.out.println("Enter 4 for throw demo");
        System.out.println("Enter 5 for throws demo");
        System.out.println("Enter 6 for finally demo");
        System.out.println("Enter 7 for custom exception demo");
        System.out.println("Enter any other value to exit");

        while (flag)
        {
            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1: simpleTry();
                    break;
                case 2: multiCatch();
                    break;
                case 3: nestedTry();
                    break;
                case 4: throwDemo();
                    break;
                case 5: try
                    {
                        throwsDemo();
                    }
                    catch (NullPointerException n)
                    {
                        System.out.println("Exception caught from throwsDemo()");
                    }
                    break;
                case 6: finallyDemo();
                    break;
                case 7: customException();
                    break;
                default:
                    System.out.println("Program Execution Stopped");
                    flag = false;
            }
        }

        try{
            throwsDemo();
        }
        catch (NullPointerException n)
        {
            System.out.println("Excpetion from throwsDemo() caught");
        }
    }

    public static void simpleTry()
    {
        int a = 5;
        int b = 0;

        //Simple try catch block demonstrated by ArithmeticException
        //ArithmeticException is raised when invalid arithmetic operations such as dividing by zero are performed
        try{
            int c = a/b;
            System.out.println(c);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Division by zero not possible");
        }
    }

    public static void multiCatch()
    {
        //Single try, multiple catch demonstrated by ArrayIndexOutOfBounds and NullPointerException
        String str = null;
        int[] arr = new int[5];

        try{
            int x = arr[6];
            int stringLength = str.length();
        }
        catch(NullPointerException n)
        {
            System.out.println("String length can't be 0");
        }
        catch (ArrayIndexOutOfBoundsException var)
        {
            System.out.println("Accessed index out of bounds");
        }
    }

    public static void nestedTry()
    {
        int a = 4;
        int b= 0;
        //Nested Try-Catch Block
        try{
            try{
                int c = a/b;
            }
            catch (ArithmeticException e)
            {
                System.out.println("Can't divide by zero");
            }
            try{
                String s = "Fenil";
                System.out.println(s.charAt(5));
            }
            catch (StringIndexOutOfBoundsException se)
            {
                System.out.println("String Index out of bounds");
            }
        }
        catch (Exception e)     //This catch will only be executed if the parent try block raises an exception
        {
            System.out.println("Exception");
        }
    }

    public static void throwDemo()
    {
        //Demonstration of 'throw'
        //'throw' is a keyword in Java
        //Used to throw exception in a block of code
        //Always followed by an instance
        //I will demonstrate use of 'throw' by ArithmeticException and NullPointerException
        try{
            throw new ArithmeticException("5");     //Parameter to the constructor can be any String
        }
        catch (ArithmeticException ar)
        {
            System.out.println("ArithmeticException caught");
        }
        try{
            throw new NullPointerException("1");   //Parameter to the constructor can be any String
        }
        catch (NullPointerException np)
        {
            System.out.println("NullPointerException caught");
        }
    }

    public static void throwsDemo() throws NullPointerException
    {
        //'throws' is a keyword of Java.
        //'throws' is always used with method signature
        //I will demonstrate 'throws' by NullPointerException
        //We can handle the exception raised from this method by the caller method (main() in our case)

        String str = null;
        System.out.println(str.length());
    }

    public static void finallyDemo()
    {
        //'finally' is a keyword of Java.
        //'finally' must by followed by either try block or try-catch block
        //The code written in 'finally' block is always executed

        try {
            int[] arr = new int[5];
            System.out.println(arr[6]);     //raises ArrayOutOfBoundsException
        }
        catch (ArrayIndexOutOfBoundsException a)
        {
            System.out.println("Accessed index out of array bounds");
        }
        finally {
            //This piece of block is always executed

            System.out.println("Program execution continues");
        }
    }

    public static void customException()
    {
        //We can also implement our custom exceptions in a new class.
        //I have created CustomException class extended from Exception class for the sake of demonstration

        try {
            throw new CustomException("1");     //Parameter can be any string
        }
        catch (CustomException ce)
        {
            System.out.println("Custom exception caught");
        }
    }
}
