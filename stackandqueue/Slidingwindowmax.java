class Solution {
    // Function to get the maximum sliding window
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length; // Size of array
        
        // To store the answer
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        
        // Deque data structure
        Deque<Integer> dq = new LinkedList<>();
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            
            // Update deque to maintain current window
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }
            
            /* Maintain the monotonic (decreasing) 
            order of elements in deque */
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            
            // Add current element's index to the deque
            dq.offerLast(i);
            
            /* Store the maximum element from 
            the first window possible */
            if (i >= (k - 1)) {
                ans[ansIndex++] = arr[dq.peekFirst()];
            }
        }
        
        // Return the stored result
        return ans;
    }
}
