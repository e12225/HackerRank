//https://www.hackerrank.com/challenges/time-conversion/problem
//
// Given a time in -hour AM/PM format, convert it to military (24-hour) time.
//
//        Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
//
//        Function Description
//
//        Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
//
//        timeConversion has the following parameter(s):
//
//        s: a string representing time in  hour format
//        Input Format
//
//        A single string  containing a time in -hour clock format (i.e.:  or ), where  and .
//
//        Constraints
//
//        All input times are valid
//        Output Format
//
//        Convert and print the given time in -hour format, where .
//
//        Sample Input 0
//
//        07:05:45PM
//        Sample Output 0
//
//        19:05:45

package com.company;

import java.util.Scanner;

public class Ten {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

    static String timeConversion(String s) {

        String[] parts = s.split(":");

        String eveningOrAfternoon = parts[2].substring(2); // process of substring is started from index = 2 of parts[2]

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2)); // seconds is separated from AM/PM using substring.

        String militaryHours;
        String militaryMinutes;
        String militarySeconds;

        if (eveningOrAfternoon.equals("AM") && hours == 12) {

            hours = 00;
        }
        if ((eveningOrAfternoon.equals("AM") && hours != 12) || (eveningOrAfternoon == "PM" && hours == 12)) {

            hours = hours + 0;

        }
        if (eveningOrAfternoon.equals("PM") && hours != 12) {

            hours = hours + 12;
        }

        if (hours < 10) {
            militaryHours = "0" + String.valueOf(hours);
        } else {
            militaryHours = String.valueOf(hours);
        }

        if (minutes < 10) {
            militaryMinutes = "0" + String.valueOf(minutes);
        } else {
            militaryMinutes = String.valueOf(minutes);
        }

        if (seconds < 10) {
            militarySeconds = "0" + String.valueOf(seconds);
        } else {
            militarySeconds = String.valueOf(seconds);
        }

        String militaryTime = militaryHours + ":" + militaryMinutes + ":" + militarySeconds;

        return militaryTime;
    }

}
