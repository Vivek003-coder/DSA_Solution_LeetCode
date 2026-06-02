1class Solution {
2    public int minPathSum(int[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5
6        int[][] dp=new int[n+1][m+1];
7        for(int i=0;i<=n;i++){
8            for(int j=0;j<=m;j++){
9                dp[i][j]=-1;
10            }
11        }
12
13        return solve(0,0,n,m,grid,dp);
14    }
15    public static int solve(int i,int j,int n,int m,int[][] arr,int[][] dp){
16        if(i>=n || j>=m)return Integer.MAX_VALUE;
17        if(i==n-1 && j==m-1) return arr[i][j];
18        if(dp[i][j]!=-1) return dp[i][j];
19
20        int right=solve(i+1,j,n,m,arr,dp);
21        int down=solve(i,j+1,n,m,arr,dp);
22
23        dp[i][j]=arr[i][j]+Math.min(right,down);
24        return dp[i][j];
25    }
26}