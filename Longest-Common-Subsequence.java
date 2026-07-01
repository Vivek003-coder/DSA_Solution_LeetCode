1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int n=text1.length();
4        int m=text2.length();
5        int[][] dp=new int[n+1][m+1];
6        // for(int row[] : dp){
7        //     Arrays.fill(row,-1);
8        // }
9        // return solve(text1,text2,n,m,0,0,dp);
10
11        for(int i=1;i<=n;i++){
12            for(int j=1;j<=m;j++){
13                if(text1.charAt(i-1)==text2.charAt(j-1)){
14                    dp[i][j]=1+dp[i-1][j-1];
15                }else{
16                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
17                }
18            }
19        }
20        return dp[n][m];
21    }
22
23    // public static int solve(String t1,String t2,int n,int m,int i,int j,int[][] dp){
24    //     if(i>=n || j>=m) return 0;
25
26    //     if(dp[i][j] !=-1) return dp[i][j];
27
28    //     if(t1.charAt(i)==t2.charAt(j)){
29    //         dp[i][j]=1+solve(t1,t2,n,m,i+1,j+1,dp);
30
31    //     }else{
32    //         dp[i][j]=Math.max(solve(t1,t2,n,m,i+1,j,dp),solve(t1,t2,n,m,i,j+1,dp));
33    //     }
34    //     return dp[i][j];
35    // }
36}