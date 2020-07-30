package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("File path");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
