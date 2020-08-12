//https://www.hackerrank.com/challenges/the-hurdle-race/problem

package com.company;

import java.util.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwentyEight {

    public static void main(String[] args) {

        System.out.print("Enter the number of hurdles : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print("Enter the maximum height Dan can jump naturally : ");
        int k = in.nextInt();
        int[] height = new int[n];


        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();

        }
        int largest= height[0];
        for(int i=0;i<n;i++){

            if(height[i]>largest){
                largest=height[i];
            }
        }
        if(largest>k){
            System.out.println(largest-k);
        }
        else
            System.out.println("0");

    }
}
