1class DSU{
2    int[] parent;
3    int[] rank;
4    int count;
5    
6    DSU(int n){
7        parent=new int[n+1];
8        rank=new int[n+1];
9        count=n;
10        for(int i=1;i<=n;i++){
11            parent[i]=i;
12            rank[i]=0;
13        }
14    }
15    int find(int node){
16        if(node == parent[node]){
17            return node;
18        }
19        parent[node]= find(parent[node]);
20        return parent[node];
21    }
22    boolean union(int a,int b){
23        int pa=find(a);
24        int pb=find(b);
25
26        if(pa == pb){
27            return false;
28        }
29        if(rank[pa]>rank[pb]){
30            parent[pb]=pa;
31        }
32        else if(rank[pa]<rank[pb]){
33            parent[pa]=pb;
34        }
35        else{
36            parent[pa]=pb;
37            rank[pb]++;
38        }
39        count--;
40        return true;
41    }
42}
43
44class Solution {
45    public int maxNumEdgesToRemove(int n, int[][] edges) {
46        Arrays.sort(edges,(a,b)->b[0]-a[0]);
47        DSU alice=new DSU(n);
48        DSU bob=new DSU(n);
49
50        int used=0;
51        for(int[] ele : edges){
52            int type=ele[0];
53            int u=ele[1];
54            int v=ele[2];
55            if(type==3){
56                boolean a=alice.union(u,v);
57                boolean b=bob.union(u,v);
58                if(a || b){
59                    used++;
60                }
61            }
62            else if(type==1){
63                if(alice.union(u,v)){
64                    used++;
65                }
66            }
67            else{
68                if(bob.union(u,v)){
69                    used++;
70                }
71            }
72        }
73        if(alice.count !=1 || bob.count !=1){
74            return -1;
75        }
76        return edges.length-used;
77    }
78}