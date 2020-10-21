//Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test your understanding of formatting output using printf.
//
//        To get you started, a portion of the solution is provided for you in the editor; you must format and print the input to complete the solution.
//
//        Input Format
//
//        Every line of input will contain a String followed by an integer.
//        Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from  to .
//
//        Output Format
//
//        In each line of output there should be two columns:
//        The first column contains the String and is left justified using exactly  characters.
//        The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.
//
//        Sample Input
//
//        java 100
//        cpp 65
//        python 50
//        Sample Output
//
//        ================================
//        java           100
//        cpp            065
//        python         050
//        ================================

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
