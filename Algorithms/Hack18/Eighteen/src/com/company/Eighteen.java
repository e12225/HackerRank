//You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.
//
//        For example, assume your bird sightings are of types . There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type .
//
//        Function Description
//
//        Complete the migratoryBirds function in the editor below. It should return the lowest type number of the most frequently sighted bird.
//
//        migratoryBirds has the following parameter(s):
//
//        arr: an array of integers representing types of birds sighted
//        Input Format
//
//        The first line contains an integer denoting , the number of birds sighted and reported in the array .
//        The second line describes  as  space-separated integers representing the type numbers of each bird sighted.
//
//        Constraints
//
//        It is guaranteed that each type is , , , , or .
//        Output Format
//
//        Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.
//
//        Sample Input 0
//
//        6
//        1 4 4 4 5 3
//        Sample Output 0
//
//        4

package com.company;

import java.util.*;

public class Eighteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];

        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }

        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }

    static int migratoryBirds(int n, int[] ar) {

        int frequency = 1;

        HashMap<Integer, Integer> occurrence = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (ar[i] != 0) {

                for (int k = i + 1; k < n; k++) {

                    if (ar[i] == ar[k]) {
                        frequency++;
                        ar[k] = 0; // making it zero, to not to be detected again
                    }

                }
                occurrence.put(ar[i], frequency);
            }
            frequency = 1;
        }

        int maxFrequency = 1;
        int typeWithMaxFrequency;

        Collection frequencies = occurrence.values(); //extracting the value set separately from the Hash Map
        List<Integer> frq = new ArrayList(frequencies); //putting the value set to a List so we can check for the maximum

        for (int j = 0; j < frequencies.size(); j++) {

            if (frq.get(j) >= maxFrequency) {

                maxFrequency = frq.get(j);
            }
        }

        typeWithMaxFrequency = 5;

        for (int key : occurrence.keySet()) {

            if (occurrence.get(key).equals(maxFrequency) && key <= typeWithMaxFrequency) {

                typeWithMaxFrequency = key;

            }
        }

        return typeWithMaxFrequency;

    }
}
