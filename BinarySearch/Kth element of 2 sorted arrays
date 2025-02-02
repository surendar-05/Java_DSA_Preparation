class Solution {
    public int kthElement(int[] a, int[] b, int k) {
      int n=a.length+b.length;

      if(a.length>b.length){
        return kthElement(b,a,k);
      }

      int low=Math.max(k-b.length,0);
      int high=Math.min(k,a.length);

      while(low<=high){
        int mid1=(low+high)/2;
        int mid2=k-mid1;
        int r1=Integer.MAX_VALUE;
         int r2=Integer.MAX_VALUE;
          int l1=Integer.MIN_VALUE;
           int l2=Integer.MIN_VALUE;

        if(mid1<a.length) r1=a[mid1];
        else r1=Integer.MAX_VALUE;
        if(mid2<b.length) r2=b[mid2];
        else r2=Integer.MAX_VALUE;
        if(mid1-1>=0) l1=a[mid1-1];
        else l1=Integer.MIN_VALUE;
        if(mid2-1>=0) l2=b[mid2-1];
        else l2=Integer.MIN_VALUE;

        if(l1<=r2 && l2<=r1){
            return Math.max(l1,l2);
        }
       else if(l1>r2) high=mid1-1;
        else{
            low=mid1+1;
        }
        
      }
      return -1;
    }
}
