import java.util.Stack;

class Solution {

    public int[] findnse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findpse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public long sumSubarrayMins(int[] arr) {
        int[] pse = findpse(arr);
        int[] nse = findnse(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long val = left * right * 1L * arr[i];
            total = total +  val;
        }
        return total;
    }

    public int[] findnge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] findpge(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int[] pge = findpge(arr);
        int[] nge = findnge(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            long val = left * right * 1L * arr[i];
            total = total + val;
        }
        return total;
    }

    public long subArrayRanges(int[] arr) {
        return (sumSubarrayMaxs(arr) - sumSubarrayMins(arr));
    }
}
