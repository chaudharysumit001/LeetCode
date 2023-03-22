class Solution {
    public int minScore(int n, int[][] roads) {
        boolean vis[] = new boolean[n+1];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int r[] : roads){
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }
        Queue<Integer> q = new LinkedList<>();
        vis[1] = true;
        int min = Integer.MAX_VALUE;
        q.offer(1);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int[] it : adj.get(node)){
                min = Math.min(min, it[1]);
                if(!vis[it[0]]){
                    vis[it[0]] = true;
                    q.offer(it[0]);
                }
            }
        }
        return min;
    }
}