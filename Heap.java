import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heap {
    // static class heaps{
    //     ArrayList<Integer> arr = new ArrayList<>(); 
    //     public void add(int data){
    //         //add at last idx
    //         arr.add(data);

    //         int x= arr.size()- 1;
    //         int par = (x -1)/2;

    //         if(arr.get(x) < arr.get(par)){// logn
    //             //swap
    //             int temp = arr.get(x);
    //             arr.set(x, arr.get(par));
    //             arr.set(par, temp);
    //             x = par;
    //             par = (x-1)/2;
    //         }
    //     }

    //     public int peek(){
    //         return arr.get(0);
    //     }

    //     private void heapify(int i){
    //         int left = 2*i + 1;
    //         int right = 2*2 + 2;
    //         int minIdx = i;

    //         if(left < arr.size() && arr.get(minIdx)> arr.get(minIdx)){
    //             minIdx = left;
    //         }

    //         if(right < arr.size() && arr.get(minIdx) < arr.get(right)){
    //             minIdx = right;
    //         }

    //         if(minIdx != 1){
    //             //swap
    //             int temp = arr.get(i);
    //             arr.set(i, arr.get(minIdx));
    //             arr.set(minIdx, temp);

    //             heapify(minIdx);
    //         }
    //     }

    //     public int remove(){
    //         int data = arr.get(0);

    //         //1step  swap first and last
    //         int temp = arr.get(0);
    //         arr.set(0, arr.size()-1);
    //         arr.set(arr.size(), temp);

    //         //step 2 delete last
    //         arr.remove(arr.size()-1);

    //         //step - heapify
    //         heapify(0);
    //         return data;
    //     }

    //     public boolean isEmpty(){
    //         return arr.size() == 0;
    //     }
    // }

    static class Student implements Comparable{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @overriing
        public int compreTo(Student s2){
            return this.rank - s2;
        }
    }


    public static void main(String[] args) {
        // heaps h = new heaps();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }


        //JCF  implementation
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove(); 
        // }

        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder);

        // pq.add(new Student("A",  4));
        // pq.add(new Student("B",  5));
        // pq.add(new Student("C",  2));
        // pq.add(new Student("D",  12));

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }

    }
}