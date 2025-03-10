class Solution {
    // Function to solve the problem using tabulation
    private int func(int m, int n, int[][] matrix, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Base conditions
                if (matrix[i][j] == 1) {
                    /* If there's an obstacle at the 
                    cell, no paths can pass through it*/
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    /* If we are at the starting
                    point, there is one path to it*/
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                /* Check if we can move up and left 
                (if not at the edge of the maze)*/
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                /* Total number of paths to reach (i, j) 
                is the sum of paths from above and left*/
                dp[i][j] = up + left;
            }
        }

        /* The final result is stored in dp[n-1][m-1],
        which represents the destination*/
        return dp[n - 1][m - 1];
    }

    /* Function to find all unique paths to reach
    matrix[m-1][n-1] from matrix[0][0] with obstacles*/
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix[0].length;    
        int n = matrix.length;       

        // Initialize DP table to memoize results
        int[][] dp = new int[n][m];

        // Return the total number of paths
        return func(m, n, matrix, dp);
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        // Create an instance of Solution class
        Solution sol = new Solution();

        System.out.println("Number of paths with obstacles: " + sol.uniquePathsWithObstacles(maze));
    }
}
