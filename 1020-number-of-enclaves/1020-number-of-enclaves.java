class Solution {
    boolean[][] visited;
    int[] i1 = new int[]{0,-1,0,1};
    int[] j1 = new int[]{-1,0,1,0};
    int count =0;
    int m, n;;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        //top row
        for(int i=0,j=0;j<n;j++){
            runDfs(i,j,grid);
        }
        //bottom row
        for(int i=m-1,j=0;j<n;j++){
            runDfs(i,j,grid);
        }
        //left col
        for(int i=0,j=0;i<m;i++){
            runDfs(i,j,grid);
        }
        //right col
        for(int i=0,j=n-1;i<m;i++){
            runDfs(i,j,grid);
        }

        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1)count++;
            }
        }
        return count;
    }

    public void runDfs(int i, int j, int[][] grid){
        if(!visited[i][j] && grid[i][j]==1){
            visited[i][j] = true;
            dfs(i,j, grid);
        } 
    }

    public void dfs(int i, int j, int[][] grid){
        for(int x=0;x<4;x++){
            int nextI = i1[x]+i;
            int nextJ = j1[x]+j;
            if(nextI<0||nextI==m||nextJ<0||nextJ==n ||visited[nextI][nextJ]) continue;
            visited[nextI][nextJ]=true;
            if(grid[nextI][nextJ]==1){
                grid[nextI][nextJ] = 0;
                dfs(nextI, nextJ, grid);
            }
        }

    }
}