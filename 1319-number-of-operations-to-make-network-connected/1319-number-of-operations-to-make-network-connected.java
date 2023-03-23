class Solution {
    public int makeConnected(int n, int[][] a) {
        if(a.length<(n-1))return -1;
        List<List<Integer>> arr= new ArrayList<>();
        
        // just find the number of connected components 
        for(int i=0;i<n;i++)arr.add(new ArrayList<>());
        for(int x[]:a){
            arr.get(x[0]).add(x[1]);
            arr.get(x[1]).add(x[0]);
        }
        int cnt=0;
        boolean vis[]=new boolean [n];
        for(int i=0;i<n;i++){
            if(vis[i])continue;
            cnt++;
            bfs(arr,i,vis);
        }
        return cnt-1;
        
    }
    public void bfs(List<List<Integer>> a,int node,boolean vis[]){
        vis[node]=true;
        for(int it:a.get(node)){
            if(vis[it])continue;
            bfs(a,it,vis);
        }
    }
}