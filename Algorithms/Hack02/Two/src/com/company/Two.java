//Given an array of integers, find the sum of its elements.
//
//        For example, if the array , , so return .
//
//        Function Description
//
//        Complete the simpleArraySum function in the editor below. It must return the sum of the array elements as an integer.
//
//        simpleArraySum has the following parameter(s):
//
//        ar: an array of integers
//        Input Format
//
//        The first line contains an integer, , denoting the size of the array.
//        The second line contains  space-separated integers representing the array's elements.
//
//        Constraints
//
//
//        Output Format
//
//        Print the sum of the array's elements as a single integer.
//
//        Sample Input
//
//        6
//        1 2 3 4 10 11
//        Sample Output
//
//        31

package com.company;

import java.util.Scanner;

public class Two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
    }

    static int simpleArraySum(int n, int[] ar) {

        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
            sum = sum + ar[i];
        }
        return sum;
    }
}
