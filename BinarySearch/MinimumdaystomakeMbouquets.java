
class Solution {
    public int min(int [] nums){
      int min=Integer.MAX_VALUE;

      for(int i=0;i<nums.length;i++){
        if(nums[i]<min){
          min=nums[i];
        }
      }
      return min;
    }

    public int max(int [] nums){
      int max=Integer.MIN_VALUE;

      for(int i=0;i<nums.length;i++){
        if(nums[i]>max){
          max=nums[i];
        }
      }
      return max;
    }

    public boolean possibleTimetoMakeBoquee(int [] nums,int k, int m,int mid){
      int totalBoquee=0;
      int count=0;
      for(int i=0;i<nums.length;i++){
         if(nums[i]<=mid){
          count++;
         }
         else{
          totalBoquee+=(count/k);
          count=0;
         }
      }
      totalBoquee+=(count/k);//Last when it reached the end of the loop it needs to check
      return totalBoquee>=m;
    }

    public int roseGarden(int n, int[] nums, int k, int m) {
      if(nums.length <(long)k*m){
        return -1;
      }
     int low=min(nums);
     int high=max(nums);
     int ans=-1;

     while(low<=high)
     {

      int mid=(low+high)/2;
      
       


       if(possibleTimetoMakeBoquee(nums,k,m,mid)){
         ans=mid;
         high=mid-1;
       }
       else{
          low=mid+1;
       }

     }
     return ans;
    }
}


