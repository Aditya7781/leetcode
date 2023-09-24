class Solution {
    Double dp[][];

    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new Double[query_row + 1][query_row + 1];

        double champagneAmount = getChampagne(poured, query_row, query_glass);
        return champagneAmount > 1 ? 1 : champagneAmount;
    }

    private double getChampagne(int poured, int row, int col) {
        if (row < col || col < 0 || row < 0) {
            return 0;
        }

        if (row == 0 && col == 0) {
            return poured;
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        double leftTop = (getChampagne(poured, row - 1, col - 1) - 1) / 2.0;
        double rightTop = (getChampagne(poured, row - 1, col) - 1) / 2.0;

        if (leftTop < 0) {
            leftTop = 0;
        }

        if (rightTop < 0) {
            rightTop = 0;
        }

        return dp[row][col] = leftTop + rightTop;
    }
}