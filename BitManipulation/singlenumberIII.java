import java.util.*;

class Solution {
    /* Function to get the single 
    numbers in the given array */
    public int[] singleNumber(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Variable to store XOR of all elements
        long XOR = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            // Update the XOR
            XOR = XOR ^ nums[i];
        }
        
        /* Variable to get the rightmost 
        set bit in overall XOR */
        int rightmost = (int)(XOR & (XOR - 1)) ^ (int)XOR;
        
        /* Variables to stores XOR of
        elements in bucket 1 and 2 */
        int XOR1 = 0, XOR2 = 0;
        
        // Traverse the array
        for(int i=0; i < n; i++) {
            /* Divide the numbers among bucket 1
             and 2 based on rightmost set bit */
            if((nums[i] & rightmost) != 0) {
                XOR1 = XOR1 ^ nums[i];
            }
            else {
                XOR2 = XOR2 ^ nums[i];
            }
        }
        
        // Return the result in sorted order
        if(XOR1 < XOR2) return new int[]{XOR1, XOR2};
        return new int[]{XOR2, XOR1};
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 2};
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution();
        
        /* Function call to get the single 
        numbers in the given array */
        int[] ans = sol.singleNumber(nums);
        
        System.out.println("The single numbers in given array are: " + ans[0] + " and " + ans[1]);
    }
}
