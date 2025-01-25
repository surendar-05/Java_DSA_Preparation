class Solution {
  
    //First Code Issue: The smallest element (ans) is not reliably tracked, leading to incorrect index updates.
    //min=Math.min(arr[low],min)
    //min=Math.min(arr[mid],min)
   //Second Code Fix: Ensures that the index is only updated when a smaller element is found, making it robust for all edge cases, including already sorted subarrays.
  //if(nums.get(low)<ans){
                 //  index = low;
                  // ans=nums.get(low);
                //}

    public int findKRotation(ArrayList<Integer> nums) {
     int low = 0, high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
        
            if (nums.get(low) <= nums.get(high)) {
                
                if(nums.get(low)<ans){
                   index = low;
                   ans=nums.get(low);
                }
               break;
            }
            
            
            if (nums.get(low) <= nums.get(mid)) {
               
                if(nums.get(low)<ans){
                   index = low;
                   ans=nums.get(low);
                }
               
                low = mid + 1;
            } else {
                 if(nums.get(mid)<ans){
                   index = mid;
                   ans=nums.get(mid);
                }
             
                high = mid - 1;
            }
        }
     
        return index; 
    }
}