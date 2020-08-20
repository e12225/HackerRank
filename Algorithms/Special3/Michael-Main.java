
package com.hack;

import basic.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class Main {

    static void loop(int maxi, int maxj, BiConsumer<Integer, Integer> func) {
        for (int i = 0; i < maxi; i++) {
            for (int j = 0; j < maxj; j++) {
                func.accept(i, j);
            }
        }
    }

    static int rows;
    static int columns;

    static boolean[][] g;

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        rows = grid.length;
        columns = grid[0].length();
        g = new boolean[rows][columns];
        loop(rows, columns, (i, j) -> {
            g[i][j] = grid[i].charAt(j) == 'G';
        });

        AtomicInteger max = new AtomicInteger(0);
        loop(rows, columns, (i, j) -> {
            Plus firstPlus = new Plus(i, j, 0);
            while (firstPlus.isValid()) {
                loop(rows, columns, (x, y) -> {
                    Plus secondPlus = new Plus(x, y, 0);
                    while (secondPlus.isValid()) {
                        if (!firstPlus.overlapsWith(secondPlus)) {
                            int product = (firstPlus.size*4+1)*(secondPlus.size*4+1);
                            if (product > max.get()) {
                                max.set(product);
                            }
                        }
                        secondPlus.size++;
                    }
                });
                firstPlus.size++;
            }
        });

        return max.get();
    }

    static class Plus {
        public int row;
        public int column;
        public int size;

        public Plus(final int row, final int column, final int size) {
            this.row = row;
            this.column = column;
            this.size = size;
        }

        public boolean isValid() {
            for (int i = 0; i <= size; i++) {
                if (row - i < 0 || row + i >= rows
                        || column - i < 0 || column +i >= columns
                        || !g[row - i][column]
                        || !g[row + i][column]
                        || !g[row][column - i]
                        || !g[row][column + i]
                ) {
                    return false;
                }
            }
            return true;
        }

        public boolean overlapsWith(Plus other) {
            int rd = Math.abs(other.row - row);
            int cd = Math.abs(other.column - column);
            int sum = other.size + size;

            if (row == other.row) return rd <= sum;
            if (column == other.column) return cd <= sum;

            int maxSize = Math.max(other.size, size);
            int minSize = Math.min(other.size, size);
            int maxDist = Math.max(rd, cd);
            int minDist = Math.min(rd, cd);

            return maxDist <= maxSize && minDist <= minSize;

        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ValidPlus> validPluses = new ArrayList<>();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        sc.close();

        // We save all the valid pluses
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char currentCell = map[i][j];
                if (currentCell == 'G') {
                    boolean thereIsGoodCell = true;
                    // Everytime we find a good cell, we create a valid plus with length 1 (i.e, area = 1)
                    ValidPlus validPlus = new ValidPlus();
                    int length = 1;
                    validPlus.addCell(new Cell(i, j));
                    validPluses.add(validPlus);
                    while (thereIsGoodCell) {
                        // We check if it's possible to extend the valid plus in all the four directions
                        if ((i - length >= 0 && map[i - length][j] == 'G')
                                && (i + length < n && map[i + length][j] == 'G')
                                && (j - length >= 0 && map[i][j - length] == 'G')
                                && (j + length < m && map[i][j + length] == 'G')) {
                            // If it's possible, we create a new valid plus
                            ValidPlus newValidPlus = new ValidPlus(validPlus);
                            newValidPlus.addCell(new Cell(i - length, j));
                            newValidPlus.addCell(new Cell(i + length, j));
                            newValidPlus.addCell(new Cell(i, j - length));
                            newValidPlus.addCell(new Cell(i, j + length));
                            length++;
//                            calculating the new valid plus area
                            newValidPlus.area = 1 + (4 * (length - 1));
                            newValidPlus.length = length;
                            validPluses.add(newValidPlus);
                            validPlus = new ValidPlus(newValidPlus);
                        } else {
                            thereIsGoodCell = false;
                        }
                    }

                }
            }
        }

        int maxArea = 0;

        // We compare all the valid pluses
        for (int i = 0; i < validPluses.size(); i++) {
            ValidPlus currentValidPlus = validPluses.get(i);
            for (int j = i + 1; j < validPluses.size(); j++) {
                ValidPlus otherValidPlus = validPluses.get(j);
                int currentArea = currentValidPlus.area * otherValidPlus.area;
                if (currentArea > maxArea) {
                    // If we have found a new max area, we have to check that the valid pluses don't overlap.
                    // To do this, we get the cells occupied by the two valid pluses
                    ArrayList<Cell> currentCells = currentValidPlus.cells;
                    ArrayList<Cell> otherCells = otherValidPlus.cells;
                    List<Cell> commonCells = new ArrayList<Cell>(currentCells);
                    commonCells.retainAll(otherCells);
                    // If the valid pluses don't have common cells, it's OK
                    if (commonCells.size() == 0) {
                        maxArea = currentArea;
                    }
                }

            }
        }

        System.out.println(maxArea);

    }

}