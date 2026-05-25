1class Solution {
2    public int climbStairs(int n) {
3        int[] dp=new int[n+1];
4        Arrays.fill(dp,-1);
5        
6        return solve(n,dp);
7    }
8    public static int solve(int n, int[] dp){
9        if(n==0 || n==1) return 1;
10        if(dp[n]!=-1) return dp[n];
11
12        return dp[n]=solve(n-1,dp)+solve(n-2,dp);
13    }
14}