class Solution {

    private boolean checkAllZeroes(List<Integer> list) {
        for (int val : list) {
            if (val != 0) return false;
        }
        return true;
    }

    private int preorder(int root, List<List<Integer>> adj, List<Boolean> hasApple, boolean[] visited) {
        visited[root] = true;
        int left = 0, right = 0;
        List<Integer> childValues = new ArrayList<>();
        for (int v : adj.get(root)) {
            if (visited[v]) continue;
            childValues.add(preorder(v, adj, hasApple, visited));
        }
        int sum = 0;
        for (int v : childValues) {
            if (v <= 1) v *= 2;
            else v += 2;
            sum += v;
        }
        return (sum == 0 && hasApple.get(root)) ? 1 : sum;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int value = preorder(0, adj, hasApple, visited);
        return value == 1 ? 0 : value;
    }
}