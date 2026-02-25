1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        List<List<int[]>> adj=new ArrayList<>();
4        for(int i=0;i<n+1;i++){
5            adj.add(new ArrayList<>());
6        }
7        for(int[] ele : times){
8            adj.get(ele[0]).add(new int[]{ele[1],ele[2]});
9        }
10
11        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->a[0]-b[0]);
12        int[] vis=new int[n+1];
13        Arrays.fill(vis,Integer.MAX_VALUE);
14        q.offer(new int[]{0,k}); //{time,node}
15        vis[k]=0;
16
17        while(!q.isEmpty()){
18            int[] curr=q.poll();
19            int currtime=curr[0];
20            int node=curr[1];
21
22            if(currtime>vis[node]) continue;
23            for(int[] ele : adj.get(node)){
24                int currnode=ele[0];
25                int time=ele[1];
26                if(currtime+time<vis[currnode]){
27                    vis[currnode]=currtime+time;
28                    q.offer(new int[]{vis[currnode],currnode});
29                }
30            }
31        }
32        int maxD=0;
33        for(int i=1;i<n+1;i++){
34            if(vis[i]==Integer.MAX_VALUE){
35                return -1;
36            }
37            maxD=Math.max(maxD,vis[i]);
38        }
39        return maxD;
40    }
41}