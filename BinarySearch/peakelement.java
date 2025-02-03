class Solution {
    public int maxElement(int [][] mat , int col){
        int max=Integer.MIN_VALUE;
        int index=-1;
    for(int i=0;i<mat.length;i++){
       if(mat[i][col]>max){
        max=mat[i][col];
        index=i;
    }
    }
    return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m=mat[0].length;
      int low=0;
      int high=m-1;

      while(low<=high){
        int mid=(low+high)/2;

        int row=maxElement(mat,mid);
        
        int left=(mid-1 >-1)?mat[row][mid-1]:Integer.MIN_VALUE;
        int right=(mid+1 < m)?mat[row][mid+1]:Integer.MIN_VALUE;



        if(mat[row][mid]>left && mat[row][mid]>right){
            return new int [] {row,mid};
        }
        else if(mat[row][mid]<left){
          high=mid-1;
        }
        else{
            low=mid+1;
        }

      }
      return new int []{-1,-1};
    }
}