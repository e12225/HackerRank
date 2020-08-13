// problem : https://www.hackerrank.com/challenges/bomber-man/problem

package com.hack;

import basic.ShortScratch;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        bomberMan(9, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."});
        bomberMan(9, new String[]{".......", "...O.O.", "....O..", "..O....", "OO...OO", "OO.O..."});
    }

    static ArrayList<ShortScratch.State> pastState = new ArrayList<>();
    public static String[] bomberMan(int n, String[] grid) {
        pastState.clear();

        for (int time = 0; time <= n; time++) {
            ShortScratch.State bomb = null;
            if (time == 0) {
                bomb = new ShortScratch.State(grid);
            } else if (time == 1) {
                bomb = new ShortScratch.State(pastState.get(0));
            } else if (time%2 == 0) {
                bomb = pastState.get(time - 1).plant(time);
            } else if (time%2 == 1) {
                bomb = pastState.get(time - 1).explode(time);
            }
            pastState.add(bomb);

            // Check for stateCycles
            for (int i = 5; i < pastState.size() - 2; i++) {
                if (bomb.sameAs(pastState.get(i), i, time)) {
                    int cycleLength = time - i;
                    int adjustedTime = n;
                    while (adjustedTime >= pastState.size()) adjustedTime -= cycleLength;
                    return pastState.get(adjustedTime).toStringArray();
                }
            }

            dump(time);
        }


        ShortScratch.State finalState = pastState.get(pastState.size() - 1);
        return finalState.toStringArray();
    }

    static void dump(int time) {
        System.out.println("--- "+time+" ---");
        ShortScratch.State bomb = pastState.get(time);
        for (int i = 0; i < bomb.dimension1; i++) {
            for (int j = 0; j < bomb.dimension2; j++) {
                if (bomb.slots[i][j].bombIsPresent) {
                    System.out.print(bomb.slots[i][j].placementTime);
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    static class State {
        public int dimension1, dimension2;
        public ShortScratch.State.Slot[][] slots;

        static class Slot {
            public boolean bombIsPresent;
            public int placementTime;
        }

        public State(String[] input) {
            dimension1 = input.length;
            dimension2 = input[0].length();
            slots = new ShortScratch.State.Slot[dimension1][dimension2];
            for (int i = 0; i < dimension1; i++) {
                for (int j = 0; j < dimension2; j++) {
                    ShortScratch.State.Slot slot = new ShortScratch.State.Slot();
                    slot.bombIsPresent = input[i].charAt(j) == 'O';
                    slot.placementTime = 0;
                    slots[i][j] = slot;
                }
            }
        }

        public State(ShortScratch.State input) {
            dimension1 = input.dimension1;
            dimension2 = input.dimension2;
            slots = new ShortScratch.State.Slot[dimension1][dimension2];
            for (int i = 0; i < dimension1; i++) {
                for (int j = 0; j < dimension2; j++) {
                    ShortScratch.State.Slot slot = new ShortScratch.State.Slot();
                    slot.bombIsPresent = input.slots[i][j].bombIsPresent;
                    slot.placementTime = input.slots[i][j].placementTime;
                    slots[i][j] = slot;
                }
            }
        }

        public ShortScratch.State plant(int time) {
            ShortScratch.State newState = new ShortScratch.State(this);
            for (int i = 0; i < newState.dimension1; i++) {
                for (int j = 0; j < newState.dimension2; j++) {
                    if (!newState.slots[i][j].bombIsPresent) {
                        newState.slots[i][j].bombIsPresent = true;
                        newState.slots[i][j].placementTime = time;
                    }
                }
            }
            return newState;
        }

        public ShortScratch.State explode(int time) {
            ShortScratch.State newState = new ShortScratch.State(this);
            for (int i = 0; i < this.dimension1; i++) {
                for (int j = 0; j < this.dimension2; j++) {
                    if (this.slots[i][j].bombIsPresent && this.slots[i][j].placementTime == time - 3) {
                        newState.slots[i][j].bombIsPresent = false;
                        newState.slots[i][j].placementTime = time;
                        if (i > 0) newState.slots[i-1][j].bombIsPresent = false;
                        if (j > 0) newState.slots[i][j-1].bombIsPresent = false;
                        if (i < this.dimension1 - 1) newState.slots[i+1][j].bombIsPresent = false;
                        if (j < this.dimension2 - 1) newState.slots[i][j+1].bombIsPresent = false;
                    }
                }
            }
            return newState;
        }

        public boolean sameAs(ShortScratch.State other, int otherTime, int time) {
            for (int i = 0; i < dimension1; i++) {
                for (int j = 0; j < this.dimension2; j++) {
                    if (other.slots[i][j].bombIsPresent != this.slots[i][j].bombIsPresent
                            || other.slots[i][j].placementTime - otherTime != this.slots[i][j].placementTime - time) {
                        return false;
                    }
                }
            }
            return true;
        }

        public String[] toStringArray() {
            String[] ret = new String[this.dimension1];
            for (int i = 0; i < ret.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < this.dimension2; j++) {
                    sb.append(this.slots[i][j].bombIsPresent ? 'O' : '.');
                }
                ret[i] = sb.toString();
            }

            return ret;
        }

    }

}
