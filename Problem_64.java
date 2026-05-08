class Solution {
    public int uniquePaths(int m, int n) {
        // Total moves = (m-1) downs + (n-1) rights
        int totalMoves = m + n - 2;
        int movesDown = m - 1;  // or movesRight = n - 1

        long result = 1;
        // Compute nCr = (totalMoves choose movesDown)
        for (int i = 1; i <= movesDown; i++) {
            result = result * (totalMoves - movesDown + i) / i;
        }

        return (int) result;
    }
}