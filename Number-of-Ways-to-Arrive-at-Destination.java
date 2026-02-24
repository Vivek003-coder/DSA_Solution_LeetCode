1class Solution {
2    public int countPaths(int n, int[][] roads) {
3        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
4        for(int i=0;i<n;i++){
5            adj.add(new ArrayList<>());
6        }
7        for(int[] i : roads){
8            adj.get(i[0]).add(new int[]{i[1],i[2]});
9            adj.get(i[1]).add(new int[]{i[0],i[2]});
10        }
11        boolean[] vis=new boolean[n];
12        long[] dist=new long[n];
13        Arrays.fill(dist,Long.MAX_VALUE);
14        PriorityQueue<long[]> q =new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
15        q.offer(new long[]{0,0}); //{node, currentDistance}
16        long[] ways=new long[n];
17        int mod=1000000007;
18        vis[0]=true;
19        dist[0]=0;
20        ways[0]=1;
21
22        while(!q.isEmpty()){
23            long[] curr=q.poll();
24            int node=(int)curr[0];
25            long currdist=curr[1];
26            
27            if(currdist > dist[node]) continue;
28                
29            for(int[] ele: adj.get(node)){
30                int next=ele[0];
31                int time=ele[1];
32                long newdist=currdist+time;
33                if(newdist<dist[next]){
34                    dist[next]=newdist;
35                    ways[next]=ways[node];
36                    q.offer(new long[]{next,newdist});
37                }
38                else if(newdist ==dist[next]){
39                    ways[next] =(ways[next]+ways[node])%mod;
40                }
41            }
42        }
43        return (int)(ways[n - 1] % mod);
44    }
45}