1class Solution {
2    public int uniquePathsWithObstacles(int[][] arr) {
3        int n=arr.length;
4        int m=arr[0].length;
5        int[][] dp=new int[n+1][m+1];
6
7        for(int i=0;i<=n;i++){
8            for(int j=0;j<=m;j++){
9                dp[i][j]=-1;
10            }
11        }
12        return solve(0,0,n,m,arr,dp);
13    }
14    public static int solve(int i,int j,int n,int m,int[][] num,int[][] dp){
15        if(i>=n || j>=m || num[i][j]==1) return 0;
16        
17        if(i==n-1 && j==m-1) return 1;
18        
19        if(dp[i][j]!=-1) return dp[i][j];
20        int right=0;
21        int down=0;
22        if(num[i][j] != 1){
23            right=solve(i,j+1,n,m,num,dp);
24            down=solve(i+1,j,n,m,num,dp);
25        }
26        
27        return dp[i][j]=right+down;
28    }
29}