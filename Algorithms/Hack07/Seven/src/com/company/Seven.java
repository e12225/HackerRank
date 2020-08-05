//https://www.hackerrank.com/challenges/staircase/problem
//
// Consider a staircase of size :
//
//        #
//        ##
//        ###
//        ####
//        Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.
//
//        Write a program that prints a staircase of size .
//
//        Function Description
//
//        Complete the staircase function in the editor below. It should print a staircase as described above.
//
//        staircase has the following parameter(s):
//
//        n: an integer
//        Input Format
//
//        A single integer, , denoting the size of the staircase.
//
//        Constraints
//
//        .
//
//        Output Format
//
//        Print a staircase of size  using # symbols and spaces.
//
//        Note: The last line must have  spaces in it.
//
//        Sample Input
//
//        6
//        Sample Output
//
//        #
//        ##
//        ###
//        ####
//        #####
//        ######

package com.company;

import java.util.Scanner;

public class Seven {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        printStairCase(n);

    }

    static void printStairCase(int n) {

        int hashes = 1;

        while (n > 0) {

            for (int j = n - 1; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= hashes; k++) {
                System.out.print("#");
            }
            System.out.println();
            n--;
            hashes++;
        }
    }
}
