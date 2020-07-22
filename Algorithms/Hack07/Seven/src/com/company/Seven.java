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
