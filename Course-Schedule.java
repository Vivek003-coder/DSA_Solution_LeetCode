1class Solution {
2    public boolean canFinish(int n, int[][] prerequisites) {
3        int m=prerequisites.length;
4        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
5        int[] indegree=new int[n];
6        boolean[] vis=new boolean[n];
7
8        for(int i=0;i<n;i++){
9            adj.add(new ArrayList<>());
10        }
11        for(int i=0;i<m;i++){
12            int a =prerequisites[i][0];
13            int b =prerequisites[i][1];
14            adj.get(b).add(a);
15            indegree[a]++;
16        }
17        // Kahn's Algorithm
18        Queue<Integer> q=new LinkedList<>();
19        List<Integer> ans=new ArrayList<>();
20        for(int i=0;i<n;i++){
21            if(indegree[i]==0){
22                q.offer(i);
23                vis[i]=true;
24            }
25        }
26        while(!q.isEmpty()){
27            int curr=q.poll();
28            ans.add(curr);
29            for(int ele : adj.get(curr)){
30                indegree[ele]--;
31                if(indegree[ele] == 0){
32                    q.offer(ele);
33                    vis[ele]=true;
34                }
35            }
36        }
37        if(ans.size()==n){
38            return true;
39        }else{
40            return false;
41        }
42    }
43}