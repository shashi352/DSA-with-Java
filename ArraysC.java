import java.util.function.BinaryOperator;
import java.lang.annotation.Target;
import java.util.*;

public class ArraysC {

    public static void linearsearch(int numbers[], int key){
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] == key){
                System.out.println("Key is found on index :- " + i);
                return;
            }
        }
        System.out.println("Key is not found");
    }

    public static void largestNumber(int numbers[]){
        int maxi = Integer.MIN_VALUE;
        /* 1 Approch linear way by inbuild method
        for(int i = 0 ; i < numbers.length; i++){
            maxi = Math.max(maxi, numbers[i]); 
        }
        */
        // 2 Approch linear way
        for(int i = 0 ; i < numbers.length; i++){
            if(maxi < numbers[i]){
                maxi = numbers[i];
            } 
        }

        System.out.println("MAXIMUM VALUE IS : - " +  maxi);
    }

    public static int binarysearch(int numbers[], int key){
        int start = 0, end = numbers.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(numbers[mid] == key){
                return mid;
            }

            if(numbers[mid] < key){ // right
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void swap(int start, int end){
        int temp = start;
        start = end;
        end = temp;
    }

    public static void Reverse(int numbers[]){
        int start = 0, end = numbers.length - 1;
        while(start < end){
            //swap(numbers[start], numbers[end]);
            int temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;

            start++;
            end--;
        }
    }

    public static void pairs(int numbers[]){
        int totalpairs = 0;
        for(int i = 0; i < numbers.length;i++){
            for(int j = i + 1; j < numbers.length; j++){
                System.out.print("(" + numbers[i] + ", " + numbers[j] + ")");
                totalpairs++;
            }
            System.out.println();
        }
        System.out.println(totalpairs);
    }

    public static void subArray(int numbers[]){
        int ts = 0;
        for(int i = 0; i < numbers.length; i++){
            int start= i;
            for(int j =start; j < numbers.length;j++){
                int end = j;
                for(int k = start; k <= end; k++){
                    System.out.print(" " + numbers[k]);
                }
                ts++;
                System.out.println();
            }System.out.println();
        }
        System.out.println("Total subarray " + ts);
    }

    public static void maxSubarraySum(int numbers[]){
        /* T.C -  O(N^3)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < numbers.length; i++){
            int start = i;
            for(int j = i; j < numbers.length; j++){
                int end = j;
                currSum = 0;
                for(int k = start; k <=end; k++){
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                if( maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum is :- " + maxSum);
        */


        // TC - O(N^2)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[] = new int[numbers.length];

        prefixSum[0] = numbers[0];

        for(int i = 1; i < numbers.length; i++){
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }


        for(int i = 0 ; i < numbers.length; i++){
            int start = i;
            for(int j = i; j < numbers.length; j++){
                int end = j;
                System.out.println(currSum);
                currSum = start == 0 ? prefixSum[end] : prefixSum[end] + prefixSum[start - 1];
                if( maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum is :- " + maxSum);
    }

    public static boolean checknegativeNo(int numbers[]){
        // if all nubers are negative the first check it's realy all no. are negative if yes the find smallest one
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] > 0){// this mean positive numbers exist
                return false;
            }
        }
        return true;
    }

    // max subarrays sum in O(N^2) T.C
    public static void kadanes(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        if(checknegativeNo(numbers) == false){
            for(int i = 0; i < numbers.length; i++){
                currSum += numbers[i];
                if( currSum < 0){
                    currSum = 0;
                }
                
                maxSum = Math.max(maxSum, currSum);
            }
            System.out.println("Max sum is :- " + maxSum);
        } else{
            for(int i = 0 ; i < numbers.length; i++){
                maxSum = Math.max(maxSum, numbers[i]);
            }
            System.out.println("Max sum is :- " + maxSum);
        }
    }

    public static int trappingRainwater(int height[], int width){
        // T.C - O(N^2) 
        // S.C - O(N) for helping array leftMax or auxilary space + O(N) rightMax or auxilary space
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1 ]);
        }

        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length -1];
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trapwater = 0;
        for(int i = 0 ; i < height.length; i++){
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            trapwater += (waterlevel - height[i]) * width;

        }
        return trapwater;
    }

    public static boolean isvalueAppearsTwice(int nums[]){

        // //T.C - O(NlogN)  Approch - 1
        // Arrays.sort(nums); // O(logN)
        // for(int i = 0; i <nums.length;i++){ // O(N)
        //     if(nums[i] == nums[i+1]){
        //         return true;
        //     }
        // }
        // return false;

        // // T.C - O(N^2) // Approch - 2
        // for(int i = 0 ; i < nums.length ; i++){
        //     for(int j = i+1; j < nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //using HashSet T.C - O(N) , N is length of Arrays

        HashSet set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){// O(N)
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void sellBuyStock(int price[]){
        int buyprice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i < price.length;i++){
            // price[i] denote selling price
            if(buyprice <  price[i]){
                int profit = price[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyprice = price[i];
            }
        }
        System.out.println("max profit is :- " + maxProfit);
    }

    public static int search(int[] nums, int target){
        // min will have index of minimum element of numsS
        int min = minSearch(nums); // here min is our mid
        // find in sorted left
        if(nums[min] <= target && target <= nums[nums.length - 1]){
            return search(nums, min, nums.length - 1, target);
        }
        // find in sorted right
        else{
            return search(nums,0, min, target);
        }
    }

    // binary search to find target in left to right boundary
    public static int search(int nums[], int left, int right, int target){ // fuction overloading

        int l = left;
        int r = right;
        //System.out.println(left + " " + right);
        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int minSearch(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid - 1] > nums[mid]){
                return mid;
            }else if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    public static int trap(int[] height){ // we don't use here any left or right auxilary space so S.C - O(1)
                                          //  T.C - O(N)
        int n = height.length;

        int res = 0, l =0 , r = n-1;
        int rMax = height[r], lMax = height[l];

        while( l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            }else{
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum(int nums[]){

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for( int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j + 1; k<nums.length; k++){
                    if(nums[i] + nums[k] + nums[k] == 0){
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>> (result));
        return result;
    }

    //pivit point
    public static int pivit(int[] nums){
        for(int i =0 ; i< nums.length-1;i++){
            if(nums[i]> nums[i+1]){
                return i+1;
            }
        }
        return -1;
    }

    public static int pivit2(int[] nums, int target){
        for(int i =0 ; i< nums.length-1;i++){
            if(nums[i] == target ){
                return i;
            }
        }
        return -1;
    }

    public static int buySellStock(int price[]){
        int buyprice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i< price.length;i++){
            if(buyprice < price[i]){
                int profit = price[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyprice = price[i];
            }
        }
        return maxProfit;
    }    

    public static void main(String arg[]){
        int numbers[] = {-1, -2, -6, -1, -3}; //{1, -2, 6, -1, 3};//{0,1,200,3,5,6,8,99};
        int key = 99;
        //linearsearch(numbers, key);

        /* 
        int index = binarysearch(numbers, key);

        if(index == - 1){
            System.out.println("Key is not found");
        }else{
            System.out.print("Key is found on index :- " + index);
        }
        */
        //largestNumber(numbers);
        //Reverse(numbers);

        /*for(int i = 0; i < numbers.length;i++){
            System.out.print(numbers[i] + " ");
        }
        */

        //pairs(numbers); // print all the pairs of subarrays

        //subArray(numbers);

        //maxSubarraySum(numbers);
        //kadanes(numbers);

        // //Traing water proble
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        // int width = 1;// if with is 2, 3, 4 ....n

        // //System.out.println(trappingRainwater(height, width));

        // // sell buy stock question
        // int price[] = {7, 1, 5, 3, 6, 4};
        // sellBuyStock(price);

        //practice question

        // // is value Appears Twice in a nums Arrays
        // int nums[] = {1, 2, 3, 1};

        // System.out.println(isvalueAppearsTwice(nums));

        // //search in roteted sorted arrays
        // int[] nums= {4, 5, 6, 7, 0, 1, 2};
        // int target = 0;

        // System.out.println(search(nums, target));


        // // traping water problem
        // int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // System.out.println(trap(height));

        //find 3sum trplet equal to 0 or 3sum problem
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // System.out.println(threeSum(nums));

        //pivit point
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // System.out.println(pivit(nums));

        // //pivit point 2
        // int Target = 3; 
        // System.out.println(pivit2(nums, Target));

        int price[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buySellStock(price));
    }
}
