public class Untitled-1 {
    public static void main(String[] args) {
        PriorityQueue<Student> pq  = new priorityQuque<>(comparator.reverseorder);
        pq.add(new Student(4));
        pq.add(new Student(5));
        pq.add(new Student(2));
        pq.add(new Student(12));
        System.out.println(pq);

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " " + pq.peek().rank);//0(1)
            pq.remove();//O(n)
        }
    }
}
