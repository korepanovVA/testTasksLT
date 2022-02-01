package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        FileReader inputFile = new FileReader("file.txt");
        Scanner scanner = new Scanner(inputFile);
        ArrayList<Integer> dataInputFile = new ArrayList<>();

        while(scanner.hasNextLine()) {
            dataInputFile.add(scanner.nextInt());
        }
        inputFile.close();

        Collections.sort(dataInputFile);

        int median = 0;
        int posForEvenA = dataInputFile.size() / 2 - 1;
        int posForEvenB = dataInputFile.size() / 2;
        int posForOdd = dataInputFile.size() / 2;
        if (dataInputFile.size() % 2 == 1){
            median = dataInputFile.get(posForOdd);
        }
        else
        {
            median = (dataInputFile.get(posForEvenA) + dataInputFile.get(posForEvenB)) / 2;
        }

        int result = 0;
        for(int i = 0; i < dataInputFile.size(); i++){
            result += Math.abs(median - dataInputFile.get(i));
        }
        System.out.println(result);
    }
}
