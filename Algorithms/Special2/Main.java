// problem : https://www.hackerrank.com/challenges/bomber-man/problem

package com.hack;

import java.util.*;

public class Main {

    public static String[][] generateResults(String[][] initialGrid, String[][] bombFilledGrid, int seconds, int rows, int columns) {

        String[][] currentGrid;
        currentGrid = bombFilledGrid;

        if (seconds == 1) {
//            since Bomberman does nothing after one second, the final grid will be the initial grid itself.
            return initialGrid;
        }
        if (seconds % 2 == 0) {
//            since Bomberman plants bombs in all cells without bombs after two second, the final grid will be the bomb filled grid.
            return bombFilledGrid;
        }

        currentGrid = detonateBombsAndSurroundingBombs(initialGrid, currentGrid, rows, columns);

        initialGrid = currentGrid; // new initial grid for the next round is the grid after detonating the bombs of the first grid.
        currentGrid = generateBombFilledGridForTheNextRound(rows, columns);

        if (seconds == 3) {
            return initialGrid;
        }

        currentGrid = detonateBombsAndSurroundingBombs(initialGrid, currentGrid, rows, columns);

        initialGrid = currentGrid; // new initial grid for the next round is the grid after detonating the bombs of the first grid.
        currentGrid = generateBombFilledGridForTheNextRound(rows, columns);

        if (((seconds - 3) / 2) % 2 != 0) {
            return initialGrid;
        }

        currentGrid = detonateBombsAndSurroundingBombs(initialGrid, currentGrid, rows, columns);

        initialGrid = currentGrid;

        return initialGrid;
    }

    public static String[][] detonateBombsAndSurroundingBombs(String[][] initialGrid, String[][] currentGrid, int rows, int columns) {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {

                if (initialGrid[r][c].equals("O")) {
                    currentGrid[r][c] = ".";

                    if (r - 1 >= 0) {
                        currentGrid[r - 1][c] = ".";
                    }
                    if (r + 1 < rows) {
                        currentGrid[r + 1][c] = ".";
                    }
                    if (c - 1 >= 0) {
                        currentGrid[r][c - 1] = ".";
                    }
                    if (c + 1 < columns) {
                        currentGrid[r][c + 1] = ".";
                    }
                }
            }
        }
        return currentGrid;
    }

    //      Planting bombs in all the cells for the next round.
    public static String[][] generateBombFilledGridForTheNextRound(int rows, int columns) {

        String[][] new_bombFilled_grid = new String[rows][columns];
        for (int r = 0; r < rows; r ++){
            for (int c = 0; c < columns; c ++) {
                new_bombFilled_grid[r][c] = "0";
            }
        }

        return new_bombFilled_grid;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the grid : ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the grid : ");
        int columns = scanner.nextInt();
        System.out.print("Enter the number of seconds to stimulate : ");
        int seconds = scanner.nextInt();

//        creating the grid according to the given inputs
        String[][] initialGrid = new String[rows][columns]; //starting grid
        String[][] bombFilledGrid = new String[rows][columns]; // grid after two seconds, where all the cells have bombs

//        taking inputs for cells (if there's a bomb, it's 0. if there's no bomb, it's .)
        for (int i = 0; i < rows; i++) {

            String cellInput = scanner.next();
            for (int j = 0; j < columns; j++) {
                initialGrid[i][j] = Character.toString(cellInput.charAt(j)); // populating the initial grid (user given grid)
                bombFilledGrid[i][j] = "O"; // populating the grid after two seconds, where all the cells have bombs
            }
        }

        String[][] results = generateResults(initialGrid, bombFilledGrid, seconds, rows, columns);

//        printing out the final state of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(results[i][j]);

            }
            System.out.println();
        }
    }
}
