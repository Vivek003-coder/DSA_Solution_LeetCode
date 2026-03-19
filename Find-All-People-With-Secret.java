1class DSU {
2    int[] parent;
3    int[] rank;
4    DSU(int n) {
5        parent = new int[n + 1];
6        rank = new int[n + 1];
7        for (int i = 0; i <= n; i++) {
8            parent[i] = i;
9            rank[i] = 0;
10        }
11    }
12    int findParent(int node) {
13        if (node == parent[node]) {
14            return node;
15        }
16        parent[node] = findParent(parent[node]);
17        return parent[node];
18    }
19    void resetNode(int node) {
20        parent[node] = node;
21        rank[node] = 0;
22    }
23    void unionNodes(int node1, int node2) {
24        int parent1 = findParent(node1);
25        int parent2 = findParent(node2);
26        if (parent1 == parent2) {
27            return;
28        }
29        if (rank[parent1] > rank[parent2]) {
30            parent[parent2] = parent1;
31        } 
32        else if (rank[parent1] < rank[parent2]) {
33            parent[parent1] = parent2;
34        } 
35        else {
36            parent[parent1] = parent2;
37            rank[parent2]++;
38        }
39    }
40}
41class Solution {
42    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
43        List<Integer> ans = new ArrayList<>();
44        Arrays.sort(meetings ,(a,b) -> a[2]-b[2]);
45        // Arrays.sort(meetings, (a, b) -> {
46        //     if (a[2] == b[2]) {
47        //         return a[0] - b[0];
48        //     }
49        //     return a[2] - b[2];
50        // });
51        DSU dsu = new DSU(n);
52        dsu.unionNodes(0, firstPerson);
53        for (int i = 0; i < meetings.length; ) {
54            int time = meetings[i][2];
55            List<Integer> people = new ArrayList<>();
56            while (i < meetings.length && meetings[i][2] == time) {
57                int a = meetings[i][0];
58                int b = meetings[i][1];
59                dsu.unionNodes(a, b);
60                people.add(a);
61                people.add(b);
62                i++;
63            }
64            for (int person : people) {
65                if (dsu.findParent(person) != dsu.findParent(0)) {
66                    dsu.resetNode(person);
67                }
68            }
69        }
70        for (int i = 0; i < n; i++) {
71            if (dsu.findParent(i) == dsu.findParent(0)) {
72                ans.add(i);
73            }
74        }
75        return ans;
76    }
77}