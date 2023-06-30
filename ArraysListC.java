import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;

public class ArraysListC {
    
    public static void reversePrint(ArrayList<Integer> list){
        for(int i = list.size() - 1; i >=0; i--){
            System.out.print(list.get(i) + " ");
        }
    }

    public static int maximumNO(ArrayList<Integer> list){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i <= list.size() - 1; i ++){
            if(maxi < list.get(i)){
                maxi = list.get(i);
            }
        }
        return maxi;
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static int containWater(ArrayList<Integer> list){
        int maxWater = 0;

        //O(N^2)
        for(int i = 0 ; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                int height = Math.min(list.get(i), list.get(j));
                int width = j - i;
                int currMax = height * width;
                maxWater = Math.max(maxWater, currMax);
            }
        }
        return maxWater;
    }

    public static int containWater2(ArrayList<Integer> height){
        int maxWater = 0;
        int left_Ponter = 0, right_Point = height.size() - 1 ;

        //TC :- O(N)
        while(left_Ponter < right_Point ){
            //Calculating Water Area
            int ht = Math.min(height.get(left_Ponter), height.get(right_Point));
            int width = right_Point - left_Ponter;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //Update ptr
            if(height.get(left_Ponter) < height.get(right_Point)){
                left_Ponter++;
            }else{
                right_Point--;
            }
        }
        return maxWater;
    }

    public static boolean pairSum1(ArrayList<Integer> list, int Target){
        for(int i = 0 ; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(i) + list.get(j) == Target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum(ArrayList<Integer> list, int Target){
        int lp = 0, rp = list.size();
        while(lp < rp){
            if((lp + rp) == Target){
                return true;
            }
            if((lp + rp) < Target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int Target){
        int bp = -1; // Bearking Point
        int n = list.size();

        // TC - O(N)
        for(int i = 0 ; i < list.size();i++){
            if(list.get(i) > list.get(i+1)){ //breaking Point
                bp = i;
                break;
            }
        }
        int lp = bp + 1;//smallest
        int rp = bp;//largest

        while(lp != rp){
            //case 1.
            if((list.get(lp) + list.get(rp)) == Target){
                return true;
            }
            //case 2
            if(list.get(lp) + list.get(rp) < Target){
                lp = (lp+1) % n;
            }else{
                rp = (n+rp-1) % n;
            }
        }
        
        return false;
    }

    public static boolean isMonotonic(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = true;
        for(int i = 0 ; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+ 1)){
                inc = false;
            }
            if(list.get(i) < list.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }

    public static ArrayList findLonely(ArrayList<Integer> nums){
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < nums.size() -1 ;i++){
            if(nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)){
                list.add(nums.get(i));
            }
        }

        if(nums.size() == 1){
            list.add(nums.get(0));
        }
        if(nums.size() > 1){
            if(nums.get(0) + 1 < nums.get(1)){
                list.add(nums.get(0));
            }
            if(nums.get(nums.size()-2) + 1 < nums.get(nums.size() -1)){
                list.add(nums.get(nums.size() - 1));
            }
        }
        //System.out.println(list); // if void return type then
        return list;
    }

    public static void main(String[] args) {
        //java Collection Framework
        //Class            objectName = new ClassName(); 
        // ArrayList<Integer> list = new ArrayList<>();

        // //Adding Element // TC :- O(1)
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);

        /*
        System.out.println(list);

        list.add(2, 10); //TC :- O(N)

        System.out.println(list);

        //Get Element
        System.out.println(list.get(2)); // TC :- O(1)

        //Remove Element 
        list.remove(4); //TC :- O(N)
        System.out.println(list);

        //Set Element of index
        list.set(0, 20); //TC :- O(N)
        System.out.println(list);

        //Contains Element
        System.out.println(list.contains(10));//TC :- O(N)
        System.out.println(list.contains(10000));

        //Size of AL
        System.out.println(list.size());

        //Print the ArrayList
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
         */

        //Print Reverse
        //reversePrint(list);

        //Find Maximum
        //System.out.println(maximumNO(list));

        // Swapping
        //System.out.println(list);
        // int idx1 = 0, idx2 = 4;
        // swap(list, idx1, idx2);
        //System.out.println(list);

        //Sorting ArrayList
        // System.out.println(list);
        // //Acending Order Sort
        // Collections.sort(list);
        // System.out.println(list);

        // //Decending Order Sort
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        //Multi Dimentinal ArraysList
        //1st Implementation
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(400); list2.add(500);
        // mainList.add(list);
        // mainList.add(list2);

        // System.out.println(mainList);


        // for(int i = 0 ; i < mainList.size() ; i++){
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j < currList.size() ; j++){
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }



        // 2nd Implementation
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
 
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for(int i =1 ; i < 5; i++){
        //     list1.add(i*1);// 1 2 3 4 5
        //     list2.add(i*2);// 2 4 6 8 10
        //     list3.add(i*3);// 3 6 9 12 15
        // }

        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);
        // System.out.println(mainList);

        // for(int i = 0 ; i < mainList.size() ; i++){
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j < currList.size() ; j++){
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }

        //Water Contain Prooblem
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);


        //System.out.println(containWater(height));

        //System.out.println(containWater2(height));

        //pair Sum 
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int Target = 5;

        // System.out.println(pairSum1(list, Target));

        ArrayList<Integer> listP = new ArrayList<>();

        listP.add(11);
        listP.add(15);
        listP.add(6);
        listP.add(8);
        listP.add(9);
        listP.add(10);

        Target = 16;

        //System.out.println(pairSum2(list, Target));

        //Monotonic ArrayList (Easy)
        ArrayList<Integer> mono = new ArrayList<>();
        mono.add(1);
        mono.add(2);
        mono.add(3);
        mono.add(4);

        //System.out.println(isMonotonic(mono));

        //Lonely Numbers i ArrayList (Medium)
        ArrayList<Integer> lonely = new ArrayList<>();
        
        lonely.add(10);
        lonely.add(6);
        lonely.add(5);
        lonely.add(8);

        //System.out.println(findLonely(lonely));
    }
}
