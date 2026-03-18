1class Solution {
2
3    public int numberOfStableArrays(int zero, int one, int limit) {
4
5        int MOD = 1_000_000_007;
6
7        long[][][] dp = new long[zero+1][one+1][2];
8
9        for(int i=1;i<=Math.min(zero,limit);i++)
10            dp[i][0][0]=1;
11
12        for(int j=1;j<=Math.min(one,limit);j++)
13            dp[0][j][1]=1;
14
15        for(int i=1;i<=zero;i++)
16        for(int j=1;j<=one;j++){
17
18            long over0 = (i-limit>=1)?dp[i-limit-1][j][1]:0;
19            long over1 = (j-limit>=1)?dp[i][j-limit-1][0]:0;
20
21            dp[i][j][0] =
22            (dp[i-1][j][0]+dp[i-1][j][1]-over0+MOD)%MOD;
23
24            dp[i][j][1] =
25            (dp[i][j-1][0]+dp[i][j-1][1]-over1+MOD)%MOD;
26        }
27
28        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
29    }
30}