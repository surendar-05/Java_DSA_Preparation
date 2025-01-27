class Solution {
    public int NthRoot(int N, int M) {
        int low=0;
        int high=M;
        int ans=-1;

        while(low<=high){

            int mid=(low+high)/2;
          
           if(Math.pow(mid,N)==M){
             return mid;
           }
           
           if(Math.pow(mid,N)>M){
            high=mid-1;
           }
           else{
            low=mid+1;
           }

        }
        return ans;
        
    }
}
