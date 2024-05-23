import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static char[] arrInputBrackets;
    public static void main(String[] args) {
        while(true){
            System.out.println("\nEnter your brackets only allow ( , ) , { , } , atau [ , ] (white spaces are allowed) : ");
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String inputString = scanner.nextLine().replaceAll("\\s", "");
            if(inputString.equals("exit")) return;
            arrInputBrackets = inputString.toCharArray();

            if(solveBalancedBracket(new Stack(),0).size() > 0)  System.out.println("NO");
            else System.out.println("YES");
        }
    }

    public static Stack solveBalancedBracket(Stack listBracket, int ctr){
        if(ctr < arrInputBrackets.length) {
            if(arrInputBrackets[ctr] == '[' || arrInputBrackets[ctr] == '{' || arrInputBrackets[ctr] == '(' ){
                listBracket.push(arrInputBrackets[ctr]);
                return solveBalancedBracket(listBracket,ctr+1);
            }else{
                char closeBracket = (char) listBracket.pop();
                if( arrInputBrackets[ctr]==']' && closeBracket == '[' ||
                    arrInputBrackets[ctr]=='}' && closeBracket == '{' ||
                    arrInputBrackets[ctr]==')' && closeBracket == '(' )
                    return solveBalancedBracket(listBracket,ctr+1);
            }
        }
        return listBracket;
    }
}