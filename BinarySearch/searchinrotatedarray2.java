class Solution {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> arr, int target) {
         int n = arr.size();
         int low = 0, high = n - 1;
         
         
         while (low <= high) {
             int mid = (low + high) / 2;
 
             
             if (arr.get(mid) == target) return true;
 
             // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
             if (arr.get(low).equals(arr.get(mid)) && arr.get(mid).equals(arr.get(high))) {
                 low = low + 1;
                 high = high - 1;
                 continue;//Again it checks because if it same element is there
             }
 
            
             if (arr.get(low) <= arr.get(mid)) {
                 
                 if (arr.get(low) <= target && target <= arr.get(mid)) {
                     high = mid - 1;
                 } 
                 
                 else {
                     low = mid + 1;
                 }
             } else {
                 
                 if (arr.get(mid) <= target && target <= arr.get(high)) {
                     low = mid + 1;
                 } 
                 
                 else {
                     high = mid - 1;
                 }
             }
         }
         
         return false;
     }
 }