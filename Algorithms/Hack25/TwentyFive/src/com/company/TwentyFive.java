//https://www.hackerrank.com/challenges/cats-and-a-mouse/submissions/code/69331166

package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwentyFive
{
    static String catAndMouse( int x, int y, int z )
    {

        String winner = null;
        Integer diff_x = z - x;
        Integer diff_y = z - y;

        if( diff_x < 0 )
        {
            diff_x = diff_x * ( -1 );
        }
        if( diff_y < 0 )
        {
            diff_y = diff_y * ( -1 );
        }

        if( x == y || diff_x == diff_y )
        {
            winner = "Mouse C";
        }
        else if( diff_x > diff_y )
        {
            winner = "Cat B";
        }
        else if( diff_y > diff_x )
        {
            winner = "Cat A";
        }

        return winner;
    }

    private static final Scanner scan = new Scanner( System.in );

    public static void main( String[] args ) throws IOException
    {
        int q = Integer.parseInt( scan.nextLine().trim() );
        List<String> bww = new ArrayList<>();

        for( int qItr = 0; qItr < q; qItr++ )
        {
            String[] xyz = scan.nextLine().split( " " );

            int x = Integer.parseInt( xyz[0].trim() );

            int y = Integer.parseInt( xyz[1].trim() );

            int z = Integer.parseInt( xyz[2].trim() );

            String result = catAndMouse( x, y, z );
            bww.add( result );
        }
        for( int i = 0; i < bww.size(); i++ )
        {
            System.out.println( bww.get( i ) );
        }
    }
}
