//https://www.hackerrank.com/challenges/between-two-sets/problem
//
//
//You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
//
//        The elements of the first array are all factors of the integer being considered
//        The integer being considered is a factor of all elements of the second array
//        These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
//
//        For example, given the arrays  and , there are two numbers between them:  and . , ,  and  for the first value. Similarly, ,  and , .
//
//        Function Description
//
//        Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
//
//        getTotalX has the following parameter(s):
//
//        a: an array of integers
//        b: an array of integers
//        Input Format
//
//        The first line contains two space-separated integers,  and , the number of elements in array  and the number of elements in array .
//        The second line contains  distinct space-separated integers describing  where .
//        The third line contains  distinct space-separated integers describing  where .
//
//        Constraints
//
//        Output Format
//
//        Print the number of integers that are considered to be between  and .
//
//        Sample Input
//
//        2 3
//        2 4
//        16 32 96
//        Sample Output
//
//        3

package com.company;

import java.util.Scanner;

public class Fourteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        int total = getTotalX(a, b);
        System.out.println(total);
    }

    static int getTotalX(int[] a, int[] b) {

        int total = 0;
        int maxOfA = a[0];
        int minOfB = b[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= maxOfA) {
                maxOfA = a[i];
            }
        }

        for (int j = 0; j < b.length; j++) {
            if (b[j] <= minOfB) {
                minOfB = b[j];
            }
        }


        int k;
        int l;
        for (int x = maxOfA; x <= minOfB; ) {

            for (k = 0; k < a.length; k++) {
                if (x % a[k] != 0) {
                    x++;
                    break;
                }
            }

            for (l = 0; l < b.length; l++) {
                if (b[l] % x != 0) {
                    x++;
                    break;
                }
            }

            if(k==a.length && l==b.length){
                total++;
                x++;
            }
        }

        return total;
    }
}
