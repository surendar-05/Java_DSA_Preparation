

class Solution {
    public void  solve(List<String>list,String digits,int index,String str){
        String[] combo={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
          if(digits.length()==0){
            return ;
          }
          
           if(index==digits.length()){
            list.add(str);
            return;
           }
           
           int number=digits.charAt(index)-'0';

           String s=combo[number];

           for(int i=0;i<s.length();i++){
            solve(list,digits,index+1,str+s.charAt(i));
           }

    }

    public List<String> letterCombinations(String digits) {
        
        List<String>list=new ArrayList<>();
        String str="";
        solve(list,digits,0,str);

        return list;
        
    }
}