class Solution {
    public boolean canWePlacePossible(int [] nums ,int k, int mid){
      int placeCows=1;
      int canCount=nums[0];
      
      for(int i=1;i<nums.length;i++){
      if(nums[i]-canCount>=mid){
        placeCows++;
        canCount=nums[i];
      }
      }
      if(placeCows>=k){
        return true;
      }
      else{
        return false;
      }
    }
      public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);//Then only we can able to find the minimum distanse only through the adjacent elements
        int low=1;
        int high=nums[nums.length-1]-nums[0];
  
        while(low<=high){
          int mid=(low+high)/2;
  
          if(canWePlacePossible(nums,k,mid))
          {
            low=mid+1;
          }
          else{
            high=mid-1;
          }
        }
        return high;
     
      }
  }
  