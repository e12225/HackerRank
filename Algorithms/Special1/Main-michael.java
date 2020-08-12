// problem : https://www.hackerrank.com/challenges/bigger-is-greater/problem


package com.hack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int ctr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i<testCases; i++){
            String word = in.next();
            System.out.println(generateOutput(word));
        }
        in.close();
    }

    public static String generateOutput(String w){
        if (w.length() < 1) {
            return "no answer";
        }
        ArrayList<Character> endChars = new ArrayList<>();
        endChars.add(w.charAt(w.length() - 1));
        int index = -1;
        for (int i = w.length() - 2; i >= 0; --i) {
            char candidate = w.charAt(i);
            if (endChars.stream().allMatch(c -> candidate >= c)) {
                endChars.add(candidate);
            } else {
                index = i;
                break;
            }
        }

        // Check for pure descending order
        if (index == -1) {
            return "no answer";
        }

        // find the next biggest char
        int nextSmallestIndex = -1;
        char nextSmallest = Character.MAX_VALUE;
        for (int i = index + 1; i < w.length(); ++i) {
            if (w.charAt(i) < nextSmallest && w.charAt(i) > w.charAt(index)) {
                nextSmallest = w.charAt(i);
                nextSmallestIndex = i;
            }
        }

        // pull out the chars that need to be reorderd
        String toReorder = w.substring(index, nextSmallestIndex);
        if (nextSmallestIndex < w.length() - 1) {
            toReorder += w.substring(nextSmallestIndex + 1);
        }

        // sort them
        char[] toReorderAsChars = toReorder.toCharArray();
        Arrays.sort(toReorderAsChars);

        // paste the result back together
        StringBuilder sb = new StringBuilder();
        if (index > 0) {
            sb.append(w, 0, index);
        }
        sb.append(w, nextSmallestIndex, nextSmallestIndex + 1);
        sb.append(toReorderAsChars);

        return sb.toString();

    }

}
