1class Solution {
2    long mod=(int)1e9+7;
3    Long[][] dp;
4    public long solve(int n,int goal,int k){
5        if(goal==0){
6            return n==0?1:0;
7        }
8        if(n<0) return 0;
9
10        if(dp[n][goal]!=null){
11            return dp[n][goal];
12        }
13
14        long pick=(solve(n-1,goal-1,k)*n)%mod;
15        long nopick=(solve(n,goal-1,k)*Math.max(n-k,0))%mod;
16        
17        return dp[n][goal]=(pick+nopick)%mod;
18    }
19    
20    public int numMusicPlaylists(int n, int goal, int k) {
21        //old+new
22        dp=new Long[n+1][goal+1];
23        // for(long[] r:dp)Arrays.fill(r,-1);
24        return (int)solve(n,goal,k);
25    }
26}