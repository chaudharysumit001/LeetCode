class Solution {
    //TC: O(n) SC: O(n)
    private int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> map = new HashMap();
        for(int[] conn : connections){
            map.putIfAbsent(conn[0], new ArrayList<List<Integer>>());
            map.putIfAbsent(conn[1], new ArrayList<List<Integer>>());
            map.get(conn[0]).add(Arrays.asList(conn[1], 1));
            map.get(conn[1]).add(Arrays.asList(conn[0], 0));
        }
        
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(!map.containsKey(curNode))
                continue;

            for(List<Integer> neighbor : map.get(curNode)){
                int next = neighbor.get(0);
                int sign = neighbor.get(1);
                if(!visited.contains(next)){
                    count += sign;
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}