import java.util.*;

class Solution {
    /* Function to find the minimum 
    energy to reach the last stair*/
    public int frogJump(int[] heights, int k) {
        int ind = heights.length;
        
        /* Initialize a memoization array
        to store calculated results*/
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);
        
        dp[0] = 0; 
        
        // Loop through the array
        for (int i = 1; i < ind; i++) {
            int mmSteps = Integer.MAX_VALUE;
            
            // Loop to try all possible jumps from 1 to k
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    
                    //Update the minimum energy
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            
            dp[i] = mmSteps;
        }
        
        // Result is stored in the last element of dp
        return dp[ind - 1];
    }
    
    public static void main(String[] args) {
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        // Print the answer
        System.out.println("Minimum energy: " + sol.frogJump(heights, k));
    }
}
