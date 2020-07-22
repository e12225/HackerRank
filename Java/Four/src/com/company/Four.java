package com.company;

import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int integer = scanner.nextInt();
        double doub = scanner.nextDouble();
        scanner.nextLine();
        String sentence = scanner.nextLine();

        scanner.close();

        System.out.println("String: " + sentence);
        System.out.println("Double: " + doub);
        System.out.println("Int: " + integer);
    }
}
