class Solution {
    public int numOfSubarrays(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int MOD = 1000000007;
        map.put(0,1);
        int prefix =0;
        long count=0;
        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];
            int even = prefix%2;
            if(even==0){
                if(map.containsKey(1)){
                    count+=map.get(1);
                }
            }else{
                if(map.containsKey(0)){
                    count+=map.get(0);
                }
            }
            map.put(even, map.getOrDefault(even,0)+1);
            count %= MOD;
        }
        return (int)count;
    }
}