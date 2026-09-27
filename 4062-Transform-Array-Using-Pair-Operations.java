class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sumsource=0;
        long sumstarget=0;

        for(int x:source){
            sumsource+=x;
        }
        for(int x:target){
            sumstarget+=x;
        }
        return sumsource==sumstarget;
    }
}