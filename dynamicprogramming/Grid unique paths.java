class Solution {
    // Function to solve the problem using space optimization
    int func(int m, int n) {
        /* Create an array to represent 
        the previous row of the grid*/
        int[] prev = new int[n];

        // Iterate through the rows of the grid
        for (int i = 0; i < m; i++) {
            /* Initialize a temporary array to
            represent the current row*/
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

            
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;

               
                temp[j] = up + left;
            }

          
            prev = temp;
        }

        
        return prev[n - 1];
    }

  
    public int uniquePaths(int m, int n) {
       
        return func(m, n);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

      
        Solution sol = new Solution();

       
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }
}
