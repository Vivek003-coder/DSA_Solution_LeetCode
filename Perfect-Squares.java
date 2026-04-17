1class Solution {
2    public boolean isPerfect(int n){
3        int sqrt=(int)Math.sqrt(n);
4        return (sqrt*sqrt==n);
5    }
6
7    // public int minsqrt(int n,int[] dp) {
8    //     if(isPerfect(n)) return 1;
9
10    //     if(dp[n]!=-1){
11    //         return dp[n];
12    //     }
13
14    //     int min=Integer.MAX_VALUE;
15    //     for(int i=1;i<=n/2;i++){
16    //         int count=minsqrt(i,dp)+minsqrt(n-i,dp);
17    //         min =Math.min(min,count);
18    //     }
19    //     return dp[n]=min;
20    // }
21
22    public int numSquares(int n){
23        int[] dp=new int[n+1];
24        Arrays.fill(dp,-1);
25        for(int i=1;i<=n;i++){
26            if(isPerfect(i)) dp[i]=1;
27            else{
28                int min=Integer.MAX_VALUE;
29                for(int j=1;j*j<=i;j++){
30                    int count=dp[j*j]+dp[i-j*j];
31                    min =Math.min(min,count);
32                }
33                dp[i]=min;
34            }
35
36        }
37        return dp[n];
38
39    }
40
41}