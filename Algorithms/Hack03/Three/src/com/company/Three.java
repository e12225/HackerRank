//https://www.hackerrank.com/challenges/compare-the-triplets/problem
//
//
// Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.
//
//        The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).
//
//        The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
//
//        If a[i] > b[i], then Alice is awarded 1 point.
//        If a[i] < b[i], then Bob is awarded 1 point.
//        If a[i] = b[i], then neither person receives a point.
//        Comparison points is the total points a person earned.
//
//        Given a and b, determine their respective comparison points.
//
//        Example
//
//        a = [1, 2, 3]
//        b = [3, 2, 1]
//        For elements *0*, Bob is awarded a point because a[0] .
//        For the equal elements a[1] and b[1], no points are earned.
//        Finally, for elements 2, a[2] > b[2] so Alice receives a point.
//        The return array is [1, 1] with Alice's score first and Bob's second.
//
//        Function Description
//
//        Complete the function compareTriplets in the editor below.
//
//        compareTriplets has the following parameter(s):
//
//        int a[3]: Alice's challenge rating
//        int b[3]: Bob's challenge rating
//        Return
//
//        int[2]: Alice's score is in the first position, and Bob's score is in the second.
//        Input Format
//
//        The first line contains 3 space-separated integers, a[0], a[1], and a[2], the respective values in triplet a.
//        The second line contains 3 space-separated integers, b[0], b[1], and b[2], the respective values in triplet b.
//
//        Constraints
//
//        1 ≤ a[i] ≤ 100
//        1 ≤ b[i] ≤ 100
//        Sample Input 0
//
//        5 6 7
//        3 6 10
//        Sample Output 0
//
//        1 1

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
