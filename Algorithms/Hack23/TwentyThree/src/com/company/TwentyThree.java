package com.company;

import java.util.Scanner;

public class TwentyThree {

    static int countingValleys(int n, String s) {

        int valleys = 0;
        int current_position = 0;

        char[] sequence = s.toCharArray();

        for( int i = 0; i < n; i++ )
        {
            if( sequence[i] == 'U' )
            {
                current_position++;
            }
            else if( sequence[i] == 'D')
            {
                if( current_position == 0 )
                {
                    valleys ++;
                }

                current_position--;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
