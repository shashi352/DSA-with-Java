import java.util.*;

import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.Line;
import javax.swing.plaf.synth.SynthLookAndFeel;

/* Golden rules for printing a stars
 1. how many line i have to print. it's our row or lines or n started from i denotins
 2. how many starts i have to print. it's our col . denoted by j
 3. print stars ("*")

 */

 // BASIC TO ADVANCE PATTERN PROBLES ANS SOLUTIONS

public class Pattern{

    public static void main(String[] args){
          
        Scanner sc = new Scanner(System.in);
        /*
            ****
            *** 
            **  
            *   
         
        for(int lines = 1 ; lines <=4; lines++){
            for(int star = 1 ; star <= 4 - lines + 1; star++){
                System.out.print("*");
            }
            System.out.println();
        }
        */
        /*
            *
            **      
            *** 
            ****
         
        for(int i = 1; i <= 4;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }System.out.println();
            
        }
        */

        /*
            1
            12  
            123 
            1234
         
        for(int i = 1; i <=4;i++){
            for(int j = 1; j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        */

        /*
            A
            BC
            DEF
            GHIJ
        
        char cha='A';
        for(int i = 1; i <= 4; i++){
            for(int j=1;j<=i;j++){
                System.out.print(cha);
                cha++;
            }
            System.out.println();
        }
        */


        /* Hollow Rectangle
            *****
            *   *
            *   *
            *****
         
        int row = 4;
        int col = 5;
        for(int i=1;i <= row; i++){
            for(int j= 1;j <= col; j++){
                if( i == 1 || i == row || j == 1 || j == col){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
           System.out.println();
        }
        */

        /* INVERTED & ROTATED HALF=PYRAMID pattern
            *
            **
            ***
            ****
        
         

         int n = 4;
         for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
         }
         */

         /* INVERTED & HALF=PYRAMID With Numbers pattern
          12345
          1234
          123
          12
          1
          int n = 5;
          for(int Lines = 1;Lines<=n;Lines++){

            for(int j = 1; j <= n - Lines + 1 ; j++){
                System.out.print(j);
            }System.out.println();
          }
        */

        /* FLOYD'S Triangle pattern
            1 
            2 3
            4 5 6
            7 8 9 10       
            11 12 13 14 15
        
         
        int n = 5;
        int count = 1;
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
        */

        /* 0 - 1 Triangle pattern
            1 
            0 1       
            1 0 1     
            0 1 0 1   
            1 0 1 0 1
         
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i;j++){
                if((i+j) % 2 == 0){
                    System.out.print("1" + " ");
                }else{
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
        */

        /* BUTTERFLY pattern
            *      *
            **    **
            ***  ***
            ********
            ********
            ***  ***
            **    **
            *      *
         

        int n = 4;
        // 1 half butterfly
        for(int i =1; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2 *(n-i); j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 2 half butterfly
        for(int i =n; i >= 1 ; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2 *(n-i); j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        */

        /* 
        SOLID RHOMBUS pattern

                *****
               ***** 
              *****  
             *****   
            ***** 
         

        int n =5;
        for(int Lines = 1 ; Lines <= n; Lines++){
            for(int j = 1; j <= n - Lines; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        */

        /* Hollow SOLID RHOMBUS pattern
           *****
          *   *
         *   *
        *   *
       *****
         

        int n = 5;
        for(int Lines= 1; Lines <= n; Lines++ ){
            for(int j = 1; j <= n- Lines; j++){
                System.out.print(" ");
            }

            for(int j = 1 ; j <= n; j++){
                if(Lines == 1 || Lines == n || j == 1 || j == n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        */

        /* Diamond pattern
            *
           ***
          *****
         *******
        *********
        *********
         *******
          *****
           ***
            *
        
         
        int n = 5;
        // 1 - Half Dimond print
        for(int Lines= 1; Lines <= n; Lines++ ){
            for(int j = 1; j <= n- Lines; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (2 * Lines) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 2 - Half Diamond
        for(int Lines= n; Lines >= 1; Lines-- ){
            for(int j = 1; j <= n- Lines; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (2 * Lines) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        */

        /* print this :- Number Pyramid
            1     
           2 2    
          3 3 3   
         4 4 4 4  
        5 5 5 5 5 
        
        int n = 5;

        // outloop
        for(int i = 1; i <= n; i++){
            //Inerloop
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            //Inerloop
            for(int j = 1; j <= i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        */

        /* Try Dry Run in n = 3 couse n =5 value geeting to large and time taking 
           1   
          212  
         32123 
        4321234
       543212345
         
        int n = 5;

        //outer loop
        for(int i= 1; i <= n;i++){
            //Spaces
            for(int j = 1; j < n-i; j++){
                System.out.print(" ");
            }
            //decending
            for(int j = i; j >= 1; j--){
                System.out.print(j );
            }
            //acending
            for(int j = 2; j <=i; j++){
                System.out.print(j );
            }
            System.out.println();
        }
        */

    }
}