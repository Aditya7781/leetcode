class Solution {
    private static int colSize;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        colSize = matrix[0].length;
        return binSearch(matrix, target, 0, matrix[0].length*matrix.length - 1);
    }
    
    private int getRow(int flatCoord) {
        return flatCoord / colSize;
    }
    
    private int getCol(int flatCoord) {
        return flatCoord % colSize;
    }
    
    private boolean binSearch(int[][] matrix, int target, int beg, int end) {
        if (beg > end) {
            return false;
        }
        if (beg == end) {
            return (matrix[getRow(beg)][getCol(beg)] == target);
        }
        int mid = (beg + end) / 2;
        int row = getRow(mid);
        int col = getCol(mid);
        
        if (matrix[row][col] > target) { 
			// recursive search left half
            return binSearch(matrix, target, beg, mid - 1);
        } else if (matrix[row][col] < target) { 
			// recursive search right half
            return binSearch(matrix, target, mid + 1, end);
        }
        return true;
    }
}