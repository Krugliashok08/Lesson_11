package org.example;
public class Factorial
{
    public static int Factorial( int number ) {
        if (number == 0) {
            return 1;
        } else {
            return number * Factorial(number - 1);
        }
    }
    public static int FactorialCondition(int n, boolean includeOne) {
        if (includeOne) {
            return Factorial(n);
        } else {
            return Factorial(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(FactorialCondition(5, true));
        System.out.println(FactorialCondition(5, false));
    }
}
