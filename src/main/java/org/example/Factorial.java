package org.example;

/**
 * Hello world!
 *
 */
public class Factorial
{
    public static int Factorial( int number ) {
        if (number == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
