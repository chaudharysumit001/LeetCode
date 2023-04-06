class Solution {
    public int closedIsland(int[][] grid) {
        int answer = 0;
        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0, m = grid[0].length; j < m; j++) {
                if (grid[i][j] == 0) {
                    if (checkClosed(grid, i, j, 1) == 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public int checkClosed(int[][] grid, int i, int j, int check) {
        grid[i][j] = -1;
        if (i - 1 < 0 || i + 1 == grid.length || j - 1 < 0 || j + 1 == grid[0].length) {
            check = -1;
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 0) {
            check = checkClosed(grid, i - 1, j, check);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 0) {
            check = checkClosed(grid, i + 1, j, check);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 0) {
            check = checkClosed(grid, i, j - 1, check);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
            check = checkClosed(grid, i, j + 1, check);
        }
        return check;
    }
}