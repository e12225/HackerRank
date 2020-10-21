//https://www.hackerrank.com/challenges/java-end-of-file/problem

package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Twelve {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        int i = 1;
        while(input.hasNext())
        {
            line = input.nextLine();
            System.out.println(i + " "+ line);
            i++;
        }
    }
}