import java.util.*;

public class Main {
    public static void main(String[] args) {

        while(true){
            System.out.println("Enter your numbers : ");
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String inputNumber = scanner.nextLine();

            System.out.println("Enter K value : ");
            scanner = new Scanner(System.in);  // Create a Scanner object
            int k = scanner.nextInt();

            char[] arrInputNumber = inputNumber.toCharArray();
            boolean isOdd = arrInputNumber.length % 2 != 0;

            Object[] arrResult = solveHighestPalindrome(arrInputNumber, k, 0, isOdd );
            arrInputNumber = (char[])arrResult[0];
            k = (int)arrResult[1];

            if(k < 0) System.out.println(k);
            else {
                if(k>0 && isOdd ) arrInputNumber[arrInputNumber.length/2] = '9';
                System.out.println(String.valueOf(arrInputNumber));
            }

            System.out.println("\n");

        }
    }

    public static Object[] solveHighestPalindrome(char[] arrInputNumber, int k, int pos,boolean isOdd){
        Object[] arrReturn = new Object[2];

        if (k<0) {
            arrReturn[0] = arrInputNumber;
            arrReturn[1] = k;
            return arrReturn;
        }

        int pos1 = (arrInputNumber.length/2)-pos-1;
        int pos2 = isOdd ? (arrInputNumber.length/2)+pos+1 : (arrInputNumber.length/2)+pos;
        int number1 = arrInputNumber[pos1];
        int number2 = arrInputNumber[pos2];

        if(number1 != number2){
            if(number1>number2) arrInputNumber[pos2] = (char)number1;
            else arrInputNumber[pos1] = (char)number2;
            k--;
        }

        if(pos < arrInputNumber.length/2 - 1){
            arrReturn = solveHighestPalindrome(arrInputNumber,k,pos+1,isOdd);
            arrInputNumber = (char[])arrReturn[0];
            k = (int)arrReturn[1];
        }

        if(k>1 && arrInputNumber[pos1] != '9') {
            arrInputNumber[pos1] = '9';
            arrInputNumber[pos2] = '9';
            k -= 2;
        }

        arrReturn[0] = arrInputNumber;
        arrReturn[1] = k;
        return arrReturn;
    }
}