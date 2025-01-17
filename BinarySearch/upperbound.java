class Solution {
    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        // Binary search to find the upper bound
        while (low <= high) {
            // Calculate mid index
            int mid = (low + high) / 2;

            /* Update ans if current
               element is greater than x */
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            } 
            // Otherwise, move to the right half
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
