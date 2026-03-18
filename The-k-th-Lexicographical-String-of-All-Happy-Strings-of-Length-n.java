1class Solution {
2
3    public String getHappyString(int n, int k) {
4
5        int total = 3 * (1<<(n-1));
6        if(k>total) return "";
7
8        k--;
9        StringBuilder res=new StringBuilder();
10        char last='\0';
11
12        for(int pos=0;pos<n;pos++){
13
14            int branch=1<<(n-pos-1);
15
16            List<Character> choices=new ArrayList<>();
17            for(char c:new char[]{'a','b','c'})
18                if(c!=last) choices.add(c);
19
20            int idx=k/branch;
21            res.append(choices.get(idx));
22            last=choices.get(idx);
23            k%=branch;
24        }
25
26        return res.toString();
27    }
28}