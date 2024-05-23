import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter your input string (Ex. abbcccd) : ");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String inputString = scanner.nextLine();
        System.out.println("Enter your queries (Ex. 1,3,9,8) : ");
        scanner = new Scanner(System.in);
        String inputNumbers = scanner.nextLine();

        solveWeightedStrings(inputString,inputNumbers);

    }

    public static void solveWeightedStrings(String inputString, String inputNumbers){
        char[] arrCharInputString = inputString.toCharArray();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<String,Integer> mapInputNumbers = new HashMap<String,Integer>();

        int ctr = 0;
        for(String keyValue : inputNumbers.split(",")) {
            mapInputNumbers.put(keyValue,ctr);
            ctr++;
        }

        String[] answerNumbers = new String[ctr];
        Arrays.fill(answerNumbers,"NO");

        for(int i = 0 ; i < arrCharInputString.length;i++){
            int charDataAscii = (int)arrCharInputString[i] - 96;
            int totalDataAscii = map.containsKey(charDataAscii) ? map.get(charDataAscii)+1 : 1;

            map.put(charDataAscii,totalDataAscii);
            String multipleDataAscii = String.valueOf(charDataAscii * totalDataAscii) ;

            if(mapInputNumbers.containsKey(multipleDataAscii)){
                answerNumbers[mapInputNumbers.get(multipleDataAscii)] = "YES";
                mapInputNumbers.remove(charDataAscii);
            }
        }

        System.out.println(Arrays.toString(answerNumbers));

    }
}