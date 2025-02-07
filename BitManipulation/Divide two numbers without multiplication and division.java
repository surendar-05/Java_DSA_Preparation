class Solution {
    /* Function to divide two numbers
    without multiplication and division */
    public int divide(int dividend, int divisor) {
        
        // Base case
        if(dividend == divisor) return 1;
        
        // Variable to store the sign of result
        boolean isPositive = true;
        
        // Updating the sign of quotient
        if(dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if(dividend < 0 && divisor > 0)
            isPositive = false;
            
        // Storing absolute dividend & divisor
        int n = Math.abs(dividend);
        int d = Math.abs(divisor);
        
        // Variable to store the answer
        int ans = 0;
        
        /* Looping while dividend is 
        greater than equal to divisor */
        while(n >= d) {
            int count = 0;
            
            /* Finding the required 
            largest power of 2 */
            while(n >= (d << (count+1))) {
                count++;
            }
            
            // Updating the answer & dividend
            ans += (1 << count);
            n -= d*(1 << count);
        }
        
        // Handling overflowing condition
        if(ans > Integer.MAX_VALUE && isPositive) 
            return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;
        
        /* Returning the quotient 
        with proper sign */
        return isPositive ? ans : -1*ans;
    }
    
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        
        /* Creating an instance of 
        Solution class */
        Solution sol = new Solution(); 
        
        /* Function call to divide two numbers
        without multiplication and division */
        int ans = sol.divide(dividend, divisor);
        
        System.out.println("The result of dividing " + dividend + " and " + divisor + " is " + ans);
    }
}
