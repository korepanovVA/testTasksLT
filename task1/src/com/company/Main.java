package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfElements = 0;
        numbersOfElements = scanner.nextInt();
        int intervalSize = 0;
        intervalSize = scanner.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 1;
        boolean flag = true;
        String result = "1";
        int temp = intervalSize;

        while(flag){
            arrayList.add(i);
            if(i == numbersOfElements){
                i = 1;
            }
            else
            {
                i++;
            }
            if(arrayList.size() == intervalSize ){
                if(arrayList.get(intervalSize - 1) == arrayList.get(0)){
                    break;
                }
                else{
                    result += arrayList.get(intervalSize - 1);
                    intervalSize += temp - 1;
                }
            }
        }
        System.out.println(result);

    }
}
