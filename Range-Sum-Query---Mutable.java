1class NumArray {
2
3    SegmentTree seg;
4
5    public NumArray(int[] nums) {
6        if (nums.length > 0) {
7            seg = new SegmentTree(nums);
8        }
9    }
10    
11    public void update(int index, int val) {
12        seg.update(0, 0, seg.n - 1, index, val);
13    }
14    
15    public int sumRange(int left, int right) {
16        return seg.Query(0, 0, seg.n - 1, left, right);
17    }
18}
19
20class SegmentTree{
21    int[] tree;
22    int n;
23
24    SegmentTree(int[] arr){
25        n=arr.length;
26        tree=new int[4*n];
27        build(arr,0,0,n-1);
28    }
29
30    void build(int[] arr,int node,int start, int end){
31        if(start == end){
32            tree[node]=arr[start];
33        }else{
34            int mid=(start+end)/2;
35            build(arr,2*node+1,start,mid);
36            build(arr,2*node+2,mid+1,end);
37            tree[node]=tree[2*node+1]+tree[2*node+2];
38        }
39    }
40
41    int Query(int node,int start,int end,int l,int r){
42        if(r<start || end <l){
43            return 0;
44        }
45        if(l<=start && end <=r){
46            return tree[node];
47        }
48        int mid=(start+end)/2;
49        int left=Query(2*node+1,start,mid,l,r);
50        int right=Query(2*node+2,mid+1,end,l,r);
51        return left+right;
52    }
53
54    void update(int node,int start,int end,int idx,int val){
55        if(start==end){
56            tree[node]=val;
57        }
58        else{
59            int mid=(start+end)/2;
60            if(idx<=mid){
61                update(2*node+1,start,mid,idx,val);
62            }
63            else{
64                update(2*node+2,mid+1,end,idx,val);
65            }
66            tree[node]=tree[2*node+1]+tree[2*node+2];
67        }
68    }
69}