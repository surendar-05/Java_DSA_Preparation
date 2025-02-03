class Solution {
    public static int upperBound(int [] matrix, int target,int m){
        int low=0;
        int high=m-1;
        int ans=m;

        while(low<=high){
            int mid=(low+high)/2;

            if(matrix[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int countSmallEqual(int [][] matrix,int n,int m,int mid){
        int count =0;
        for(int i=0;i<n;i++)
        {
            count+=upperBound(matrix[i],mid,m);
        }
        return count;
    }
    public int findMedian(int[][] matrix) {
      int n=matrix.length;
      int m=matrix[0].length;

      int low=Integer.MAX_VALUE;
      int high=Integer.MIN_VALUE;

      for(int i=0;i<n;i++){
        low=Math.min(matrix[i][0],low);
        high=Math.max(matrix[i][m-1],high);
      }
     
     int req=(n*m)/2;

     while(low<=high){
        int mid=(low+high)/2;
        
        int smallEqual=countSmallEqual(matrix,n,m,mid);
        if(smallEqual<=req){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
     }
    return low;

    }
}