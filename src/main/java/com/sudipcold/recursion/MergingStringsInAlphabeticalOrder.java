package com.sudipcold.recursion;

public class MergingStringsInAlphabeticalOrder {

    private static String alphabeticMerge(String one, String two) {
        if (one == null || one.equals("")) {
            return two==null? one:two;
        }
        else if (two == null || two.equals("")) {
            return one;
        }
        else if (two.charAt(0) > one.charAt(0)) {
            return one.charAt(0) + alphabeticMerge(one.substring(1, one.length()), two);
        }
        else {
            return two.charAt(0) + alphabeticMerge(one, two.substring(1, two.length()));
        }
    }

    public static void main( String args[] ) {
        String one = "adz";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);
    }
}
