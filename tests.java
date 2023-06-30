import java.util.PriorityQueue;
public class tests {

    // static class Student implements Comparable<Student>{
    //     String name;
    //     int rank;
    //     public Studen(String name, int rank){
    //         this.name = name;
    //         this.rank = rank; 
    //     }

    //     @Override
    //     public int compreTo(Student s2){
    //         return this.rank =  s2.rank;
    //     }

    // }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        pq.add(3);// log(N)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());//0(1)
            pq.remove();//O(n)
        }


        // pq.add(new Student("A", 4));
        // pq.add(new Student(5));
        // pq.add(new Student(2));
        // pq.add(new Student(12));
        // System.out.println(pq);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name + " " + pq.peek().rank);//0(1)
        //     pq.remove();//O(n)
        // }
    }
}
