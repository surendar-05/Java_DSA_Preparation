class Solution {
    public int [] findNse(int [] arr){
      int [] nse=new int [arr.length];
      
      Stack<Integer>st=new Stack<>();

      for(int i=arr.length-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
        }
        nse[i]=st.isEmpty()?arr.length:st.peek();
        st.push(i);
      }
      return nse;
    }
    public int [] findPsee(int [] arr){
        int [] pse=new int [arr.length];
      
      Stack<Integer>st=new Stack<>();

      for(int i=0;i<arr.length;i++){
        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
        }
        pse[i]=st.isEmpty()?-1:st.peek();
        st.push(i);
      }
      return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int total=0;
        int modulo=(int)1e9 + 7;
        
         int []nse=findNse(arr);
         int []pse=findPsee(arr);


        for(int i=0;i<arr.length;i++){
           
           int left=i-pse[i];
           int right=nse[i]-i;
            long freq = left * right * 1L;
           total=(int)(total+(freq*arr[i])%modulo)%modulo;

        }
        return total;
    }
}
