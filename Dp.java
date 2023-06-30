import java.util.*;
public class Dp{

    public static int fib(int n, int f[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }

        f[n] = fib(n-1, f) + fib(n - 2, f);
        return f[n];
    }

    public static int fibTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i <=n; i++){
            dp[i] = dp[i -1] + dp[i -  2];
        }

        return dp[n];
    }

    public static int countways(int n, int ways[]){
        if(n ==0){
            return 1;
        }
        if(n <0 ){
            return 0;
        }
        if(ways[n] != -1){// alredy calculate 
            return ways[n];
        }

        ways[n] = countways(n-1, ways) + countways(n-2, ways);
        return ways[n];
    }

    public static int countwayTab(int n){
        int dp[] = new int[n+1];
        dp[0]= 1;

        for(int i =1; i<=n;i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }else{
                dp[i]= dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static int Knapsack(int val[], int wt[], int W, int n){
        //Base case
        if(W== 0 || n == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1] + Knapsack(val,wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = Knapsack(val, wt, W, n-1);
            return Math.max(ans1,ans2);
        }else{
            return Knapsack(val, wt, W, n-1);
        }
    }

    public static int Knapsackmemo(int val[], int wt[], int W, int n,int[][] dp){
        //Base case
        if(W== 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1] + Knapsack(val,wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = Knapsack(val, wt, W, n-1);
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W] = Knapsack(val, wt, W, n-1);
            return dp[n][W];
        }
    }

    public static int lcs(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1 = lcs(str1,str2, n-1,m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcs2(String str1, String str2, int n, int m, int[][] dp){
        if(n == 0 || m == 0){
            return dp[n][m];
        }


        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs2(str1, str2, n-1, m-1, dp) + 1;
        }else{
            int ans1 = lcs2(str1,str2, n-1,m, dp);
            int ans2 = lcs2(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static int lcsTab(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i < n+1;i++){
            for(int j = 0; j<m+1;j++){
                if(i==0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        } 

        for(int i = 1; i<n+1;i++){
            for(int j = 1; j< m +1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        //Initialize
        for(int i =0; i< n+1 ; i++){
            dp[i][0]= 0;
        }
        for(int j = 0;j<m+1; j++){
            dp[0][j] = 0;
        }

        //Bottom up
        for(int i = 1; i<n+1;i++){
            for(int j = 1; j<m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } 
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        // int n = 6;
        // int f[] = new int[n+1];
        // // System.out.println(fib(n, f));
        // // System.out.println(fibTab(n));

        // //coutWays- memoijetion
        // int ways[] = new int[n+1];
        // Arrays.fill(ways, -1);
        // // System.out.println(countways(n, ways));

        // //Tabulation
        // //int ways[] = new int[n+1];
        // Arrays.fill(ways, -1);
        // // System.out.println(countwayTab(n));
        

        // //0-1 Knapsack problem
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2,5,1,3,4};
        // int W = 7;

        // // System.out.println(Knapsack(val,wt, W, val.length));

        // //memoization way
        // int dp[][] = new  int[val.length+1][W+1]; 

        // for(int i = 0; i< dp.length;i++){
        //     for(int j = 0; j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        //System.out.println(Knapsackmemo(val,wt, W, val.length, dp));

        //lcs = Longest Common subsequence
        // String str1= "abcdge";
        // String str2 = "abedg";
        // int n = str1.length();
        // int m = str2.length();

        //System.out.println(lcs(str1, str2, n, m));

        // By memoization
        // int dp[][] = new int[n+1][m+1];
        // System.out.println(lcs2(str1, str2, n, m, dp));

        // By Tabulation
        //System.out.println(lcsTab(str1, str2, n, m));

        //lcs - Longest Common Substring
        String str1 = "ABCDE";
        String str2 = " ABGCE";
        System.out.println(longestCommonSubstring(str1, str2));

    }
}