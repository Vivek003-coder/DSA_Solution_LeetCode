1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> generate(int numRows) {
5        List<List<Integer>> pascal = new ArrayList<>();
6
7        for (int i = 0; i < numRows; i++) {
8            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
9            
10            for (int j = 1; j < i; j++) {
11                int val = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
12                row.set(j, val);
13            }
14            pascal.add(row);
15        }
16        return pascal;
17    }
18}