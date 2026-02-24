1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
4        for(int i=0;i<n;i++){
5            adj.add(new ArrayList<>());
6        }
7        for(int[] e: flights){
8            adj.get(e[0]).add(new int[]{e[1],e[2]});
9        }
10
11        int[] stop=new int[n];
12        Arrays.fill(stop,Integer.MAX_VALUE);
13        Queue<int[]>q=new LinkedList<>();
14        q.offer(new int[]{0,src});
15        stop[src]=0;
16        int stat=0;
17
18        while(!q.isEmpty() && stat<=k){
19            int size=q.size();
20            for(int i=0;i<size;i++){
21                int[] curr=q.poll();
22                int currcost=curr[0];
23                int node=curr[1];
24                for(int[] ele : adj.get(node)){
25                    int NN=ele[0];
26                    int cost=ele[1];
27                    if(cost+currcost<stop[NN]) {
28                        stop[NN]=cost+currcost;
29                        q.offer(new int[]{stop[NN],NN});
30
31                    }
32                }
33            }
34        stat++;
35        }
36        return stop[dst]==Integer.MAX_VALUE?-1:stop[dst];
37    }
38}