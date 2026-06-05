1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n=triangle.size();
4        // int[][] dp=new int[n][n];
5        // for(int[] row:dp){
6        //     Arrays.fill(row,-1);
7        // }
8        // return solve(triangle,dp,0,0);
9        int[] dp=new int[n];
10
11        for(int j=0;j<n;j++){
12            dp[j]=triangle.get(n-1).get(j);
13        }
14
15        for(int i=n-2;i>=0;i--){
16            for(int j=0;j<=i;j++){
17                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
18            }
19        }
20        return dp[0];
21    }
22
23
24    // public static int solve(List<List<Integer>> tri,int[][] dp,int i,int j){
25    //     if(i==tri.size()-1) return tri.get(i).get(j);
26        
27    //     if(dp[i][j]!=-1) return dp[i][j];
28
29    //     int down=solve(tri,dp,i+1,j);
30    //     int diagonal=solve(tri,dp,i+1,j+1);
31
32    //     return dp[i][j]=tri.get(i).get(j)+Math.min(down,diagonal);
33    // }
34}