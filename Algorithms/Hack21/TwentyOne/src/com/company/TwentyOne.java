//https://www.hackerrank.com/challenges/sock-merchant/problem
//
// John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
//
//        For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
//
//        Function Description
//
//        Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
//
//        sockMerchant has the following parameter(s):
//
//        n: the number of socks in the pile
//        ar: the colors of each sock
//        Input Format
//
//        The first line contains an integer , the number of socks represented in .
//        The second line contains  space-separated integers describing the colors  of the socks in the pile.
//
//        Constraints
//
//        where
//        Output Format
//
//        Return the total number of matching pairs of socks that John can sell.
//
//        Sample Input
//
//        9
//        10 20 20 10 10 30 50 10 20
//        Sample Output
//
//        3

package com.company;

import java.util.*;

public class TwentyOne {

    static int sockMerchant(int n, int[] ar) {

        int pairs = 0;
        int i = 0;
        int j = 1;

        while( i < n-1 )
        {
            while( j <= n-1 )
            {
                if(ar[i] == ar[j] && ar[i] != -1 && ar[j] != -1)
                {
                    pairs ++;
                    ar[i] = -1;
                    ar[j] = -1;
                    break;
                }
                else if(ar[i] == -1)
                {
                    break;
                }
                else
                {
                    j++;
                }
            }

            i++;
            j = i+1;
        }

        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}