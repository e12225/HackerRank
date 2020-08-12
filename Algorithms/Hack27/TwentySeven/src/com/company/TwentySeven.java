//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

package com.company;

import java.util.*;

public class TwentySeven {

    public static void main(String[] args) {

        System.out.print("Enter the number of players : ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];

        Set<Integer> scortedSet = new HashSet<Integer>();

        for (int scores_i = 0; scores_i < n; scores_i++) {
            scores[scores_i] = scanner.nextInt();
            scortedSet.add(scores[scores_i]);
        }

        int m = scanner.nextInt();
        int[] alice = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            alice[alice_i] = scanner.nextInt();
        }

        List<Integer> sortedList = new ArrayList<Integer>(scortedSet);
        Collections.sort(sortedList,Collections.reverseOrder());

        int ind;
        for (int i = 0; i < m; i++) {
            ind = Collections.binarySearch(sortedList, alice[i],Collections.reverseOrder());
            if(ind < 0){
                ind = Math.abs(ind);
            }else{
                ind++;
            }
            System.out.println(ind);
        }
    }

}