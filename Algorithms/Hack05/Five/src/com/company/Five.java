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
