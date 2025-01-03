package Recursion;

class Solution {
    public void solve(int index,List<Integer>temp_list,List<List<Integer>>ans_list,int [] nums){
          
          if(index==nums.length){
            ans_list.add(new ArrayList<>(temp_list));
            return;
          }

          temp_list.add(nums[index]);

          // Include the current element in the subset and move to the next element

          solve(index+1,temp_list,ans_list,nums);
         
          // Backtrack: remove the last added element to explore other subsets
          temp_list.remove(temp_list.size()-1);

         // Recursive case: Exclude the current element and move to the next element
          solve(index+1,temp_list,ans_list,nums);

    }


    public List<List<Integer>> powerSet(int[] nums) {
        //your code goes here
        List<List<Integer>>ans_list=new ArrayList<>();
        
        List<Integer>temp_list=new ArrayList<>();

        solve(0,temp_list,ans_list,nums);
        
        return ans_list;
    }
}