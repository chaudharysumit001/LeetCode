class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        // initalise queue
        queue<int> q;
        q.push(source);

        // build neighbour map
        unordered_map<int, unordered_set<int>> neighbours;
        for(auto& edge : edges){
            neighbours[edge[0]].insert(edge[1]);
            neighbours[edge[1]].insert(edge[0]);
        }

        // bfs
        unordered_set<int> visited;  // track visited nodes 
        while(!q.empty()){

            // get next node in queue
            int node = q.front();
            q.pop();

            // node visited
            visited.insert(node);

            // check for destination
            if(node == destination) return true;

            // add all connections to queue
            for(auto& neighbour : neighbours[node]){
                if(neighbour != node && visited.find(neighbour) == visited.end())
                    q.push(neighbour);
            }
        }

        return false;
    }
};
