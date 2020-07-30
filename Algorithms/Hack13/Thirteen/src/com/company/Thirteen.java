//You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
//
//        The first kangaroo starts at location  and moves at a rate of  meters per jump.
//        The second kangaroo starts at location  and moves at a rate of  meters per jump.
//        You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.
//
//        For example, kangaroo  starts at  with a jump distance  and kangaroo  starts at  with a jump distance of . After one jump, they are both at , (, ), so our answer is YES.
//
//        Function Description
//
//        Complete the function kangaroo in the editor below. It should return YES if they reach the same position at the same time, or NO if they don't.
//
//        kangaroo has the following parameter(s):
//
//        x1, v1: integers, starting position and jump distance for kangaroo 1
//        x2, v2: integers, starting position and jump distance for kangaroo 2
//        Input Format
//
//        A single line of four space-separated integers denoting the respective values of , , , and .
//
//        Constraints
//
//        Output Format
//
//        Print YES if they can land on the same location at the same time; otherwise, print NO.
//
//        Note: The two kangaroos must land at the same location after making the same number of jumps.
//
//        Sample Input 0
//
//        0 3 4 2
//        Sample Output 0
//
//        YES

package com.company;

import java.util.Scanner;

public class Thirteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        String result = "NO";

        int jumps = 0;
        int gap = 0;
        int lastGap;

        if ((x1 > x2 && v1 > v2) || (x1 < x2 && v1 < v2)) {
            result = "NO";
        } else if (x1 == x2 && v1 == v2) {
            result = "YES";
        } else {

            if (x1 > x2) {
                gap = x1 - x2;
            }
            if (x1 < x2) {
                gap = x2 - x1;
            }
            lastGap = gap;

            while (gap != 0) {

                x1 = x1 + v1;
                x2 = x2 + v2;
                jumps++;
                if (x1 > x2) {
                    gap = x1 - x2;
                }
                if (x1 < x2) {
                    gap = x2 - x1;
                }
                if (x1 == x2) {
                    gap = x1 - x2;
                }

                if (gap > lastGap) {
                    result = "NO";
                    break;
                }
                if (gap < lastGap) {
                    lastGap = gap;
                }
                if (gap == 0) {
                    result = "YES";
                    break;
                }
            }

        }
        return result;
    }
}

