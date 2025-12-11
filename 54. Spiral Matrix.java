class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int r=matrix.length;
        int c=matrix[0].length;
        int tr=0,br=r-1,lc=0,rc=c-1,total =0;
        while(total <r*c){
            for(int j=lc; j<=rc && total <r*c;j++){
                ans.add(matrix[tr][j]);
                total++;
            }
            tr++;
            for(int i=tr; i<=br && total <r*c;i++){
                ans.add(matrix[i][rc]);
                total++;
            }
            rc--;
            for(int j=rc; j>=lc && total <r*c;j--){
                ans.add(matrix[br][j]);
                total++;
            }
            br--;
            for(int i=br; i>=tr && total <r*c;i--){
                ans.add(matrix[i][lc]);
                total++;
            }
            lc++;
        }
        return ans;
    }
}