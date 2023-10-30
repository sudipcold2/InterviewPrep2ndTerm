package com.sudipcold.recursion;

/**
 * The modulo operation (abbreviated as mod) finds the remainder after the division of one number,
 * the dividend, by another number, the divisor.
 *
 * We read this as 14 mod 4 is equal to 2.
 */
public class Modulo {
    public static int mod(int dividend, int divisor) {

        // Making sure there is no division by 0
        if (divisor == 0) {
            System.out.println("Divisor cannot be 0");
            return -1;
        }

        // Base case
        if (dividend < divisor) {
            return dividend;
        }
        // Recursive case
        else {
            return mod(dividend-divisor, divisor);
        }
    }

    public static void main( String args[] ) {
        int dividend = 27;
        int divisor = 0;
        int remainder = mod(dividend, divisor);
        System.out.println(dividend + " mod " + divisor + " = " + remainder);
    }
}
