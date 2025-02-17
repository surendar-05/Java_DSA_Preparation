class MinStack {
    
   Stack<Integer>st;
   int min=Integer.MAX_VALUE;

    public MinStack() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            min=val;
            return;
        }
        else{
            
            if(min<val){
                st.push(val);
            }
            else{
                
                st.push((2*val)-min);
                min=val;
            }
        }
    }

    public void pop() {
       if(st.isEmpty()){
        return;
       }

        int x=st.peek();
        st.pop();

       if(x<min){
         min=2*min-x;
       }

    }

    public int top() {
        if(min>st.peek()){
            return min;
        }
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
