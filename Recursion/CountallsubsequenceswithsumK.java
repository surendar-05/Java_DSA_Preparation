package Recursion;

class Solution {
    public static int solve(int [] nums , int k, int index)
    {
        if(k==0){
            return 1;
        }
        if(k<0 || index==nums.length){
            return 0;
        }
        
        return solve(nums,k-nums[index],index+1)+solve(nums,k,index+1);
    }
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
        return solve(nums,k,0);
    }
}
