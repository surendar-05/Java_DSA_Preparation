import java.util.*;

class Solution {
    /* Function to calculate the maximum
    sum of nonAdjacent elements*/
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            // Maximum sum if we pick current element
            int pick = nums[i];
            
            if (i > 1) {
                // Add the maximum sum two elements ago
                pick += prev2;
            }
            // Maximum sum if we don't pick current element
            int nonPick = 0 + prev;

            // Maximum at the current element
            int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev = cur_i;
        }
        // Return the maximum sum
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the solve function and print the result
        System.out.println(sol.nonAdjacent(arr));
    }
}
