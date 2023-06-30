import java.security.DrbgParameters.NextBytes;

public class LinkedList {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //step 1 : Create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        } 

        //step 2: newNode next = head;
        newNode.next = head;

        //step3 - head = newNode
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx - 1){
            temp = temp.next;
            i++;
        }

        // 1 = idx - 1; temp  -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev : 1 = size - 2
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null; 
        prev = tail;
        size--;
        return val;

    }

    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }System.out.println("null");
    }

    public int itrSearch(int key){ // O(N)
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){ //key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        return - 1; // key not found
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    //I.M.P Question
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    

    public void deleteNtFromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //Find midNode
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; // slow is my mid
    }

    public boolean checkPolindrame(){
        if(head == null || head.next == null){
            return true;
        }

        //step 1- find mid
        Node midNode = findMid(head);

        //step 2- reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        //step 3 - Check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if( fast == slow){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null; // last Node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle - > last.next = null
        prev.next = null;
    }

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //mid Node
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node righthead = mid.next;

        mid.next = null;
        Node newLeft = mergSort(head);
        Node newRight = mergSort(righthead);

        //merge
        return merge(newLeft, newRight);
    }

    public void zigzag(){
        //1. find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //2.Reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alt merge - zigzag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        // ll.addFirst(2);
        // ll.addFirst(1);

        // ll.addFirst(1);
        // ll.addFirst(2);
        
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2, 4);
        //ll.print();
        //System.out.println(ll.size);

        //Remove First
        // ll.removeFirst();
        // ll.print();
        // System.out.println(ll.size);

        //Remove Last
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);

        //iterative way to search
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        //recursion way to search 
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // ll.reverse();
        // ll.print();

        // ll.deleteNtFromEnd(3);
        // ll.print();

        //check is palindrome or not
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addFirst(1);
        // ll.addFirst(2);
        //System.out.println(ll.checkPolindrame());

        //cycle exist or not
        // head.next = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        
        //1->2->3->1
        // System.out.println(ll.isCycle());

        //Remove cycle in LL
        // removeCycle();
        // System.out.println(ll.isCycle());

        //Merge Sort on a Linked List 
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        //6->5->4->3->2->1
        ll.print();

        // ll.head = ll.mergSort(ll.head);
        // ll.print();

        ll.zigzag();
        ll.print();
    }
}