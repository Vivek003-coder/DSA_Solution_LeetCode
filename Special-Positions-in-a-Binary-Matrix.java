1class Solution {
2    public int numSpecial(int[][] mat) {
3        int n = mat.length;
4        int m = mat[0].length;
5        int result=0;
6        for(int i=0; i<n; i++){
7            for(int j=0; j<m; j++){
8                if(mat[i][j]==1){
9                    boolean found = false;
10                    for(int k=0; k<m; k++){
11                        if(mat[i][k]==1 && k!=j){
12                            found = true;
13                            break;
14                        }
15                    }
16                    if(found)break;
17                    for(int k=0; k<n; k++){
18                        if(mat[k][j]==1 && k!=i){
19                            found = true;
20                            break;
21                        }
22                    }
23                    if(found)break;
24                    result++;
25                }
26            }
27        }
28        return result;
29    }
30}