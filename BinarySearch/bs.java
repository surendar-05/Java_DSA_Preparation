class Solution {
    public int solve(int [] nums,int target,int left,int right){
        if(left>right){
            return -1;
        }

        int mid=left+(right-left)/2;

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            return solve(nums,target,left,mid-1);
        }
        else{
         return solve(nums,target,mid+1,right);
        } 
    }
    public int search(int[] nums, int target) {
        int ans=solve(nums,target,0,nums.length-1);
        return ans;
       
    }
}