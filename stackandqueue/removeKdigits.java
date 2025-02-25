class Solution {
    public String removeKdigits(String nums, int k) {
       
    Stack<Character>st=new Stack<>();

    for(int i=0;i<nums.length();i++){
        while(!st.isEmpty() && k>0 && st.peek()-'0'>nums.charAt(i)-'0'){
            st.pop();
            k--;
        }
        st.push(nums.charAt(i));
    }

   while(!st.isEmpty() && k>0){
    st.pop();
    k--;
   }

  if(st.isEmpty()) return "0";

  StringBuilder sb=new StringBuilder();

  while(!st.isEmpty()){
    sb.append(st.pop());
  }

  while(sb.length() >0 && sb.charAt(sb.length()-1)=='0'){
    sb.deleteCharAt(sb.length()-1);
  }

  sb.reverse();

  if(sb.length() ==0) return "0";

  return sb.toString();

    }
}
