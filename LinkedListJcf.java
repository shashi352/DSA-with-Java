import java.util.LinkedList;
public class LinkedListJcf {
    public static void main(String[] args) {
        //Create = object, int, float, boolean -> (insted of used this -> ) Integer, Float, Charecter

        //create
        LinkedList<Integer> ll = new LinkedList<>();
        //add
        ll.addFirst(1);
        ll.addFirst(2); 
        ll.addLast(3);
        //0->1->2
        System.out.println(ll);

        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
