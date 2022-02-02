import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int numbersOfElements = Integer.parseInt(args[0]);
        int intervalSize = Integer.parseInt(args[1]);

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