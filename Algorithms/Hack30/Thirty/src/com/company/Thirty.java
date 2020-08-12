//https://www.hackerrank.com/challenges/extra-long-factorials/problem

package com.company;

import java.util.*;

import java.math.BigInteger;
import java.util.Scanner;

public class Thirty {

//    Factorial recursive.
    static BigInteger factorialRecursive(int N) {
        if (N <= 1) {
            return new BigInteger("1");
        } else {
            return BigInteger.valueOf(N).multiply(factorialRecursive(N - 1));
        }
    }

//    Generate and print factorial for specified number.
    static void factorial(int N) {
        BigInteger factorial = new BigInteger("1");

        for (int n = 1; n <= N; n++) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
        }

        System.out.println(factorial.toString());
    }

//    Test code.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        factorial(N);
        System.out.println(factorialRecursive(N));
        sc.close();
    }
}
