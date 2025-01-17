class Solution {
    public int solve(int [] nums,int x){
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;//Hypothetical ans may be an answer

        while(left<=right){
            int mid=(left+right)/2;
           /* Check the condition for 
               the current element */

            if(nums[mid]>=x){
              ans=mid;
              right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        /* If lower bound of 
           target is not found */
        return ans;
    }
    public int lowerBound(int[] nums, int x) {
        int ans=solve(nums,x);
        return ans;
       
     }
}
