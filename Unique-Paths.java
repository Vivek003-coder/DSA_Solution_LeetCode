1class Solution {
2    public static int solve(int i,int j,int m,int n,int[][] dp){
3        if(i>=m || j>=n){
4            return 0;
5        }
6        if(i==m-1 && j==n-1){
7            return 1;
8        }
9        if(dp[i][j]!=-1){
10            return dp[i][j];
11        }
12        int right=solve(i,j+1,m,n,dp);
13        int down=solve(i+1,j,m,n,dp);
14        return dp[i][j]=right+down;
15    }
16
17    public int uniquePaths(int m, int n) {
18        int[][] dp=new int[m][n];
19        for(int i=0;i<m;i++){
20            for(int j=0;j<n;j++){
21                dp[i][j]=-1;
22            }
23        }
24        return solve(0,0,m,n,dp);
25    }
26}