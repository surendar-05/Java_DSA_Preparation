class Solution {
    public boolean TargetFound(int [] mat,int target){
        int low=0;
        int high=mat.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]==target){
                return true;
            }
            if(mat[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] mat, int target) {
       for(int i=0;i<mat.length;i++){
          if(TargetFound(mat[i],target)){
              return true;
          }
       }
       return false;
    }

}
