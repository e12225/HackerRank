//https://www.hackerrank.com/challenges/diagonal-difference/problem
//
// Given a square matrix, calculate the absolute difference between the sums of its diagonals.
//
//        For example, the square matrix  is shown below:
//
//        1 2 3
//        4 5 6
//        9 8 9
//        The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .
//
//        Function description
//
//        Complete the  function in the editor below.
//
//        diagonalDifference takes the following parameter:
//
//        int arr[n][m]: an array of integers
//        Return
//
//        int: the absolute diagonal difference
//        Input Format
//
//        The first line contains a single integer, , the number of rows and columns in the square matrix .
//        Each of the next  lines describes a row, , and consists of  space-separated integers .
//
//        Constraints
//
//        Output Format
//
//        Return the absolute difference between the sums of the matrix's two diagonals as a single integer.
//
//        Sample Input
//
//        3
//        11 2 4
//        4 5 6
//        10 8 -12
//        Sample Output
//
//        15

package com.company;

import java.util.Scanner;

public class Five {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }

        int position_secondary = n-1;
        int primary_sum = 0;
        int secondary_sum = 0;
        for (int d_p = 0; d_p < n; d_p++) {
            primary_sum = primary_sum + a[d_p][d_p];
        }
        for (int d_s = 0; d_s < n; d_s++) {
            secondary_sum = secondary_sum + a[d_s][position_secondary];
            position_secondary--;
        }

        int diff = primary_sum - secondary_sum;
        if (diff < 0) {
            diff = diff * (-1);
        }

        System.out.println(diff);
    }
}
