// problem : https://www.hackerrank.com/challenges/bigger-is-greater/problem


package com.hack;

import java.util.*;

public class Main {

    static int ctr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i<testCases; i++){
            String word = in.next();
            System.out.println(generateOutput(word));
        }
        in.close();
    }

    public static String generateOutput(String word){

        String out = "";
        char[] charArray = word.toCharArray();

        int charArrayLength = charArray.length;
        int swap2 = 0;

        for (int i = charArrayLength-2; i>=0; i--){
            int index = i;
            char aChar = charArray[index];

            for (int j = index+1; j <= charArrayLength-1; j++){
                if (aChar < charArray[j]){ //checking if last char (charArray[j]) is greater than the second last char (aVal)
                    int swap1 = i;
                    ctr = i;
                    int local = i;
                    char base = 'a';
                    int cnt = 1;
                    for (int m = local+1; m < charArrayLength; m++){
                        if (charArray[m] > charArray[swap1] && charArray[m] < base || cnt == 1){
                            base = charArray[m];
                            swap2 = m;
                            cnt++;
                        }
                    }


                    //swapping the characters
                    char temp = charArray[swap1];
                    charArray[swap1] = charArray[swap2];
                    charArray[swap2] = temp;

                    for (char k:charArray){
                        out = out+k;
                    }
                    out = SubstringSort(out, ctr);
                    return out;
                }

            }
        }
        return "no answer";
    }

    public static String SubstringSort(String a, int ctr){

        String sub1 = a.substring(ctr+1, a.length());
        String sub2 = a.substring(0,ctr+1);
        char[] sub1Arr = sub1.toCharArray();
        String out = "";
        Arrays.sort(sub1Arr);

        for (char k:sub1Arr){
            out = out+k;
        }
        out = sub2+out;

        return out;
    }
}
