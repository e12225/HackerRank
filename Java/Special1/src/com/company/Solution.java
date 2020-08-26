//https://www.hackerrank.com/challenges/java-lambda-expressions/problem

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation performOperation, int num) {
        return performOperation.check(num);
    }

    public static PerformOperation isOdd() {
        return number -> (number & 1) == 1;
    }

    public static PerformOperation isPrime() {
        return number -> {
            if (number < 2) {
//                because, neither 0 nor 1 is a prime number
                return false;
            }
//            taking the square root of the number
            int squareRoot = (int) Math.sqrt(number);

            for (int i = 2; i <= squareRoot; i++) {
                if (number % i == 0) {
//                    that means there is another factor of the given number (m), apart from itself
                    return false;
                }
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {

        return number -> {
            String initialNumber = Integer.toString(number);
            String reversedNumber = new StringBuilder(Integer.toString(number)).reverse().toString();
            return initialNumber.equals(reversedNumber);
        };
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}