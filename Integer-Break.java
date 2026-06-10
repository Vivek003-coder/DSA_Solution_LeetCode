1class Solution {
2    public int integerBreak(int n) {
3        int[] dp=new int[n+1];
4        Arrays.fill(dp,-1);
5
6        return solve(n,dp);
7    }
8    public static int solve(int n,int[] dp){
9        if(n==1) return 1;
10
11        if(dp[n]!=-1) return dp[n];
12
13        int maxprod=0;
14        for(int i=1;i<n;i++){
15            int prod=i*Math.max((n-i),solve(n-i,dp));
16            maxprod=Math.max(maxprod,prod);
17        }
18        return dp[n]=maxprod;
19    }
20}