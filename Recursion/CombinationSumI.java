class Solution {
    public void solve(int [] candidates,int target,List<List<Integer>> ans,int index,List<Integer>v2)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(v2));
            return;
        }
        if(target<0 || index==candidates.length){
            return;
        }

        solve(candidates,target,ans,index+1,v2);

        v2.add(candidates[index]);

        solve(candidates,target-candidates[index],ans,index,v2);

        v2.remove(v2.size()-1);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>v2=new ArrayList<>();
         solve(candidates,target,ans,0,v2);

         return ans;
    }
}