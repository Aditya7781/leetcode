class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length; // Get the size of the grid
        int first_min = Integer.MAX_VALUE, second_min = Integer.MAX_VALUE; // Initialize first and second minimums
        int first_index = -1, second_index = -1; // Initialize indices for the first and second minimums

        for (int i = 0; i < n; i++) { // Iterate through each row of the grid
            if (i != 0) { // For rows after the first one
                for (int j = 0; j < n; j++) { // Update the grid values based on the previous row's minimums
                    if (j != first_index)
                        grid[i][j] += first_min;
                    else
                        grid[i][j] += second_min;
                }
            }

            first_min = Integer.MAX_VALUE;
            second_min = Integer.MAX_VALUE; // Reset first and second minimums for the current row

            for (int j = 0; j < n; j++) { // Iterate through each element of the current row
                // Update first and second minimums and their indices
                if (grid[i][j] < first_min) {
                    second_min = first_min;
                    first_min = grid[i][j];
                    first_index = j;
                } else if (grid[i][j] < second_min) {
                    second_min = grid[i][j];
                    second_index = j;
                }
            }
        }

        return Math.min(first_min, second_min); // Return the minimum of the first and second minimums
    }
}