package com.sudipcold.recursion;

/**
 * Exponent of a number POW(n,p) n to the power p
 */
public class ExponentOfNumber {
    public static long power(int num, int pow) {
        if (pow == 0) {
            return 1;
        } else {
            return num * power(num, pow-1);
        }
    }

    public static void main( String args[] ) {
        int num = 5;
        int pow = 2;
        long result = power(num, pow);
        System.out.println(num + " power of " + pow + " is: " + result);
    }
}
