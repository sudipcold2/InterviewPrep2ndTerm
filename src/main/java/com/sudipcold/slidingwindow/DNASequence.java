package com.sudipcold.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string, s, that represents a DNA subsequence, and a number,
 * return all the contiguous subsequences (substrings) of length
 * that occur more than once in the string. The order of the returned subsequences does not matter.
 * If no repeated substring is found, the function should return an empty set.
 * The DNA sequence is composed of a series of nucleotides abbreviated as A, G, T, C
 * ACGAATTCCG is a DNA sequence. When studying DNA, it is useful to identify repeated sequences in it.
 */
public class DNASequence {

    public static Set<String> getSubsets(String s, int k){
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while ((i + k - 1) < s.length()){
            String substring = s.substring(i, i + k);
            if(map.containsKey(substring)){
                map.put(substring, map.get(substring) + 1);
            }else {
                map.put(substring, 1);
            }
            i++;
        }

        Set<String> ans = map.keySet().stream().filter(key -> map.get(key) > 1).collect(Collectors.toSet());

        return ans;
    }

    public static Set<String> findRepeatedSequences(String s, int k) {

        int n = s.length();

        if (n < k) {
            return new HashSet<>();
        }

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        int a = 4;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        int hashValue = 0;

        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < n - k + 1; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) *
                        (int) Math.pow(a, k - 1)) * a) + numbers.get(i + k - 1);
            }

            if (hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            hashSet.add(hashValue);
        }
        return output;
    }

    public static void main(String[] args) {
        Set<String> set = getSubsets("ATATATATATATATAT", 6);
        System.out.println(set);
    }
}
