class Solution {
    public static int max(int [] nums){
     int maxi=0;
 
     for(int i=0;i<nums.length;i++){
         if(nums[i]>maxi){
             maxi=nums[i];
         }
     
     }
     return maxi;
    }
 
 
    public static int mintime(int [] nums,int mid)
    {
     int timemin=0;
 
     for(int i=0;i<nums.length;i++){
         timemin+=Math.ceil((double)nums[i]/(double)mid);
     }
      return timemin;
    }
 
 
 
     public int minimumRateToEatBananas(int[] nums, int h) {
      int low=1;
      int high=max(nums);
 
       while(low<=high){
         int mid=(low+high)/2;
         int timerequired=mintime(nums,mid);
         if(timerequired<=h){
             high=mid-1;
         }
         else{
             low=mid+1;
         }
 
       } 
       return low;    
  
 
     }
 }