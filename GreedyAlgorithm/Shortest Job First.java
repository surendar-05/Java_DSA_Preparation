import java.util.*;

class Solution {
    /* Function to calculate total waiting 
       time using Shortest Job First algorithm */
    public long solve(int[] bt) {
        // Sort jobs in ascending order
        Arrays.sort(bt);

        // Initialize total waiting time
        long waitTime = 0;
        // Initialize total time taken
        long totalTime = 0;
        // Get number of jobs
        int n = bt.length;

        // Iterate to calculate waiting time
        for (int i = 0; i < n; ++i) {
            waitTime += totalTime;
            totalTime += bt[i];
        }

        // Return average waiting time
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 4};

        System.out.print("Array Representing Job Durations: ");
        for (int job : jobs) {
            System.out.print(job + " ");
        }
        System.out.println();

        Solution solution = new Solution();
        long ans = solution.solve(jobs);
        System.out.println("Total waiting time: " + ans);
    }
}
