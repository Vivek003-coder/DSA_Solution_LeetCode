1class Solution {
2    public void BFS(int node, int[] dist, int[] e, int n){
3        Queue<Integer> q=new LinkedList<>();
4        q.offer(node);
5        dist[node]=0;
6        while(!q.isEmpty()){
7            int curr=q.poll();
8            int next = e[curr];
9            if(next != -1 && dist[next] == Integer.MAX_VALUE){
10                dist[next]= dist[curr]+1;
11                q.add(next);
12            }
13        }
14    }
15    public int closestMeetingNode(int[] edges, int node1, int node2) {
16        int n=edges.length;
17        int[] dist1=new int[n];
18        int[] dist2=new int[n];
19        Arrays.fill(dist1,Integer.MAX_VALUE);
20        Arrays.fill(dist2,Integer.MAX_VALUE);
21
22        BFS(node1,dist1,edges,n);
23        BFS(node2,dist2,edges,n);
24
25        int minDist=Integer.MAX_VALUE;
26        int result=-1;
27        for(int i=0;i<n;i++){
28            if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) continue;
29            int maxDist=Math.max(dist1[i],dist2[i]);
30            if(maxDist<minDist){
31                minDist=maxDist;
32                result=i;
33            }
34        }
35        return result;
36    }
37}