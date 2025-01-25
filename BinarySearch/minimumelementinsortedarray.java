class Solution {
    public
     int findMin(ArrayList<Integer> arr) {
         int low = 0;
         int high = arr.size() - 1;
         int min = Integer.MAX_VALUE;
 
         while (low <= high) {
             int mid = (low + high) / 2;
 
             // Identify the sorted half if it is sorted the first value is the
             // minimum value
             //If it is left side means if arr[low] is the minimum value and if it is rigth side arr[mid] is the minimum value;
             if (arr.get(low) <= arr.get(mid)) {
                 min = Math.min(min, arr.get(low));
                 low = mid + 1;
             } else {
                 min = Math.min(min, arr.get(mid));
                 high = mid - 1;
             }
         }
 
         return min;
     }
 }
 