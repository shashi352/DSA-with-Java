import java.util.Scanner;

public class Method{
    
    public static int sum(int a, int b, int c){ // formal parameter
        int sum = (a + b + c)/ 3;
        return sum;
    }

    public static boolean isEven(int num){
        if(num % 2 == 0 ) return true;
        return false;
    }

    public static boolean isPalindrome(int num){
        int rev = 0;
        int num_copy = num;
        while(num_copy > 0){
            int rem = num_copy % 10;
            rev = rev * 10 + rem;
            num_copy = num_copy / 10;
        } 

        if (num == rev){
            return true;
        }
        return false;
    }

    public static int sum_last(int num){
        int sum_lastDigit = 0;
        while( num > 0){
            int rem = num % 10;
            sum_lastDigit += rem;
            num = num / 10;
        }
        return sum_lastDigit;
    }

    //for printing the range prime numbers use this as a helper fucttion
    public static boolean isPrime(int num){
        if( num == 2) return true;
        
        //for(int i = 2 ; i <= num - 1; i++){
        for(int i = 2 ; i <= Math.sqrt(num); i++){ // optimized
            if( num % i == 0) return false;
        }
        return true;
    }

    public static void printPrimeRange(int num){
        for(int i = 2; i <= num; i++){
            if(isPrime(i)) System.out.print(i + " ");
        }
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        /* Average of int 3 numers 
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(sum(a, b, c)); // actual argument
        */

        /*Check the numbers are even or false 
        int num = sc.nextInt();

        System.out.println(isEven(num));
        */


        /* chrck number is palindome or not
        System.out.println(isPalindrome(127651));
        */

        /* sum of last digt 
        System.out.println(sum_last(10887));
        */
        /* Check prime numbers 
        int num = sc.nextInt();
        System.out.println(isPrime(num));
        */

        int num = sc.nextInt();
        printPrimeRange(num);

    }
}