import java.util.Arrays;

class Solution {
    /* Function to calculate the maximum
    points for the ninja training*/
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

         /* Initialize a vector to store the maximum
        points for the previous day's activities*/
        int[] prev = new int[4];

        // Initialize the prev array for the first day (day 0)
        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Iterate through the days starting from day 1
        for (int day = 1; day < n; day++) {
            /* Initialize a temporary vector to store the
            maximum points for the current day's activities*/
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                // Iterate through the tasks for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        /* Calculate the points for the current activity
                        and add it to the maximum points obtained on the
                        previous day (stored in prev)*/
                        temp[last] = Math.max(temp[last], matrix[day][task] + prev[task]);
                    }
                }
            }

            // Update prev with maximum points for the current day
            prev = temp;
        }

        /* The maximum points for the last day with 
        any activity can be found in prev[3]*/
        return prev[3];
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Print the maximum points for ninja training
        System.out.println(sol.ninjaTraining(points)); 
    }
}
