//https://www.hackerrank.com/challenges/bon-appetit/problem
//
// Anna and Brian are sharing a meal at a restuarant and they agree to split the bill equally. Brian wants to order something that Anna is allergic to though, and they agree that Anna won't pay for that item. Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.
//
//        For example, assume the bill has the following prices: . Anna declines to eat item  which costs . If Brian calculates the bill correctly, Anna will pay . If he includes the cost of , he will calculate . In the second case, he should refund  to Anna.
//
//        Function Description
//
//        Complete the bonAppetit function in the editor below. It should print Bon Appetit if the bill is fairly split. Otherwise, it should print the integer amount of money that Brian owes Anna.
//
//        bonAppetit has the following parameter(s):
//
//        bill: an array of integers representing the cost of each item ordered
//        k: an integer representing the zero-based index of the item Anna doesn't eat
//        b: the amount of money that Anna contributed to the bill
//        Input Format
//
//        The first line contains two space-separated integers  and , the number of items ordered and the -based index of the item that Anna did not eat.
//        The second line contains  space-separated integers  where .
//        The third line contains an integer, , the amount of money that Brian charged Anna for her share of the bill.
//
//        Constraints
//
//        The amount of money due Anna will always be an integer
//        Output Format
//
//        If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna. This will always be an integer.
//
//        Sample Input 0
//
//        4 1
//        3 10 2 9
//        12
//        Sample Output 0
//
//        5

package com.company;

import java.util.*;

public class Twenty
{

    static String bonAppetit( int n, int k, int b, int[] ar )
    {

        int actual = 0;

        for( int i = 0; i < n; i++ )
        {
            if( i != k )
            {
                actual = actual + ar[i];
            }
        }

        actual = actual / 2;

        if( actual == b )
        {
            return ( "Bon Appetit" );
        }
        else
        {
            return Integer.toString( b - actual );
        }
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for( int ar_i = 0; ar_i < n; ar_i++ )
        {
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        String result = bonAppetit( n, k, b, ar );
        System.out.println( result );
    }
}