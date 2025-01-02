package Recursion;

class Solution {
    public void solve(int [] candidates,int target, int index,List<List<Integer>>ans,List<Integer> list){
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || index==candidates.length){
            return;
        }
        list.add(candidates[index]);
        solve(candidates,target-candidates[index],index+1,ans,list);

        
        list.remove(list.size()-1);

        for(int i=index+1;i<candidates.length;i++)
        {
            //To avoid the same recursion tree it only needs an unique combinations

            if(candidates[i]!=candidates[index]){
                solve(candidates,target,i,ans,list);
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(candidates);

        solve(candidates,target,0,ans,list);

        return ans;

    }
}