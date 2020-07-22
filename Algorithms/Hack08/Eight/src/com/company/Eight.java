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
