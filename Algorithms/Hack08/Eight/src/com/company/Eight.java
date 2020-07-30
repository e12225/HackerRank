//Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
//
//        Example
//
//        The minimum sum is  and the maximum sum is . The function prints
//
//        16 24
//        Function Description
//
//        Complete the miniMaxSum function in the editor below.
//
//        miniMaxSum has the following parameter(s):
//
//        arr: an array of  integers
//        Print
//        Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
//
//        Input Format
//
//        A single line of five space-separated integers.
//
//        Constraints
//
//
//        Output Format
//
//        Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
//
//        Sample Input
//
//        1 2 3 4 5
//        Sample Output
//
//        10 14

package com.company;

import java.util.Scanner;

public class Eight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }

        getMinMaxSum(arr);
    }

    static void getMinMaxSum(int[] arr) {

        long sum = 0;
        long[] sumArray = new long[5];
        int skippingPosition = 0;
        int x = 0;

        while (skippingPosition <= 4) {

            for (int i = 0; i < skippingPosition; i++) {
                sum = sum + arr[i];
            }
            for (int j = skippingPosition + 1; j <= 4; j++) {
                sum = sum + arr[j];
            }

            sumArray[x] = sum;
            x++;
            skippingPosition++;
            sum = 0;
        }

        long maxSum = 0;
        long minSum = sumArray[0];

        for (int j = 1; j < sumArray.length; j++) {
            if (sumArray[j] <= minSum) {
                minSum = sumArray[j];
            }
        }

        for (int k = 0; k < sumArray.length; k++) {
            if (sumArray[k] >= maxSum) {
                maxSum = sumArray[k];
            }
        }

        System.out.println(minSum + " " + maxSum);
    }
}
