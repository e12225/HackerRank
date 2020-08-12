//https://www.hackerrank.com/challenges/queens-attack-2/problem

package com.company;

import java.util.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ThirtyTwo {

    public static void main(String[] args) {

        Approach approach = Approach.ClosestPoints;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();

        switch (approach) {
            case ClosestPoints:
                Obstacles obstacles = new Obstacles(n, rQueen, cQueen);

                for(int a0 = 0; a0 &lt; k; a0++) {
                int r = in.nextInt();
                int c = in.nextInt();

                obstacles.update(c, r);
            }

            obstacles.compute();
            break;

            case WithBoard:

                boolean[][] chessboard = new boolean[n][n];

                for(int a0 = 0; a0 &lt; k; a0++) {
                int r = in.nextInt();
                int c = in.nextInt();

                placeObstacle(n, chessboard, r, c);
            }

            display(chessboard, n);

            posCount(n, k, rQueen, cQueen, chessboard);

            break;
        }

        in.close();
    }
}
