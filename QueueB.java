import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.synth.SynthStyle;
public class QueueB {
    //Implement by Array
    /* 
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){// TC :- O(1)
            if(rear == size - 1){
                System.out.println("Queue is full");
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = arr[0];
            // TC :- O(N)
            for(int i =0; i < rear; i++){
                arr[i] = arr[i+1];
            }

            return front;
        }

        public static int peek(){ // TC :- O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }
    */

    /* //Circular Queue Implementation by circular From 
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        public static void add(int data){// TC :- O(1)
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //add first element
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = arr[front];

            //last el delete
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }

            return result;
        }

        public static int peek(){ // TC :- O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }
    */

    //Question
    //Queue using LinkedList

    /* 
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

        static class Queue{
            static Node head = null;
            static Node tail = null;

            public static boolean isEmpty(){
                return head == null && tail == null;
            }

            //add
            public static void add(int data){
                Node newNode = new Node(data);
                if(head == null){
                    head = tail = newNode;
                    return;
                }

                tail.next = newNode;
                tail = newNode;
            }

            //remove
            public static int remove(){
                if(isEmpty()){
                    System.out.println("Empty Queue");
                    return -1;
                }

                int front = head.data;
                head = head.next;
                //Single element
                if(tail == head){
                    tail = head = null;
                }else{
                    head = head.next;
                }
                return front;
            }

            //peek
            public static int peek(){
                if(isEmpty()){
                    System.out.println("Empty Queue");
                    return -1;
                }

                return head.data;
            }
        }
    }
    */

    //Question 2
    //Queue Using Two Stacks
    /* 
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add - TC O(N)
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.pop();
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.pop();
        }
    }
    */

    //Question 3
    //Stack using 2 Queue
    /* 
    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("empty Queue");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){ // we can ignore if-statment coz we already store pop value in top
                        break;
                    }
                    q2.add(top);
                }
            }else{//case
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{//case
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

    }
    */

    // public static void printNonRepeating(String str){
    //     int freq[] = new int[26];
    //     Queue<Character> q = new LinkedList<>();

    //     for(int i =0; i <str.length();i++){
    //         char ch = str.charAt(i);
    //         q.add(ch);
    //         freq[ch - 'a']++;

    //         while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
    //             q.remove();
    //         }

    //         if(q.isEmpty()){
    //             System.out.println(-1 + " ");
    //         }else{
    //             System.out.println(q.peek() + " ");
    //         }
    //     }
    //     System.out.println();
    // }

    //  //Interleave 2 Halves of a Queue (even length)
    // public static void interLeaveQueue(Queue<Integer> q){
    //     Queue<Integer> firstHalf = new LinkedList<>();
    //     int size = q.size();

    //     for(int i = 0; i <size/2 ;i++){
    //         firstHalf.add(q.remove());
    //     }

    //     while(!firstHalf.isEmpty()){
    //         q.add(firstHalf.remove());
    //         q.add(q.remove());
    //     }
    // }

    // public static void reverse(Queue<Integer> q){
    //     Stack<Integer> s = new Stack<>();

    //     while(!q.isEmpty()){
    //         s.push(q.remove());
    //     }

    //     while(!s.isEmpty()){
    //         q.add(s.pop());
    //     }
    // }

    // static class stack{
    //     Deque<Integer> deque = new LinkedList<>();

    //     public void push(int data){
    //         deque.addLast(data);
    //     }

    //     public int pop(){
    //         return deque.removeLast();
    //     }

    //     public int peek(){
    //         return deque.getLast();
    //     }
    // }

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        //Queue q = new Queue(5);

        //JCF Queue Implement
        //Queue<Integer> q = new LinkedList<>();
        //Queue<Integer> q = new ArrayDeque<>();
        
        //Question 2
        //Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // System.out.println(q.peek());
        // q.remove();
        // System.out.println(q.peek());
        // q.remove();
        // System.out.println(q.peek());
        // q.remove();
        // System.out.println(q.peek());
        
        
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // while(!q.isEmpty()){
        //     System.out.println(q.remove());
        // }

        //Question 3
        //stack using Queue

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.peek());
        // System.out.println(s.pop());

        // System.out.println(s.peek());
        // System.out.println(s.pop());

        // System.out.println(s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.peek());

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        //print Non Reapting Element
        // String str = "aabccxb";
        // printNonRepeating(str);


        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        //Interleave 2 Halves of a Queue (even length)
        // interLeaveQueue(q);

        // while(!q.isEmpty()){
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }

        //Reverse Queue
        // reverse(q);

        // while(!q.isEmpty()){
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }

        //Implement Deque
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1); // 1
        // System.out.println(deque);

        // deque.addFirst(2); //2, 1, 
        // System.out.println(deque);

        // deque.addLast(3); //2, 1, 3
        // System.out.println(deque);

        // deque.addLast(4);//2, 1, 3, 4
        // System.out.println(deque);

        // deque.removeFirst();// 1, 3, 4
        // System.out.println(deque);

        // deque.removeLast(); // 1, 3
        // System.out.println(deque);


        // System.out.println("First element = " + deque.getFirst()); // peek 1
        // System.out.println("First element = " + deque.getLast()); // 3

        // deque.removeLast();
        // System.out.println(deque);

        //Quetion 7
        //Stack using Deque
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("peek = " + s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        //Implementing Queue using Deque
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek = " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
