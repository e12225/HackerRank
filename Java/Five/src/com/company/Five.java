package com.company;

import java.util.Scanner;

public class Five {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();

        String[] firstSplitWord = first.split("\\s");
        String[] secondSplitWord = second.split("\\s");
        String[] thirdSplitWord = third.split("\\s");

        String[] wordsArray = {firstSplitWord[0], secondSplitWord[0], thirdSplitWord[0]};
        String[] numbersArray = {
                firstSplitWord[firstSplitWord.length - 1],
                secondSplitWord[secondSplitWord.length - 1],
                thirdSplitWord[thirdSplitWord.length - 1]
        };

        for (int i = 0; i < wordsArray.length; i++) {

            int spaceAmount = 15 - wordsArray[i].length();

            for (int sCount = 1; sCount <= spaceAmount; sCount++) {
                wordsArray[i] = wordsArray[i].concat(" ");
            }
        }

        for (int j = 0; j < numbersArray.length; j++) {

            int zeroAmount = 3 - numbersArray[j].length();

            if (zeroAmount == 2) {
                numbersArray[j] = "00" + numbersArray[j];
            } else if (zeroAmount == 1) {
                numbersArray[j] = "0" + numbersArray[j];
            } else {

            }
        }

        System.out.println("================================");
        System.out.println(wordsArray[0] + numbersArray[0]);
        System.out.println(wordsArray[1] + numbersArray[1]);
        System.out.println(wordsArray[2] + numbersArray[2]);
        System.out.println("================================");
    }
}
