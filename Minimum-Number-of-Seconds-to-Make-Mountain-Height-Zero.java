1import java.util.Arrays;
2
3class Solution {
4    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
5        Arrays.sort(workerTimes);
6        
7        long lowTime = 0;
8        long highTime = (long) 1e16; 
9        long minRequiredTime = highTime;
10        
11        // Outer Binary Search: Finding the minimum required time
12        while (lowTime <= highTime) {
13            long midTime = lowTime + (highTime - lowTime) / 2;
14            long totalHeightReduced = 0;
15            
16            for (int baseTime : workerTimes) {
17                // Inner Binary Search: Finding max height THIS worker can reduce in 'midTime'
18                long lowHeight = 0;
19                long highHeight = mountainHeight;
20                long maxWorkerHeight = 0;
21                
22                while (lowHeight <= highHeight) {
23                    long midHeight = lowHeight + (highHeight - lowHeight) / 2;
24                    
25                    // Crucial: Cast to long BEFORE multiplying to prevent 32-bit overflow
26                    long timeNeeded = (long) baseTime * midHeight * (midHeight + 1) / 2;
27                    
28                    if (timeNeeded <= midTime) {
29                        maxWorkerHeight = midHeight;
30                        lowHeight = midHeight + 1;
31                    } else {
32                        highHeight = midHeight - 1;
33                    }
34                }
35                
36                totalHeightReduced += maxWorkerHeight;
37                
38                // Early Exit Optimization
39                if (totalHeightReduced >= mountainHeight) {
40                    break;
41                }
42            }
43            
44            // Adjust outer binary search bounds
45            if (totalHeightReduced >= mountainHeight) {
46                minRequiredTime = midTime;
47                highTime = midTime - 1;
48            } else {
49                lowTime = midTime + 1;
50            }
51        }
52        
53        return minRequiredTime;
54    }
55}