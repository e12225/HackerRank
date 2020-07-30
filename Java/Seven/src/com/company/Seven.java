//We use the integers , , and  to create the following series:
//
//        You are given  queries in the form of , , and . For each query, print the series corresponding to the given , , and  values as a single line of  space-separated integers.
//
//        Input Format
//
//        The first line contains an integer, , denoting the number of queries.
//        Each line  of the  subsequent lines contains three space-separated integers describing the respective , , and  values for that query.
//
//        Constraints
//
//        Output Format
//
//        For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of  space-separated integers.
//
//        Sample Input
//
//        2
//        0 2 10
//        5 3 5
//        Sample Output
//
//        2 6 14 30 62 126 254 510 1022 2046
//        8 14 26 50 98

package com.company;

import java.util.Scanner;

public class Seven {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of sequence here : ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            System.out.println("----Sequence " + (i+1) + " details----");
            System.out.print("Enter the value of 'a' : ");
            int a = scanner.nextInt();
            System.out.print("Enter the value of 'b' : ");
            int b = scanner.nextInt();
            System.out.print("Enter the number of values to be printed : ");
            int n = scanner.nextInt();

            int powerLimit = n - 1;
            int termWithoutA = 0;
            for (int power = 0; power <= powerLimit; power++) {

                termWithoutA = termWithoutA + (int) Math.pow(2.0, power);
                System.out.print((a+termWithoutA*b) + " ");
            }
            System.out.println("");
        }
        scanner.close();
    }
}
