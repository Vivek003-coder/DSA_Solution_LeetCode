1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        int n=graph.length;
4        List<List<Integer>> adj=new ArrayList<>();
5        int[] indegree=new int[n];
6        for(int i=0;i<n;i++){
7            adj.add(new ArrayList<>());
8        }
9        for(int i=0;i<n;i++){
10            for(int ele : graph[i]){
11                // in Original graph,edge is from i -> ele
12                // in reverse graph,it will be ele -> i
13                adj.get(ele).add(i);
14                indegree[i]++;
15            }
16        }
17        //Kahn's Algorithm
18        Queue<Integer> q=new LinkedList<>();
19        List<Integer> ans=new ArrayList<>();
20        for(int i=0;i<n;i++){
21            if(indegree[i]==0){
22                q.offer(i);
23            }
24        }
25        while(!q.isEmpty()){
26            int curr=q.poll();
27            ans.add(curr);
28            for(int ele : adj.get(curr)){
29                indegree[ele]--;
30                if(indegree[ele] == 0){
31                    q.offer(ele);
32                }
33            }
34        }
35        Collections.sort(ans);
36        return ans;
37    }
38}