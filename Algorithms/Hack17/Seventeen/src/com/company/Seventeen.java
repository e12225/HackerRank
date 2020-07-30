//You are given an array of  integers, , and a positive integer, . Find and print the number of  pairs where  and  +  is divisible by .
//
//        For example,  and . Our three pairs meeting the criteria are  and .
//
//        Function Description
//
//        Complete the divisibleSumPairs function in the editor below. It should return the integer count of pairs meeting the criteria.
//
//        divisibleSumPairs has the following parameter(s):
//
//        n: the integer length of array
//        ar: an array of integers
//        k: the integer to divide the pair sum by
//        Input Format
//
//        The first line contains  space-separated integers,  and .
//        The second line contains  space-separated integers describing the values of .
//
//        Constraints
//
//        Output Format
//
//        Print the number of  pairs where  and  +  is evenly divisible by .
//
//        Sample Input
//
//        6 3
//        1 3 2 6 1 2
//        Sample Output
//
//        5

package com.company;

import java.util.Scanner;

public class Seventeen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] ar = new int[n];

        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }

        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {

        int position = 0;
        int numberOfPairs = 0;

        for (int i = position; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if ((ar[i] + ar[j]) % k == 0) {
                    numberOfPairs++;
                }
            }
            position++;
        }

        return numberOfPairs;
    }
}
