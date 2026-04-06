1class Solution {
2    public int knightDialer(int n) {
3        int mod = 1_000_000_007;
4        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
5        for (int i=0;i<10;i++){
6            adj.add(new ArrayList<>());
7        }
8        adj.get(0).add(4); adj.get(0).add(6);
9        adj.get(1).add(6); adj.get(1).add(8);
10        adj.get(2).add(7); adj.get(2).add(9);
11        adj.get(3).add(4); adj.get(3).add(8);
12        adj.get(4).add(0); adj.get(4).add(3); adj.get(4).add(9);
13        
14        adj.get(6).add(0); adj.get(6).add(1); adj.get(6).add(7);
15        adj.get(7).add(2); adj.get(7).add(6);
16        adj.get(8).add(1); adj.get(8).add(3);
17        adj.get(9).add(2); adj.get(9).add(4);
18
19        return solve(adj, n, mod);
20    }
21
22    public static int solve(ArrayList<ArrayList<Integer>> adj, int n, int mod){
23        long[] dp =new long[10];
24        Arrays.fill(dp,1);
25        for (int step=2;step<=n;step++){
26            long[] newDp =new long[10];
27            for (int j=0;j<10;j++){
28                for (int next : adj.get(j)){
29                    newDp[next] =(newDp[next]+dp[j])%mod;
30                }
31            }
32            dp =newDp;
33        }
34        long ans=0;
35        for (long val : dp){
36            ans =(ans+val)%mod;
37        }
38        return (int) ans;
39    }
40}