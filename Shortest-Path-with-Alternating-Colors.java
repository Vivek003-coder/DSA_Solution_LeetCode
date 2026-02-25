1class Solution {
2    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
3        List<List<Integer>> adjred=new ArrayList<>();
4
5        for(int i=0;i<n;i++){
6            adjred.add(new ArrayList<>());
7        }
8        for(int[] edge : redEdges){
9            int from=edge[0];
10            int to=edge[1];
11            adjred.get(from).add(to);
12        }
13
14        List<List<Integer>> adjblue=new ArrayList<>();
15        for(int i=0;i<n;i++){
16            adjblue.add(new ArrayList<>());
17        }
18        for(int[] edge : blueEdges){
19            int from=edge[0];
20            int to=edge[1];
21            adjblue.get(from).add(to);
22        }
23
24        int[] ans=new int[n];
25        Arrays.fill(ans,-1);
26        Queue<int[]>q=new LinkedList<>();
27        boolean[][] vis=new boolean[n][2]; 
28        q.offer(new int[]{0,0,0}); //{node, color, distance} color-red=0
29        q.offer(new int[]{0,1,0}); //{node, color, distance} color-blue=1
30        vis[0][0]=true;
31        vis[0][1]=true;
32
33        while(!q.isEmpty()){
34            int[] curr=q.poll();
35            int node=curr[0];
36            int currcolor=curr[1];
37            int dist=curr[2];
38
39            if(ans[node]==-1){
40                ans[node]=dist;
41            }
42            if(currcolor == 0){
43                for(int nextnode : adjblue.get(node)){
44                    if(!vis[nextnode][1]){
45                        vis[nextnode][1]=true;
46                        q.offer(new int[]{nextnode,1,dist+1});
47                    }
48                }
49            }
50            else{
51                for(int nextnode : adjred.get(node)){
52                    if(!vis[nextnode][0]){
53                        vis[nextnode][0]=true;
54                        q.offer(new int[]{nextnode,0,dist+1});
55                    }
56                }
57            }
58        }
59        return ans;
60    }
61}