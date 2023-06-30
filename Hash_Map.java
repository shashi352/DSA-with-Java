import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class Hash_Map {

    // private class Node{
    //     k key;
    //     v value;

    //     public Node(int k key, v value){
    //         this.key = key;
    //         this.value = value;
    //     }
    // }

    private int size;//n
    private LinkedList bukets[];//N

    //@suppreswarings(uncketked)
    // public HashMap(){
    //     this.size= 0;
    //     this.bukets = new LinkedList[4];

    //     for(int i =0;i<4;i++){
    //         this.bukets[i] = new LinkedList<>();
    //     }
    // }

    public static boolean isAnagram(String s, String t){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        for(int i =0; i<t.length();i++){
            
            char ch = t.charAt(i);
            if(map.get(i) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) -1);
                }
            }else{
                return false;
            }
           
        }
         return map.isEmpty();
    }

    public static void main(String args[]){
    //     HashMap<String,Integer> hm = new HashMap<>();
    //     hm.put("india", 100);
    //     hm.put("china", 150);
    //     hm.put("us", 50);
    //     System.out.println(hm);
    //     System.out.println(hm.size());
    //     // hm.clear();
    //     // System.out.println(hm);
    //     System.out.println(hm.isEmpty());

    //     // get
    //     int population = hm.get("india");
    //     System.out.println(population);

    //     //contains 
    //     System.out.println(hm.containsKey("india"));
    //     System.out.println(hm.containsKey("indonesia"));

    //     //Remove
    //     System.out.println(hm.remove("india"));
    //     System.out.println(hm);

    //     //iteration on hashmap
    //     for(String k : hm.keySet() ){
    //         // System.out.println("key" + k.getKey() + "value" + k.getValue());
    //         System.out.println(k);
    //     }

    //     for(Integer k : hm.values() ){
    //         // System.out.println("key" + k.getKey() + "value" + k.getValue());
    //         System.out.println(k);
    //     }





    //     //Set<String> key = hm.keySet();
    //     for(String k : hm.keySet()){
    //         System.out.println("key" + k + "value" + hm.get(k));
    // }

    // HashMap<Integer,Integer> map = new HashMap<>();
    // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
    // for(int i =0; i<arr.length; i++){
    //     if(map.containsKey(arr[i])){
    //         map.put(arr[i], map.get(arr[i]) + 1);
    //     }else{
    //         map.put(arr[i], 1);
    //     }
    // }

    // Set<Integer> keySet = map.keySet();
    // for(Integer key : keySet){
    //     if(map.get(key) > arr.length/3){
    //         System.out.println(key);
    //     }
    // }

    // for(Integer key : map.keySet()){
    //     if(map.get(key) > arr.length/3){
    //         System.out.println(key);
    //     }
    // }

    // String s = "race";
    // String t = "care";
    // System.out.println(isAnagram(s, t));

    // HashSet<Integer> set = new HashSet<>();

    // set.add(1);
    // set.add(2);
    // set.add(3);
    // set.add(4);
    // set.add(5);

    // if(set.contains(2)){
    //     System.out.println("setContain 2");
    // }

    // set.remove(2);
    // if(set.contains(2)){
    //     System.out.println("setContain 2");
    // }
    
    // System.out.println(set);
    // set.clear();
    // System.out.println(set);
    // System.out.println(set.size());
    // System.out.println(set.isEmpty());

    // HashSet<String> cties = new HashSet<>();
    // cties.add("Delhi");
    // cties.add("Mumbi");
    // cties.add("Noida");
    // cties.add("banglore");

    // for(String city : cties){
    //     System.out.println(city);
    // }

    // Iteretor it = cties.iterator();
    // while.HashNext(){
    //     System.out.println(it.next());
    // }
    }
}