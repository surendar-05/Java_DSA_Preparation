import java.util.*;

class Solution {
    // Function to find the largest rectangle area
    private int largestRectangleArea(int[] heights) {
        
        int n = heights.length; // Size of array
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // To store largest area
        int largestArea = 0;
        
        // To store current area
        int area;
        
        /* To store the indices of next 
        and previous smaller elements */
        int nse, pse;
        
        // Traverse on the array
        for(int i = 0; i < n; i++) {
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            elements is not the smaller element */
            while(!st.isEmpty() && 
                  heights[st.peek()] >= heights[i]){
                      
                // Get the index of top of stack
                int ind = st.pop(); 
                
                /* Update the index of 
                previous smaller element */
                pse = st.isEmpty() ? -1 : st.peek();
                
                /* Next smaller element index for 
                the popped element is current index */
                nse = i;
                
                // Calculate the area of the popped element
                area = heights[ind] * (nse - pse - 1);
                
                // Update the maximum area
                largestArea = Math.max(largestArea, area);
            }
            
            // Push the current index in stack
            st.push(i);
        }
        
        // For elements that are not popped from stack
        while(!st.isEmpty()) {
            
            // NSE for such elements is size of array
            nse = n;
            
            // Get the index of top of stack
            int ind = st.pop(); 
            
            // Update the previous smaller element
            pse = st.isEmpty() ? -1 : st.peek();
            
            // Calculate the area of the popped element
            area = heights[ind] * (nse - pse - 1);
            
            // Update the maximum area
            largestArea = Math.max(largestArea, area);
        }
        
        // Return largest area found
        return largestArea;
    }
    
    /* Function to find the largest 
    rectangle area containing all 1s */ 
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix){
        
        // Determine the size of matrix
        int n = matrix.length;
        int m = matrix[0].length;
        
        /* Prefix sum matric to store heights 
        for different ground levels */
        int[][] prefixSum = new int[n][m];
        
        // Fill up the prefix sum matrix column wise
        for(int j = 0; j < m; j++) {
            int sum = 0;
            
            for(int i = 0; i < n; i++) {
                sum += matrix[i][j];
                
                // If there is no base present
                if(matrix[i][j] == 0) {
                    prefixSum[i][j] = 0;
                    sum = 0;
                } else {
                    // Store the height
                    prefixSum[i][j] = sum;
                }
            }
        }
        
        // To store the maximum area
        int maxArea = 0;
        
        // Traverse for different levels of ground
        for(int i = 0; i < n; i++) {
            
            // Get the largest area for current level
            int area = largestRectangleArea(prefixSum[i]);
            
            // Update the maximum area
            maxArea = Math.max(area, maxArea);
        }
        
        // Return the maximum area
        return maxArea;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 0, 0}, 
            {1, 0, 1, 1, 1}, 
            {1, 1, 1, 1, 1}, 
            {1, 0, 0, 1, 0}
        };
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution(); 
        
        /* Function call to find the largest 
        rectangle area containing all 1s */
        int ans = sol.maximalAreaOfSubMatrixOfAll1(matrix);
        
        System.out.println("The largest rectangle area containing all 1s is: " + ans);
    }
}
