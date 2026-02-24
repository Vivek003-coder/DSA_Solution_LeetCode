1class Solution {
2    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
3        int m=edges.length;
4        List<List<int[]>> adj=new ArrayList<>();
5        for(int i=0;i<n;i++){
6            adj.add(new ArrayList<>());
7        }
8        for(int[] edge: edges){
9            int from=edge[0];
10            int to=edge[1];
11            int wt=edge[2];
12            adj.get(from).add(new int[]{to,wt});
13            adj.get(to).add(new int[]{from,wt});
14        }
15
16        PriorityQueue<int[]> q =new PriorityQueue<>((a,b) -> a[0] - b[0]);
17        int[] vist=new int[n];
18        Arrays.fill(vist,Integer.MAX_VALUE);
19        if(disappear[0]==0){
20            Arrays.fill(vist,-1);
21            return vist;
22        }
23        vist[0]=0;
24        q.offer(new int[]{0,0}); //{time,srcNode}
25
26        while(!q.isEmpty()){
27            int[] curr=q.poll();
28            int time=curr[0];
29            int node=curr[1];
30            
31            if(time>vist[node]){
32                continue;
33            }
34            for(int[] ele : adj.get(node)){
35                int nextnode=ele[0];
36                int weight=ele[1];
37                int newtime=time+weight;
38
39                if(newtime<vist[nextnode] && newtime<disappear[nextnode]){
40                    vist[nextnode]=newtime;
41                    q.offer(new int[]{newtime,nextnode});
42                }
43            }
44        }
45        for(int i=0;i<n;i++){
46            if(vist[i]==Integer.MAX_VALUE){
47                vist[i]=-1;
48            }
49        }
50        return vist;
51    }
52}