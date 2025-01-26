class Solution {
    public long floorSqrt(long n) {

        long low=1;//1*1
        long high=n;

        while(low<=high){
            long mid=(long)(low+high)/2;

            if((long)mid*mid>n){
                high=(int)(mid-1);
            }
            else{
                low=(int)mid+1;
            }
        }
        return high;
      
    }
}