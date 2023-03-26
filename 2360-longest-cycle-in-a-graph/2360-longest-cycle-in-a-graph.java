class Solution {
    public int longestCycle(int[] edges) {

        // Enhanced visited flag that records batch wise visits
        final var visited = new int[edges.length];

        // Record the distance to the node in given index
        final var distance = new int[edges.length];

        // Max cycle length so far
        int max = -1;

        // Current running batch
        int batch = 0;
        for(int i=0; i<edges.length; i++) {
            if(edges[i] >= 0) {

                // Increment the batch every time new cycle detection starts
                batch++;

                // Local distance counter
                int d = 0;

                visited[i] = batch;
                distance[i] = d++;
                int next = edges[i];
                while (next != -1) {
                    // visited = 0 means that node is not visited in any batch yet
                    if(visited[next] == 0) {
                        visited[next] = batch;
                        distance[next] = d++;
                        next = edges[next];
                    }
                    
                    // Check if this node is already visited in this batch
                    else if(visited[next] == batch){
                        int cycle = d - distance[next];
                        max = Math.max(max, cycle);
                        break;
                    }
                    
                    // If the node is already visited in previous batches then terminate the cycle detection
                    else{
                        break;
                    }
                }
            }
        }
        return max;
    }
}