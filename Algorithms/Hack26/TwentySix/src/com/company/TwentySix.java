package com.company;

import java.util.*;

public class TwentySix
{
    static int formingMagicSquare( int[][] s )
    {
        int minCost = 1000000000;
        List<int[][]> idealMagicSquareList = new ArrayList<>();

        int[][] idealMagicSquare_1 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        idealMagicSquareList.add( idealMagicSquare_1 );

        int[][] idealMagicSquare_2 = rotateLeft( idealMagicSquare_1 );
        idealMagicSquareList.add( idealMagicSquare_2 );

        int[][] idealMagicSquare_3 = rotateLeft( idealMagicSquare_2 );
        idealMagicSquareList.add( idealMagicSquare_3 );

        int[][] idealMagicSquare_4 = rotateLeft( idealMagicSquare_3 );
        idealMagicSquareList.add( idealMagicSquare_4 );

        int[][] idealMagicSquare_5 = mirror( idealMagicSquare_4 );
        idealMagicSquareList.add( idealMagicSquare_5 );

        int[][] idealMagicSquare_6 = rotateLeft( idealMagicSquare_5 );
        idealMagicSquareList.add( idealMagicSquare_6 );

        int[][] idealMagicSquare_7 = rotateLeft( idealMagicSquare_6 );
        idealMagicSquareList.add( idealMagicSquare_7 );

        int[][] idealMagicSquare_8 = rotateLeft( idealMagicSquare_7 );
        idealMagicSquareList.add( idealMagicSquare_8 );

        for( int i = 0; i < idealMagicSquareList.size(); i++ )
        {
            int cost = compareWithIdealMSquare( s, idealMagicSquareList.get( i ) );
            if( cost <= minCost )
            {
                minCost = cost;
            }
        }

        return minCost;
    }

    static int[][] rotateLeft( int[][] mSquare )
    {
        int[][] rotated = new int[3][3];
        int mSquareY = 2;
        for( int i = 0; i< 3; i++ )
        {
            for( int j = 0; j < 3; j++ )
            {
                rotated[i][j] = mSquare[j][mSquareY];
            }
            mSquareY --;
        }
        return rotated;
    }

    static int[][] mirror( int[][] mSquare )
    {
        int[][] mirrored = new int[3][3];
        int mSquareY = 2;
        for( int i = 0; i < 3; i++ )
        {
            for( int j = 0; j < 3; j++ )
            {
                mirrored[i][j] = mSquare[i][mSquareY];
                mSquareY --;
            }
            mSquareY = 2;
        }
        return mirrored;
    }

    static int compareWithIdealMSquare( int[][] givenSquare, int[][] idealMSquare )
    {
        int cost = 0;
        for( int i = 0; i < 3; i++ )
        {
            for( int j = 0; j < 3; j++ )
            {
                if( givenSquare[i][j] != idealMSquare[i][j] )
                {
                    if( givenSquare[i][j] > idealMSquare[i][j] )
                    {
                        cost = cost + ( givenSquare[i][j] - idealMSquare[i][j] );
                    }
                    else
                    {
                        cost = cost + ( idealMSquare[i][j] - givenSquare[i][j] );
                    }
                }
            }
        }
        return cost;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int[][] s = new int[3][3];
        for( int s_i = 0; s_i < 3; s_i++ )
        {
            for( int s_j = 0; s_j < 3; s_j++ )
            {
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare( s );
        System.out.println( result );
        in.close();
    }
}
