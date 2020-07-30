//In this challenge, you are required to calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
//
//        Function Description
//
//        Complete the aVeryBigSum function in the editor below. It must return the sum of all array elements.
//
//        aVeryBigSum has the following parameter(s):
//
//        int ar[n]: an array of integers .
//        Return
//
//        int: the sum of all array elements
//        Input Format
//
//        The first line of the input consists of an integer .
//        The next line contains  space-separated integers contained in the array.
//
//        Output Format
//
//        Return the integer sum of the elements in the array.
//
//        Constraints
//
//
//        Sample Input
//
//        5
//        1000000001 1000000002 1000000003 1000000004 1000000005
//        Output
//
//        5000000015

package com.company;

import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        long sum = 0;

        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            sum = sum + arr[arr_i];
        }

        System.out.println(sum);
    }
}
