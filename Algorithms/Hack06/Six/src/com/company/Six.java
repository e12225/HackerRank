package com.company;

import java.util.Scanner;

public class Six {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }

        double positive_sum = 0;
        double negative_sum = 0;
        double zero_sum = 0;
        double array_size = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                positive_sum++;
            } else if (arr[i] < 0) {
                negative_sum++;
            } else {
                zero_sum++;
            }
        }

        double positive_prop = positive_sum/array_size;
        double negative_prop = negative_sum/array_size;
        double zero_prop = zero_sum/array_size;

        System.out.println(positive_prop);
        System.out.println(negative_prop);
        System.out.println(zero_prop);

    }
}
