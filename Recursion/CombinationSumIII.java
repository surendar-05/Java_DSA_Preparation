class Solution {
    public void solve(int n,int k,List<List<Integer>>ans_list,List<Integer>list){
        if(n==0 && list.size()==k){
            ans_list.add(new ArrayList<>(list));
            return;
        }

        if(n<0 || list.size()>k){
            return;
        }

        int element=list.isEmpty()?1:list.get(list.size()-1)+1;

        for(int i=element;i<=9;i++)
        {
           if(i<=n){
            list.add(i);
           solve(n-i,k,ans_list,list);
           list.remove(list.size()-1);
           
           }
           else{
            break;
           }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        //your code goes here
        List<List<Integer>>ans_list=new ArrayList<>();
        List<Integer>list=new ArrayList<>();

        solve(n,k,ans_list,list);

        return ans_list;

    }
}