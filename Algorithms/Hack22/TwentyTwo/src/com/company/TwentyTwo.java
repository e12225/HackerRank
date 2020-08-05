//https://www.hackerrank.com/challenges/drawing-book/problem

package com.company;

import java.util.Scanner;

public class TwentyTwo
{
    static Integer solve( Integer n, Integer p )
    {
        Integer turns = 0;

        Integer[] visited_pages = new Integer[2];

        Integer forward_turns = forward( n, p, 1, visited_pages, turns );
        Integer backward_turns = backward( n, p, n, visited_pages, turns );

        return Math.min( forward_turns, backward_turns );
    }

    static Integer forward( Integer volume, Integer page, Integer start, Integer[] visitedP, Integer turns )
    {
        visitedP[0] = null;
        visitedP[1] = start; // start = 1, in this case

        if( volume % 2 != 0 )
        {
            if( visitedP[1].equals( page ) )
            {
                return turns;
            }
            else
            {
                turns++;
                visitedP[0] = start + 1;
                visitedP[1] = visitedP[0] + 1;

                while( visitedP[1] <= volume )
                {
                    if( visitedP[0].equals( page ) || visitedP[1].equals( page ) )
                    {
                        break;
                    }
                    else
                    {
                        turns++;
                        visitedP[0] = visitedP[0] + 2;
                        visitedP[1] = visitedP[0] + 1;
                    }
                }
            }
        }
        else
        {
            if( visitedP[1].equals( page ) )
            {
                return turns;
            }
            else
            {
                turns++;
                visitedP[0] = start + 1;
                visitedP[1] = visitedP[0] + 1;

                while( visitedP[0] <= volume )
                {
                    if( visitedP[0].equals( page ) || visitedP[1].equals( page ) )
                    {
                        break;
                    }
                    else
                    {
                        turns++;
                        visitedP[0] = visitedP[0] + 2;

                        if( visitedP[0].equals( volume ) )
                        {
                            visitedP[1] = null;
                        }
                        else
                        {
                            visitedP[1] = visitedP[0] + 1;
                        }
                    }
                }
            }
        }

        return turns;
    }

    static Integer backward( Integer volume, Integer page, Integer start, Integer[] visitedP, Integer turns )
    {
        if( volume % 2 != 0 )
        {
            visitedP[0] = start;
            visitedP[1] = start - 1;

            if( visitedP[0].equals( page ) || visitedP[1].equals( page ) )
            {
                return turns;
            }
            else
            {
                turns++;
                visitedP[0] = visitedP[0] - 2;
                visitedP[1] = visitedP[0] - 1;

                while( visitedP[0] >= 1 )
                {
                    if( visitedP[0].equals( page ) || visitedP[1].equals( page ) )
                    {
                        break;
                    }
                    else
                    {
                        turns++;
                        visitedP[0] = visitedP[0] - 2;

                        if( visitedP[0] == 1 )
                        {
                            visitedP[1] = null;
                        }
                        else
                        {
                            visitedP[1] = visitedP[0] - 1;
                        }
                    }
                }
            }
        }
        else
        {
            visitedP[0] = null;
            visitedP[1] = start;

            if( visitedP[1].equals( page ) )
            {
                return turns;
            }
            else
            {
                turns++;
                visitedP[0] = start - 1;
                visitedP[1] = visitedP[0] - 1;

                if(visitedP[0].equals( page ) || visitedP[1].equals( page ))
                {
                    return turns;
                }
                else
                {
                    turns++;
                    visitedP[0] = visitedP[0] - 2;
                    visitedP[1] = visitedP[0] - 1;

                    while( visitedP[0] >= 1 )
                    {
                        if( visitedP[0].equals( page ) || visitedP[1].equals( page ) )
                        {
                            break;
                        }
                        else
                        {
                            turns++;
                            visitedP[0] = visitedP[0] - 2;

                            if( visitedP[0] == 1 )
                            {
                                visitedP[1] = null;
                            }
                            else
                            {
                                visitedP[1] = visitedP[0] - 1;
                            }
                        }
                    }
                }
            }
        }
        return turns;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        Integer n = in.nextInt();
        Integer p = in.nextInt();
        Integer result = solve( n, p );
        System.out.println( result );
    }
}
