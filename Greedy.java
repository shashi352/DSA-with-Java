import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.w3c.dom.ranges.Range;

public class Greedy {
    public static void activitiesSelection(int[] start, int[] end){
        //sorting
        int activities[][] = new int[start.length][3];

        for(int i = 0; i < start.length; i++){
            activities[i][0] = i;//index
            activities[i][1] = start[i]; // starting point or (time)
            activities[i][2] = end[i];
        }

        //lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basic sorted
        int maxAct = 0;
        ArrayList<Integer> ans =  new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];

        for(int i = 1; i < end.length; i++){
            if(start[i] > lastEnd){
                //activity select
                maxAct++;
                ans.add(i);// adding indexes
                lastEnd = end[i];
            }
        }
        System.out.println("max activities = " + maxAct);

        for(int i = 0; i <ans.size(); i++){
            System.out.println("A" + ans.get(i) + " ");//print index
        }System.out.println();
    }

    public static void fractinalKnapsack(int[] val, int[] weight, int w){
        double ratio[][] = new double[val.length][2];
        //0th col => idx; 1st col => ratio

        for(int i =0; i< val.length;i++){
            ratio[i][0]= 0;
            ratio[i][1] = val[i]/(double) weight[i]; // according to index 1 soting hapened
        }

        int capacity = w;
        int finalVal = 0;
        for(int i = ratio.length -1; i >=0;i--){
            int idx =(int)ratio[i][0];
            if(capacity >=  weight[idx]){// incude item
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                //included fractinal item
                finalVal += (ratio[i][1] * capacity);
            }
            capacity = 0;
            break;
        }
        System.out.println("Final Value = " + finalVal);
    }

    public static void minAbsoluteDiffPairs(int[] A, int[] B){

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i =0; i<A.length;i++){
            minDiff += Math.abs(A[i] - A[i]);
        }
        System.out.println("man absolute diff of pairs = " + minDiff);
    }
    
    public static void maxLengthOfChain(int pair[][]){
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pair[0][1]; //Last selected pair
        //end //chain end

        for(int i =0; i<pair.length;i++){
            if(pair[i][0] > chainEnd){
                chainLen++;
                chainEnd = pair[i][1];
            }
        }
        System.out.println("max length of chain = " + chainLen);
    }

    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobSequencingProblem(int[][] jobInfo){
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 0;  i < jobInfo.length; i++){
            jobs.add(new Job( i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);

        //desending order of profit
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i <jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
            }
        }

        //print seq
        System.out.println("max jobs = " + seq.size());
        for(int i =0; i<seq.size();i++){
            System.out.println(seq.get(i) + " ");
        }System.out.println();
    }

    public static void chocolaProblem(int n, int m, Integer[] costver, Integer[] costHor){
        Arrays.sort(costver, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 0, vp = 0;
        int cost = 0;

        while(n < costHor.length && v < costver.length){
            if(costver[v] <= costHor[h]){//horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }else{
                cost += (costver[v] * hp);
                vp++;
                v++;
            }
        }

        while(costver[v] <= costHor[h]){ //horizontal cut
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v < costver.length){
            cost += (costver[v] * hp);
            vp++;
            v++;
        }
        System.out.println("min cost of cuts = " + cost);
    }

    public static int BalancedPartition(String str, int n){
        //Approch
        
        if(n == 0){
            return 0;
        }
        int l = 0, r = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'R'){
                r++;
            }
            if(str.charAt(i) == 'L'){
                l++;
            }
            if(l == r){
                ans++;
            }
        }
        return ans;

    
    }
    public static int  KthOdd(int L, int R, int k){
        // solve by me
        // int count = 0;
        // for(int i = L; i <= R; i++){
        //     if(i % 2 != 0){
        //         count++;
        //     }
        //     if(count == k){
        //         return (-i);
        //     }
        // }
        // return L;
        return 0;
    }
    public static void main(String[] args) {
        //Activity Selection
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] =   {2, 4, 6, 7, 9, 9}; //end is sorted
        //activitiesSelection(start, end);

        //Feactional Knapsack
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;
        //fractinalKnapsack(val, weight, w);

        //Min Absolute Difference Pairs
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};
        //minAbsoluteDiffPairs(A, B);

        //Max Length chain of pairs
        int pair[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        //maxLengthOfChain(pair);
        
        //Job Sequencing problem
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        //jobSequencingProblem(jobInfo);

        //Chocola problem
        // int n = 4, m = 6;
        // Integer costver[] = {2, 1, 3, 1, 4}; //m-1
        // Integer costHor[] = {4, 1, 2,}; //n-1
        // chocolaProblem(n, m, costver, costHor);

        //Practice Quetions
        //Maximum Balanced String Partitions
        // String str = "LRRRRLLRLLRL";
        // int n = str.length();
        // System.out.println(BalancedPartition(str, n));

        //Kth largest odd number in a given range
        // int L= -3, R = 3, K = 1;
        // System.out.println(KthOdd(L, R, K)); *
        //need to solve || uper wala
    }
}
