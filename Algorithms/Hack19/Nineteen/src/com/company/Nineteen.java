//Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the  day of the year) during a year in the inclusive range from  to .
//
//        From  to , Russia's official calendar was the Julian calendar; since  they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in , when the next day after January  was February . This means that in , February  was the  day of the year in Russia.
//
//        In both calendar systems, February is the only month with a variable amount of days; it has  days during a leap year, and  days during all other years. In the Julian calendar, leap years are divisible by ; in the Gregorian calendar, leap years are either of the following:
//
//        Divisible by .
//        Divisible by  and not divisible by .
//        Given a year, , find the date of the  day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .
//
//        For example, the given .  is divisible by , so it is a leap year. The  day of a leap year after  is September 12, so the answer is .
//
//        Function Description
//
//        Complete the dayOfProgrammer function in the editor below. It should return a string representing the date of the  day of the year given.
//
//        dayOfProgrammer has the following parameter(s):
//
//        year: an integer
//        Input Format
//
//        A single integer denoting year .
//
//        Constraints
//
//        Output Format
//
//        Print the full date of Day of the Programmer during year  in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .
//
//        Sample Input 0
//
//        2017
//        Sample Output 0
//
//        13.09.2017

package com.company;

import java.util.*;

public class Nineteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int year = in.nextInt();

        String result = solve(year);
        System.out.println(result);
    }

    static String solve(int year) {

        int programmersDay = 256;

        HashMap<Integer, Integer> monthsAndDays = new HashMap<>();
        monthsAndDays.put(1, 31); //January
        monthsAndDays.put(2, 28); //February
        monthsAndDays.put(3, 31); //March
        monthsAndDays.put(4, 30); //April
        monthsAndDays.put(5, 31); //May
        monthsAndDays.put(6, 30); //June
        monthsAndDays.put(7, 31); //July
        monthsAndDays.put(8, 31); //August
        monthsAndDays.put(9, 30); //September
        monthsAndDays.put(10, 31); //October
        monthsAndDays.put(11, 30); //November
        monthsAndDays.put(12, 31); //December

        int dayCount = 0;
        int year_ = 0;
        int month_ = 0;
        int day_ = 0;

        //First checking it is a Gregorian year or a Julian year

        if (1700 <= year && year <= 1917) {
            //Julian year > checking for a leap year
            if (year % 4 == 0) { //leap year
                monthsAndDays.put(2, 29);
            }
        } else if (1919 <= year && year <= 2700) {
            //Gregorian year > checking for a leap year
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) { //leap year
                monthsAndDays.put(2, 29);
            }
        } else if (year == 1918) { //Not a leap year
            //year = 1918
            monthsAndDays.put(2, 15);
        } else {

        }

        Collection daysInMonths = monthsAndDays.values();
        List<Integer> daysInMonths_ = new ArrayList(daysInMonths); //Extracting the days

        Set<Integer> Months = monthsAndDays.keySet();
        List<Integer> months_ = new ArrayList(Months); //Extracting the months

        int i = 0;
        while (dayCount <= programmersDay) {
            dayCount = dayCount + daysInMonths_.get(i);
            i++;
        }

        if (dayCount == programmersDay) {
            i--; //because 'i' is increased byb one at the end of the loop above
            year_ = year;
            month_ = months_.get(i);
            day_ = daysInMonths_.get(i);
        } else {
            i--;
            dayCount = dayCount - daysInMonths_.get(i);
            year_ = year;
            month_ = months_.get(i);
            day_ = 256 - dayCount;
        }

        if (day_ < 10 && month_ < 10) {
            String date = "0" + day_ + "." + "0" + month_ + "." + year_;
            return date;
        } else if (day_ < 10) {
            String date = "0" + day_ + "." + month_ + "." + year_;
            return date;
        } else if (month_ < 10) {
            String date = day_ + "." + "0" + month_ + "." + year_;
            return date;
        } else {
            String date = day_ + "." + month_ + "." + year_;
            return date;
        }
    }
}
