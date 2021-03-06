//https://www.hackerrank.com/challenges/electronics-shop/submissions/code/66547269

package com.company;

import java.util.Scanner;

public class TwentyFour {

    static int getMoneySpent(int[] keyboards, int[] drives, int s){

        int max_total_cost = -1;
        int cost;

        for(int i = 0; i < keyboards.length; i++){

            for(int j = 0; j < drives.length; j++){

                cost = keyboards[i] + drives[j];

                if( cost <= s && max_total_cost <= cost)
                {
                    max_total_cost = keyboards[i] + drives[j];
                }
            }
        }

        return max_total_cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
