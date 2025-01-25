class Solution {

    //1.Indentify the sorted half first and then
    //2.Find the target that lies in left half or right half
    //3.if it right half means low=mid+1;
    //4.if it is left half means rigth=mid-1;
    public int search(int[] nums, int target) {
        int ans=-1;

        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]==target)
            return mid;

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<=nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }

            }
        }
        return ans;
       
    }
}
