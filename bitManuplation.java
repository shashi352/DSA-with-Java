public class bitManuplation {

    public static void oddrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0 ){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }
    }

    public static int getIihBit(int n, int i){
        int bitMask = 1 << i; // To reverse ith place
        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int setIihBit(int n, int i){ // on ith position set it to 1(set)
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit){
        /* Approch 1 :- 
        if(newBit == 0){
            return clearIthBit(n, i);
        }else{
            return clearIthBit(n, i);
        }
        */
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastIthBit(int n, int i){
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int setLastIthBit(int n, int i){
        int bitMask = (0) | (1 << i);// in binary 0 :- 0 0 0 0 ,and (~0) :- 1 1 1 1 negative one
        n = ~(n | bitMask); // thats give us the negative value here we used 2's copliment
        return -n; // just convert it on positive
    }

    public static int clearBitinRange(int n, int i, int j){
        int a = ((~0)) << (j+1);
        int b = (1 << i) -1;
        int bitMask = a / b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n){
        return (n & (n -1)) == 0; // if true ti's mean it's power of two
    }

    public static int countSetBit(int n){
        int count = 0;
        while(n > 0){
            if( (n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n > 0){
            if((n & 1 )  != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n >>1;
        }
        return ans;
    }
    public static void main(String args[]){
        /* Foundamentals of bitmanipulation
        //AND (&) Operator
        System.out.println((5 & 6));

        //OR (|) operator
        System.out.println((5 | 6));

        //XOR (^)
        System.out.println((5^6));

        //Binary 1's Compliment  or Not operator
        System.out.println((~5)); // -6

        System.out.println((~0)); //-1 becouse in 2's compliment that convert negative no. 1 to positive no. 0

        //Left shift operator a << b o or 1 just shifted b places in left most element or most significant bit and fill the empty space with 0's
        System.out.println((5 << 2));// 20 // a << b == a * b ^ 2 in Math term

        //Right shift opeartor a >> b.
        System.out.println((6 >> 1));// 3

        */
        /* Check it's odd or Even number
        oddrEven(3);
        oddrEven(11);
        oddrEven(4);
        */

        /* Git ith bit 
        System.out.println(getIihBit(10, 2));
        */

        /* Set ith bit :- mean in ith position change the value and become 1 and print what the actually value got after change in turm of decimal
        System.out.println(setIihBit(10, 2));// 14
        */

        /* Clear on ith bit 
        System.out.print(clearIthBit(10, 1));// 8 after converting ith place with 0 the value i get I'am get 8 in term of decimal and in term of binary we got 1 0 0 0
        */

        /* Updating on ith bit we just change it maybe it's 1 or 0 we have to change it
        System.out.println(updateIthBit(10, 1, 0));// 8
        */

        //System.out.println(clearLastIthBit(15, 2)); // 12

        //ystem.out.println(setLastIthBit(10, 2)); // 15

        //System.out.println(clearBitinRange(10, 2, 4));

        // Check if a no. is power of 2 or not
        //System.out.println(isPowerOfTwo(4));

        //System.out.println(countSetBit(16));

        //Fast exponentiation :- a^n calculate in math by using bitmanipulation
        // System.out.print(fastExpo(3, 5));
    }
}
