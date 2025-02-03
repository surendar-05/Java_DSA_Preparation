class Solution {
    public int countOnes(int [] mat ,int value){
        int low=0;
        int high=mat.length-1;
        int ans=mat.length;//if not 1 so the hypothetical index last index
        while(low<=high){
            int mid=(low+high)/2;

            if(mat[mid]>=value){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int[][] mat) {
        int index=-1;
        int max_count=0;

        for(int i=0;i<mat.length;i++){
            int max_ones=mat[0].length-countOnes(mat[i],1);

            if(max_ones>max_count){
                max_count=max_ones;
                index=i;
            }
        }
       
       return index;
    }
}