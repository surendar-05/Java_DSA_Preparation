package Recursion;


    class Solution {

        public static boolean solve(int [] nums, int k,int index)
        {
            if(k==0)
            {
                return true;
            }
            if(k<0)
            {
                return false;
            }
            if(index==nums.length)
            {
                return k==0;
            }
    
            return solve(nums,k-nums[index],index+1) || solve(nums,k,index+1);
        }
        public boolean checkSubsequenceSum(int[] nums, int k) {
             //your code goes here
           return solve(nums,k,0);
        }
    }  

