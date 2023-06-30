import java.util.*;

public class HashMapImp{

    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node (K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;//size;// n // Total number of nodes
        private int N;
        private LinkedList<Node> buckets[]; // N // array is LL // = buckets.length

        @SuppressWarning("unchecked") 
        public HashMap(){
            this.N =4;
            this.buckets = new LinkedList<>();
            for(int i=0; i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
    }
    private int hashFunction(K key){
        int hc = key.hashCode();

        return math.abs(hc) % N; //buckets.length; //size;
    }

    private int searchILL(K key, int bi){
        LinkedList<Node> ll = buckets[bi];
        int di = 0;

        for(int i =0; i <ll.size(); i++){
            Node node = ll.get(i);
            if(node.key == key){
                return di;
            }
            di++;
        }
        return -1;
    }
    @SuppressWarning("unchecked") 
    private void rehash(){
         LinkedList<Node> oldBuck[] = buckets;
         buckets = new LinkedList[N*2];
         N = 2*N;
         for(int i =0; i< buckets.length;i++){
            buckets[i] = new LinkedList<>();
         }

         //node -> add in bucket
         for(int i =0; i<oldBuck.length;i++){
            LinkedList<Node> ll = oldBuck[i];
            for(int j = 0 ;j< ll.size(); j++){
                Node node = ll.remove();
                put(node.key, node.value);
            }
         }
    }

    public void put(K key, V value){
        int bi = hashFunction(key);
        int di = searchILL(key); // valid;  -1

        if(di != -1){
            Node node = buckets[bi].get(di);
            node.value = value;
        }else{
            buckets[bi].add(new Node(key, value));
            n++; //size++;
        }

        double lambda = n/N;
        //theres whold value suppose 2.0
        if(lambda > 2.0){
            rehash();
        }
    }

    public boolean containKey(K key){
        int bi = hashFunction(key);
        int di = searchILL(key, bi);

        if( di != -1){ // Valid
            return true;
        }else{
            return false;
        }
    }

    public V remove(K key){
        int bi = hashFunction(key);
        int di = searchILL(key); // valid;  -1

        if(di != -1){
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }else{
            return null;
        }
        return null;
    }

    public V get(K key){
        int bi = hashFunction(key);
        int di = searchILL(key); // valid;  -1

        if(di != -1){
            Node node = buckets[bi].get(di);
            return node.value;
        }else{
            return null;
        }
    }


    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();

        for(int i =0; i <buckets.length;i++){
            LinkedList<Node> ll = buckets[i];
            for(Node node : ll){
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("china", 150);
        hm.put("us", 50);
        hm.put("Nepal", 5);


        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.println(key);
        }
    }
} 