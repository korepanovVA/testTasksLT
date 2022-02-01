package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader inputFiles = new FileReader("tests.json");
        Scanner scanner = new Scanner(inputFiles);
        ArrayList<String> dataInputTests = new ArrayList<>();

        while (scanner.hasNextLine()) {
            dataInputTests.add(scanner.nextLine());
        }
        inputFiles.close();

        inputFiles = new FileReader("values.json");
        scanner = new Scanner(inputFiles);
        ArrayList<String> dataInputValues = new ArrayList<>();

        while (scanner.hasNextLine()){
            dataInputValues.add(scanner.nextLine());
        }
        inputFiles.close();

        ArrayList<String> sortValuesInput = new ArrayList<>();
        ArrayList<String> sortTestsInput = new ArrayList<>();

        for(int i = 0; i < dataInputTests.size(); i++){
            sortTestsInput.add(dataInputTests.get(i).replaceAll("\\s",""));
        }

        for(int i = 2; i < dataInputValues.size() - 1;i = i + 3){
            sortValuesInput.add(dataInputValues.get(i).replaceAll("\\s+",""));
            sortValuesInput.add(dataInputValues.get(i+1).replaceAll("\\s+",""));
        }

        //int j = 0;
        for(int i = 0; i < sortTestsInput.size(); i++){
            for(int j = 0; j < sortValuesInput.size(); j+=2) {
                if (sortTestsInput.get(i).equals(sortValuesInput.get(j))) {
                    sortTestsInput.set(i + 2, sortValuesInput.get(j + 1));
                }
            }
        }

        FileWriter writerReport = new FileWriter("report.json");
        for(int i = 0; i < sortTestsInput.size(); i++) {
            if(sortTestsInput.get(i).equals("},{")){
                writerReport.write("\n");
            }
            if(sortTestsInput.get(i).equals("[{")){
                writerReport.write("\n");
            }

            writerReport.write(sortTestsInput.get(i) + " ");
        }
        writerReport.close();
    }
}
