class Solution {
    public void solve(int index,List<List<Integer>>ans_list,List<Integer>list,int [] nums){
      
       if(index==nums.length){
        ans_list.add(new ArrayList<>(list));
        return;

      }
      
      list.add(nums[index]);

      solve(index+1,ans_list,list,nums);
      
      // Backtrack: remove the current element from the subset
      list.remove(list.size()-1);
     
     // Skip duplicates and recur for the next unique element
     for(int i=index+1;i<nums.length;i++){
        if(nums[i]!=nums[index]){
          solve(i,ans_list,list,nums);
          return;
        }
     }
    

    //In this condition works when {1,2,2,2,2} no unique elements at last
     solve(nums.length,ans_list,list,nums);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //your code goes here

        List<List<Integer>>ans_list=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums); 

        solve(0,ans_list,list,nums);

        return ans_list;
    }
}