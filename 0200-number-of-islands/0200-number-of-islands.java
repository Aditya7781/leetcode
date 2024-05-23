import java.util.*;

class Solution {
    public void bfs(int row, int col, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;    // starting point
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            // traverse in the neighbours and mark them in vis
            for (int deltarow = -1; deltarow <= 1; deltarow++) {
                for (int deltacol = -1; deltacol <= 1; deltacol++) {
                    int nrow = r + deltarow;     // neighbour_row
                    int ncol = c + deltacol;     // neighbour_col
                    // check for out of bound cases - abs waali condition striver missed 
                    if ((Math.abs(deltarow - deltacol) == 1) && nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                            grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return count;
    }
}