1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        for (int i = 0; i < 4; i++) {
4            if (isEqual(mat, target)) return true;
5            rotate(mat);
6        }
7        return false;
8    }
9
10    private void rotate(int[][] mat) {
11        int n = mat.length;
12        for (int i = 0; i < n; i++) {
13            for (int j = i + 1; j < n; j++) {
14                int temp = mat[i][j];
15                mat[i][j] = mat[j][i];
16                mat[j][i] = temp;
17            }
18        }
19        for (int i = 0; i < n; i++) {
20            for (int j = 0; j < n / 2; j++) {
21                int temp = mat[i][j];
22                mat[i][j] = mat[i][n - 1 - j];
23                mat[i][n - 1 - j] = temp;
24            }
25        }
26    }
27
28    private boolean isEqual(int[][] mat, int[][] target) {
29        for (int i = 0; i < mat.length; i++) {
30            for (int j = 0; j < mat[0].length; j++) {
31                if (mat[i][j] != target[i][j]) return false;
32            }
33        }
34        return true;
35    }
36}