1class Solution {
2    public int[] findOrder(int n, int[][] prerequisites) {
3        int m=prerequisites.length;
4        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
5        int[] indegree=new int[n];
6        
7        for(int i=0;i<n;i++){
8            adj.add(new ArrayList<>());
9        }
10        for(int i=0;i<m;i++){
11            int a =prerequisites[i][0];
12            int b =prerequisites[i][1];
13            adj.get(b).add(a);
14            indegree[a]++;
15        }
16        // Kahn's Algorithm
17        Queue<Integer> q=new LinkedList<>();
18        List<Integer> ans=new ArrayList<>();
19        for(int i=0;i<n;i++){
20            if(indegree[i]==0){
21                q.offer(i);
22            }
23        }
24        while(!q.isEmpty()){
25            int curr=q.poll();
26            ans.add(curr);
27            for(int ele : adj.get(curr)){
28                indegree[ele]--;
29                if(indegree[ele] == 0){
30                    q.offer(ele);
31                }
32            }
33        }
34        int[] ans2=new int[ans.size()];
35        for(int i=0;i<ans.size();i++){
36            ans2[i]=ans.get(i);
37        }
38        if(ans.size()!=n){
39            return new int[0];
40        }else{
41            return ans2;
42        }
43    }
44}