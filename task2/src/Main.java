import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader inputFile = new FileReader(args[0]);
        Scanner scanner = new Scanner(inputFile);
        ArrayList<Integer> dataInputFile1 = new ArrayList<>();

        while(scanner.hasNextLine()) {
            dataInputFile1.add(scanner.nextInt());
        }
        inputFile.close();

        inputFile = new FileReader(args[1]);
        scanner = new Scanner(inputFile);
        ArrayList<Integer> dataInputFile2 = new ArrayList<>();

        while (scanner.hasNextLine()){
            dataInputFile2.add(scanner.nextInt());
        }
        inputFile.close();

        for(int i = 0; i < dataInputFile2.size() - 1; i += 2){
            double coordByX = Math.pow(dataInputFile1.get(0) - dataInputFile2.get(i), 2);
            double coordByY = Math.pow(dataInputFile1.get(1) - dataInputFile2.get(i+1), 2);
            double centerToPoint = Math.sqrt(coordByX + coordByY);
            if(centerToPoint > dataInputFile1.get(2)){
                System.out.print(2 + "\n");
            }
            else if(centerToPoint < dataInputFile1.get(2)){
                System.out.print(1 + "\n");
            }
            else if(centerToPoint == dataInputFile1.get(2)){
                System.out.print(0 + "\n");
            }
        }
    }

}