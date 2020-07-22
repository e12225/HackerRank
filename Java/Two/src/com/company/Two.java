package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String myString = bf.readLine();
            int myInt = Integer.parseInt(bf.readLine());

            System.out.println("myString is : " + myString);
            System.out.println("myInt is : " + myInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
