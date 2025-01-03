class Solution {

    public void solve(int index,List<Integer>list,int sum,int[] nums){
        if(index==nums.length){
            list.add(sum);
            return;
        }
      
        solve(index+1,list,sum+nums[index],nums);

        solve(index+1,list,sum,nums);
        
    }
    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer>list=new ArrayList<>();

        solve(0,list,0,nums);

        return list;


    }
}