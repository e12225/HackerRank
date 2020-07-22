package com.company;

import java.util.Scanner;

public class Three {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {

        int a_score = 0;
        int b_score = 0;

        if (a0 - b0 != 0) {
            if (Math.max(a0, b0) == a0) {
                a_score++;
            } else {
                b_score++;
            }
        }
        if (a1 - b1 != 0) {
            if (Math.max(a1, b1) == a1) {
                a_score++;
            } else {
                b_score++;
            }
        }

        if (a2 - b2 != 0) {
            if (Math.max(a2, b2) == a2) {
                a_score++;
            } else {
                b_score++;
            }
        }

        int[] points = {a_score, b_score};

        return points;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
}
