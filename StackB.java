import java.util.ArrayList;
import java.util.Stack;
public class StackB {
/* 
    implementation by ArrayList
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        //Check isEmpty
        public static boolean isEmpty(){
            return list.size() == 0;
        }
        //push()
        public static void push(int data){
            list.add(data);
        }
        //pop()
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }
*/
/* 
    //Implementation by list
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }
        //push
        public static void push(int data){
            Node newNode = new Node(data);

            if(isEmpty()){
                head = null;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        //pop
        public static int pop(){
            if(head == null){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    */

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char ch = s.pop();
            result.append(ch);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i =1; i < stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            //edge case
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int preHigh = s.peek();
                span[i] = 1 - preHigh;
            }
            s.push(i);
        }
    }
    public static void nextGreater(int[] arr){
        Stack<Integer> ss = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i =arr.length - 1; i>=0;i--){
            //Step 1. while
            while(!ss.isEmpty() && arr[ss.peek()] <= arr[i]){
                ss.pop();
            }

            //Step 2. if-else
            if(ss.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[ss.peek()];
            }

            //Step 3. push in s
            ss.push(i);
        }

        for(int i =0; i<=nextGreater.length - 1; i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

        //Note :- Similar question you gona face and many other Question u face in Stack have to used this Logic
        // Like -
        // next Greater Right - This ^| code
        // next Greater Left - Change only for loop code
        // next Smaller Right - Change While loop (>=)
        // next Smaller Left - Change for as well as  while loop
    }

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i =0; i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){ //Opening
                s.push(ch);
            }else{
                //Closing
                if(s.isEmpty()){ // there no more open beaket and we have closing to Compare so, 
                    return false;
                }

                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }

        if(s.isEmpty()){ // there is no more breaket (opening as well closing )to compare so,
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if(ch == ')'){
                int count =0;
                //while(!s.isEmpty() && s.peek() != '('){
                while(s.peek() != '('){ // we also include this -> && !s.isEmpty()
                    s.pop();
                    count++;
                }

                if(count < 1){
                    return true; // Duplicate
                }else{ 
                    s.pop(); //opening pair
                }
            }else{
                //opening
                s.push(ch);
            }
        }

        return false;
    }

    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length]; //next Smallest right
        int nsl[] = new int[arr.length]; //next Smallest left

        //Step 1. Next Smaller Right
        Stack<Integer> s = new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                //-1
                nsr[i] = -1;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Greater Left
        s = new Stack<>();

        for(int i=0; i <arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                //-1
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area : width = j -i - 1 - nsr[i] - nsl[i] -1
        for(int i =0; i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("max area in histogram = " + maxArea);

    }
    public static void main(String[] args) {
        /* 
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        */
        
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        //printStack(s);

        //push at buttom
        // pushAtBottom(s, 4);
        // printStack(s);

        //Reverse the String
        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);

        //reverse the Stack
        // reverseStack(s);
        // printStack(s);

        //Stock span problem
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i =0; i<span.length;i++){
        //     System.out.print(span[i] + " ");
        // }System.out.println();

        //Next Greater Element Right
        // int arr[] = {6,8,0,1,3};
        // nextGreater(arr);

        //Check is Valid Parenthses or not
        // String str = "({[]})";
        // System.out.println(isValid(str));
        
        //Check Duplicate exist or not
        String str = "((a+b))"; //true
        String str2 = "(a-b)"; //false
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));

        //Max Area in histogram
        // int arr[] = {2,4};
        // maxArea(arr);

    }
}
