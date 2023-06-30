import java.lang.annotation.Retention;
import java.util.*;
public class Recursion {
    
    public static void printDecre(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecre(n-1);
    }

    public static void printIncre(int n){
        if(n == 0){
            return;
        }
        printIncre(n-1);
        System.out.println(n);
    }

    public static int fact(int n){
        if(n == 0) return 1;
        int fnm1 = fact(n - 1);
        int fn = n * fact(n-1);
        return fn;
        //return (n * fact(n - 1));
    }

    public static int calSum(int n){
        if(n == 0) return 0;
        int snm1 = calSum(n - 1);
        int sm = n + snm1;
        return sm;
        //return  n + calSum(n - 1);
    }

    public static int fib(int n){
        if(n == 0 || n ==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
        //return fib(n - 1) + fib(n - 2);
    }

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length -1){
            return true;
        }

        if(arr[i] > arr[i+ 1]){
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i){
        if(i == arr.length) return -1;
        if(arr[i] == key){
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurence(int arr[], int key, int i){
        if(i == arr.length) return -1;
        int isFound = lastOccurence(arr, key, i+ 1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int pow(int x, int n){
        if(n == 0){
            return 1;
        }
        // int xnm1 = pow(x, n-1);
        // int xn = x * xnm1;
        // return xn; 
        return x * pow(x, n-1);

        //Optimized approch

    }
    //Optimized approch

    public static int optimizedPower(int a, int n){
        if(n == 0) return 1;

        int halfPower = optimizedPower(a, n/2) * optimizedPower(a, n/2);
        if(n % 2 == 0){
            halfPower = a * halfPower;
        }
        return halfPower;

        // int halfPower = optimizedPower(a, n/2);
        // int halfPowersq = halfPower * halfPower;

        // if(n % 2 == 0){
        //     halfPowersq = a * halfPowersq;
        // }

        // return halfPowersq;
    }

    public static int tillingProblem(int n){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        //kaam
        //Vertical choice 
        int fnm1 = tillingProblem(n - 1);

        //Horizontal choice
        int fnm2 = tillingProblem(n - 2);
        int totway = fnm1 + fnm2;
        return totway;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newstr, boolean map[]){
        if(idx == str.length()) {
            System.out.println(newstr);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            removeDuplicates(str, idx+1, newstr, map);
        }else{
            map[currChar = 'a'] = true;
            removeDuplicates(str, idx + 1, newstr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        //Base Case
        if(n == 1 || n == 2){
            return n;
        }

        //choice 
        //single
        int fnm1 = friendsPairing(n -1);

        //pair
        int fnm2 = friendsPairing(n - 2);
        int pairways = (n -1 ) * fnm2;

        int totway = fnm1 + pairways;
        return totway;
    }

    public static void printBinaryString(int n, int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }

        //Kaam
        if(lastPlace == 0){
            printBinaryString(n - 1, 0, str+"0");
            printBinaryString(n - 1, 1, str+"1");
        }else{
            printBinaryString(n - 1, 0, str+"0");
        }



        // printBinaryString(n - 1, 0, str+"0");
        // if(lastPlace == 0){
        //     printBinaryString(n - 1, 1, str+"1");
        // }
    }

    public static void occurrences(int arr[], int key, int idx){

        if(arr.length == idx){
            return;
        }
        if(arr[idx] == key){
            System.out.print(idx + " ");
        }
        occurrences(arr, key, idx + 1);
    }

    static String strNumber[] = {"Zero", "one", "Two", "Three", "four", "five", "six", "seven", "eight", "nine"};
    public static void printDigit(int number){
        if(number == 0){
            return;
        }
        int lastDigit = number%10;
        number = number / 10;
        printDigit(number);
        System.out.print(strNumber[lastDigit] + " ");
    }

    public static int length(String str){
        // Declare base case Approch 1 in string
        // if(str.length() == 0){ 
        //     return 0;
        // }

        // Declare base case Approch 2 in string
        if(str == ""){
            return 0;
        }
        int len = length(str.substring(1)) + 1;
        return len;
    }

    public static int countSubstrs(String str, int i, int j, int n){
        if(n == 1){
            return 1;
        }

        if(n <= 0){
            return 0;
        }

        int res = countSubstrs(str, i + 1, j, n-1) + countSubstrs(str, i, j-1, n-1) - countSubstrs(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)){
            res++;
        }

        return res;
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Transfer to" + n + "from" + src + "to" + dest );
            return;
        }

        //Transfer top n-1 from src to helper using dest as 'helper'

        towerOfHanoi(n - 1, src, dest, helper);

        //Transfer nth from src to dest

        System.out.println("Transfer to " + n + " from " + src + " to " + helper );

        //Transfer n-1 from helper to dest using src as 'helper'

        towerOfHanoi(n - 1, helper, src, dest);
    }
    
    
    
    public static void main(String[] args) {
        //printDecre(5);

        //printIncre(5);

        //System.out.println(fact(5));

        //System.out.println(calSum(5));


        //System.out.println(fib(5));

        // int arr[] = {1, 2, 3, 4};
        // System.out.println(isSorted(arr, 0));

        //int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        //System.out.println(firstOccurence(arr, 5, 0));

        // System.out.println(lastOccurence(arr, 5, 0));

        // System.err.println(pow(2, 10));

        // System.out.println(optimizedPower(2, 5));

        //System.out.println(tillingProblem(4));

        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        //System.out.println(friendsPairing(3));

        // printBinaryString(3, 0, "");


        //Practies Question
        //Find all the occurrences
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // int key = 2;
        // occurrences(arr, key, 0);

        // Conver number into english alphabet number
        // int number = 1234;
        // System.out.print(number + " :- ");
        // printDigit(number);

        // length of String
        //String str = "1234";
        //System.out.println(str.substring(1));
        //System.out.println(length(str));

        // Count the number of substring who's starting and enging point are same
        // String str = "aba";
        // String str = "abcab";
        // int n = str.length();
        // System.out.println(countSubstrs(str, 0, n-1, n));


        //Tower Of Hanoi
        // int n = 4;
        // towerOfHanoi(n, "A", "B", "C");
        
        

    }
}
