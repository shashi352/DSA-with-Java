import java.util.*;

import javax.sql.rowset.spi.SyncResolver;
public class OopsC {
    public static void main(String arg[]){
        /* 
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color); 

        p1.setTip(5);
        System.out.println(p1.tip);

        p1.color = "Yellow";
        System.out.println("Updating value of color :- " +p1.color);
        */ 
        
        /* 
        BankAccount myAcc = new BankAccount();
        myAcc.username = "shashi";
        //myAcc.password = "abcdefghi" // it's not visible here if it's declare with private key word
        myAcc.setPassword("abcdefgi");
        */

        /* Getter and Setter
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
        */ 

        /* 
        Student s1 = new Student(); // Non-Peramiterized Constructor
        System.out.println(s1);
        Student s2 = new Student("Shashi"); // Peramiterized Constructer
        System.out.println(s2.name);

        Student s3 = new Student(111);
        System.out.println(s3.roll); // Acces the property or attribute (roll)

        //Student s4 = new Student("aman", 567); // Error coz can't created

        */

        Student s1 = new Student();
        s1.name = "Shashi";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1); // Copy object s1 properties to object s2 properties 
        s2.password = "xyz";
        s1.marks[2] = 100;
        for(int i = 0 ; i < 3; i++){
            System.out.println(s2.marks[i]);
        }

        //Single Level Inheritance
        Fish shark = new Fish();
        shark.eat();

        //Multi Level Inheritance
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);

        // Hierarchical Inheritance
        Bird pigeons = new Bird();
        pigeons.fly();

        //Polymorphism  #Function_overloadind example
        Calculator calc = new Calculator();
        System.out.println(calc.sum(3, 5));
        System.out.println(calc.sum(2.5, 2.5));
        System.out.println(calc.sum(3, 8, 2));
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];
    
    //Shallow copy
    //Changes reflect coz using property passing by reference :- point same value

    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks; // Shallow Copy
    // }

    //Deep copy :- changes don't reflect.
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i =0; i < 3; i++){
            this.marks[i] = s1.marks[i]; // Deep Copy
        }
    }

    // Note :- the constructer not have any constructer coz the have own Garbege collector


    Student(){
        marks = new int[3];
        System.out.println("Constructer is Colled :- ");
    }

    Student(String name){
        marks = new int[3];
        this.name = name;
    }

    Student(int roll){
        marks = new int[3];
        this.roll = roll;
    }
}

class Pen {
    private String color;
    private int tip;

    // its declare to acces private property or attribute and set it or change it
    void setColor(String newColor){
        this.color = newColor;
    }

    void setTip(int newTip){
        this.tip = newTip;
    }
    // its declare to acces private property or attribute and get it or take it
    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }


}

class BankAccount {
    public String username;
    private String password;
    public void setPassword(String pwd){
        password = pwd;
    }

}

class Animal{
    String color;

    void eat(){
        System.out.println("Eats");
    }

    void breathe(){
        System.out.println("brethes");
    }
}

//Single Level Inheritance
// class Fish extends Animal {
//     int fins;
//     void swim(){
//         System.out.println("Swim");
//     }
// }

//Multi Level interitance
// class Mammal extends Animal{
//     int legs;
// }

class Dog extends Mammal{
    String breed;
}

//Hierarchical Level
class Mammal extends Animal{
    int legs;
}

class Fish extends Animal {
    int fins;
    void swim(){
        System.out.println("Swim");
    }
}

class Bird extends Animal{
    //System.out.println("g"); whout creating fuction in class the print statment does't work
    void fly(){
        System.out.println("fly");
    }
}

//Hybrid is H.W

//multiple Inheritence :- doest not exist Java but used that type of property we use Interface

class Calculator {
    // Different Parameter :- only two parameter we discover here
    int sum(int a, int b){
        return a + b;
    }

    // Different Data Type
    float sum(float a, float b){
        return a + b;
    }

    //Number of Perameter are changes
    int sum(int a, int b, int c){
        return a + b + c;
    }
}
public class OopsC {
    
}
