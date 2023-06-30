import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class javaBasic{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        // Average of 3 no.s
        /* 
        float A = sc.nextFloat();
        float B = sc.nextFloat();
        float c = sc.nextFloat();

        float Avergae = (A + B + c) / 3; // Type Coversion
        System.out.println(Avergae); 
        */

        // Area of square
        /* 
        int Side = sc.nextInt();
        int area = Side * Side;
        System.out.print(area);
        */

        /* calculate the price of 3 item
         
        float pen = sc.nextFloat();
        float pencil = sc.nextFloat();
        float eraser = sc.nextFloat();

        float total = pen + pencil + eraser;
        System.out.println(total);

        //ADV on with GST 18%

        float bill = (pen + pencil + eraser) + 0.18f*total;

        System.out.println(bill);
        */ 
        
        /* 
        byte b = 4;
        char c = 'a';
        short s = 512;
        int i = 1000;
        float f = 3.14f;
        double d = 99.9954;

        double result = (f*b) + (i % c) - (d * c);
        System.out.println(result); 
        */

        /* 
        int $ = 24;
        System.out.println($);
        */

        /* 
        byte b = 127;
        System.out.println( b );

        short s = 32767;
        System.out.println( s );

        int i = 2147483647;
        System.out.println( i );

        // long  l = 9223372036854775807; // time limite excuted 
        System.out.println( l );

        
        */
    }
}