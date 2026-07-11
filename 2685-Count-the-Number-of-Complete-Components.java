class Solution {
    static int vertices=0;
    static int degreesum=0;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int from=e[0];
            int to=e[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] visited=new boolean[n];
        int ans=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                vertices=0;
                degreesum=0;

                dfs(i,adj,visited);
                int edgecount=degreesum/2;

                if(edgecount == vertices*(vertices-1)/2){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node]=true;
        vertices++;
        degreesum+=adj.get(node).size();

        for(int next:adj.get(node)){
            if(!visited[next]){
                dfs(next,adj,visited);
            }
        }
    }
}