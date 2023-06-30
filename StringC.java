import java.util.*;

public class StringC {

    public static void printAlphabet(){
        for(char ch = 'a'; ch <= 'z'; ch++){
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void printLatter(String fullname){
        for(int i = 0 ; i < fullname.length(); i++){
            System.out.print(fullname.charAt(i));
        }
        System.out.println();
    }

    public static boolean ispalindrome(String str){
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static float getShortespath(String path){
        int x = 0, y = 0;
        for(int i =0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                y++;
            }else if(path.charAt(i) == 'S'){
                y--;
            }else if(path.charAt(i) == 'W'){
                x--;
            }else if(path.charAt(i) == 'E'){
                x++;
            }
        }
        int x2 = x*x;
        int y2 = y*y;

        return (float) Math.sqrt(x2 + y2);
    }

    public static String subString(String str, int si, int ei){
        String SubString = "";
        for(int i = si; i < ei; i++){
            SubString += str.charAt(i);
        }
        return SubString;
    }

    public static String toUppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1; i <str.length();i++){
            if(str.charAt(i) == ' ' && i < str.length() -1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){
        //String newStr = "";
        // for(int i =0 ; i < str.length(); i++){
        //     Integer count = 1;
        //     while(i < str.length() -1 && str.charAt(i) == str.charAt(i+1)){
        //         count++;
        //         i++;
        //     }
        //     newStr += str.charAt(i);
        //     if(count > 1){
        //         newStr += count.toString();
        //     }
        // }
        // return newStr

        //Done by StringBuilder
        StringBuilder sb = new StringBuilder("");
        for(int i =0 ; i < str.length(); i++){
            Integer count = 1;
            while(i < str.length() -1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void isAnagrams(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){

            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            boolean result = Arrays.equals(str1charArray, str1charArray);

            if(result){// result == true
                System.out.println(str1 +" " + "and " + str2 + "are anagrams of each") ;
            }else{
                System.out.println(str1 +" " + "and " + str2 + "are NOT anagrams of each") ;
            }
        }else{
            System.out.println(str1 +" " + "and " + str2 + "are NOT anagrams of each") ;
        }
    }

    public static void main(String[] args) {
        // String str1 = "Tony Stark";
        // System.out.println(str1);

        // Scanner sc = new Scanner(System.in);

        // // String str2 = sc.next();
        // // System.out.println(str2); // print only 1st latter

        // // String str3 = sc.nextLine();
        // // System.out.println(str3); // print whole line

        // String str2 = " I'M IRONMAN.";

        // //Concatenate
        // // String who = str1 + " " + str2;
        // // System.out.println(who);

        // //Concatenate by in buid fuction
        // System.out.println(str1.concat(str2));

        // // charAt Method :- to know in index what the actuall value it carryn or iterate to whole string and know the value of every index
        // System.out.println(str1.charAt(1));

        // //print a to z alphabet
        // printAlphabet();

        // String fullName = "Shashi kumar chaurasiya";
        // printLatter(fullName);

        // String palindrome = "noon";
        // System.out.println(ispalindrome(palindrome));

        // String path = "WNEENESENNN";
        // System.out.println(getShortespath(path));

        // compare or immuted property 
        //here == don't work properly for String

        // String str1 = "Tony";
        // String str2 = "Tony";
        // String str3 = new String("Tony");

        // if(str1 == str2){
        //     System.out.println("String are equal"); // that's gona be print becouse both are ponting the same object or value
        // }else{
        //     System.out.println("String are NOT equal");
        // }

        // if(str1 == str3){
        //     System.out.println("String are equal");
        // }else{
        //     System.out.println("String are NOT equal"); // that's gona be print becouse we use new keyword that's create a new object in heap internal memory
        // }

        // // To sole == proble we use .equals() in string

        // if(str1.equals(str3)){
        //     System.out.println("String are equal"); // that's gona be print becouse now we actually capare the values or objects
        // }else{
        //     System.out.println("String are NOT equal");
        // }

        // String str = "Hello Word";
        // //System.out.println(subString(str, 0, 4)); // ei or ending index alway take +1 becouse of excluded part property

        // //Inbuid function for know substring or print substring
        // System.out.println(str.substring(0, 4)); 


        //for given set of string print the largest string

        // String fruits[] = {"apple", "mango", "banana"};
        // String largest = fruits[0];

        // for(int i = 1; i<fruits.length;i++){
        //     if(largest.compareTo(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);

        // //Impletation StringBuilder

        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a' ; ch < 'z'; ch++){ // T.C :- O(26) becouse we just changing ch , not copy in new object or create new object
        //     sb.append(ch);
        // }
        // System.out.print(sb);

        // // first charecter of every later capital
        // String str = "i am ironma.";
        // System.out.print(toUppercase(str)); // T.C :- O(N) here N is number of latter

        // W.A.P to compress the string
        // String str = "aaabbcccdd";
        // System.out.print(compress(str));

        // // how many time vovel ocure in string
        // String str = "hey i am tony stark. i am iron man.";
        // int count = 0;

        // for(int i = 0 ; i < str.length(); i++){
        //     char ch = str.charAt(i);
        //     if(ch == 'a' || ch == 'e' || ch ==  'i' || ch == 'o' || ch == 'u'){
        //         count++;
        //     }
        // }

        // System.out.println("vovel ocure in str is :- " + count);

        // //what is output of following code

        // String str = "Tony";
        // String str1 = "Stark";
        // String str2 = "Tony";

        // System.out.println(str.equals(str1) + " " + str.equals(str2));

        // //output the folloing code
        // String str = "Tony Tonya".replace("1", "");
        // System.out.println(str);

        // str = "Tony Tonya".replace("T", "P");
        // System.out.println(str);

        // String str1 = "Tony Tonya".replaceAll("T", "p");
        // System.out.println(str1);

        // String str2 = "Tony Tonya".replaceFirst("T", "L");
        // System.out.println(str2);

        // CharSequence str3 = "Tony Tonya".replace("T", "M");
        // System.out.println(str3);


        // String str2 = "Tony Tonya".replace(target, replacement)
        // System.out.println(str2);

        // //is anagrams
        // String str1 = "earth";
        // String str2 = "heart";

        // isAnagrams(str1, str2);

        //intern() - scp - String constant Pool

        String str = new String("hello");
        String str1 = new String("hello");
        
        if(str == str1){
            System.out.println("Strings are equaal");
        }else{
            System.out.println("Strings are NOT equaal");
        }

        // here both are pint the same memory heap 
        String str2 = new String("hello").intern();
        String str3 = new String("hello").intern();
        
        if(str2 == str3){
            System.out.println("Strings are equaal");
        }else{
            System.out.println("Strings are NOT equaal");
        }

        //StringBuffer
        StringBuffer sb = new StringBuffer("hello ");
        System.out.println(sb);
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            sb.append(ch);
        }
        System.out.println(sb);
        
        sb.toString();// converting StrinBuffer to String
        System.out.println(sb);
    }
}