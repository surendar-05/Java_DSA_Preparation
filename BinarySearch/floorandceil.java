class Solution {
    public int floor(int [] nums,int x){
        int left=0;
        int right=nums.length-1;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]<=x){
                ans=nums[mid];
                left=mid+1;

            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    public int ceil(int [] nums,int x){
        int left=0;
        int right=nums.length-1;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]>=x){
                ans=nums[mid];
                right=mid-1;

            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int[] nums, int x) {
       int[]ans=new int [2];
       ans[0]=floor(nums,x);
       ans[1]=ceil(nums,x);
       return ans;
    }
}