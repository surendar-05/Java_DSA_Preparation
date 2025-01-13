class Solution {
   
    public void solve(String s,int index,List<List<String>>ans,List<String>list){
      if(index==s.length()){
         ans.add(new ArrayList<>(list));
         return;
      }
 
      for(int i=index;i<s.length();i++){
         if(isPalindrome(s,index,i)){
             list.add(s.substring(index,i+1));
             solve(s,i+1,ans,list);
             list.remove(list.size()-1);
         }
      }
    }
 
    public static boolean isPalindrome(String s, int left,int right){
       while(left<=right){
         if(s.charAt(left)!=s.charAt(right)){
             return false;
         }
         left++;
         right--;
       }
       return true;
    }
 
     public List<List<String>> partition(String s) {
         //your code goes here
 
         List<List<String>>ans=new ArrayList<>();
         List<String>list=new ArrayList<>();
         solve(s,0,ans,list);
 
         return ans;
     }
 }