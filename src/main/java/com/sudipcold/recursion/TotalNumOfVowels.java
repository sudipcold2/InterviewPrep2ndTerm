package com.sudipcold.recursion;

public class TotalNumOfVowels {
    public static int totalVowels(String text, int len, int index) {
        int count = 0;

        if (len == 0) {
            return 0;
        }
        char single = Character.toUpperCase(text.charAt(index));
        if (single == 'A' || single == 'E' || single == 'I' || single == 'O' || single == 'U') {
            count++;
        }
        return count + totalVowels(text, len-1, index+1);
    }

    public static int callTotalVowels(String text) {
        return totalVowels(text, text.length(), 0);
    }

    public static void main( String args[] ) {
        String string1 = "Hello world";
        String string2 = "STR";
        String string3 = "AEIOUaeiouSs";

        int result1 = callTotalVowels(string1);
        int result2 = callTotalVowels(string2);
        int result3 = callTotalVowels(string3);

        System.out.println( "Total number of vowels in " + string1 + " are = " + result1);
        System.out.println( "Total number of vowels in " + string2 + " are = " + result2);
        System.out.println( "Total number of vowels in " + string3 + " are = " + result3);
    }

}
