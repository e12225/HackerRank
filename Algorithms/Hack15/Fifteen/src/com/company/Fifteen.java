//Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.
//
//        For example, assume her scores for the season are represented in the array . Scores are in the same order as the games played. She would tabulate her results as follows:
//
//        Count
//        Game  Score  Minimum  Maximum   Min Max
//        0      12     12       12       0   0
//        1      24     12       24       0   1
//        2      10     10       24       1   1
//        3      24     10       24       1   1
//        Given Maria's scores for a season, find and print the number of times she breaks her records for most and least points scored during the season.
//
//        Function Description
//
//        Complete the breakingRecords function in the editor below. It must return an integer array containing the numbers of times she broke her records. Index  is for breaking most points records, and index  is for breaking least points records.
//
//        breakingRecords has the following parameter(s):
//
//        scores: an array of integers
//        Input Format
//
//        The first line contains an integer , the number of games.
//        The second line contains  space-separated integers describing the respective values of .
//
//        Constraints
//
//        Output Format
//
//        Print two space-seperated integers describing the respective numbers of times her best (highest) score increased and her worst (lowest) score decreased.
//
//        Sample Input 0
//
//        9
//        10 5 20 20 4 5 2 25 1
//        Sample Output 0
//
//        2 4

package com.company;

import java.util.Scanner;

public class Fifteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }

        int[] result = getRecord(s);

        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }

    static int[] getRecord(int[] s) {

        int incresed = 0;
        int decreased = 0;
        int[] result = new int[2];

        int min = s[0];
        int max = s[0];

        for (int i = 0; i < s.length; i++) {
            if (s[i] < min) {
                decreased++;
                min = s[i];
            }
            if (s[i] > max) {
                incresed++;
                max = s[i];
            }
        }

        result[0] = incresed;
        result[1] = decreased;

        return result;
    }
}
