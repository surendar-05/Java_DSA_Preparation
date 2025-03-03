class Solution {
    public int frogJump(int[] heights) {
        int firstPrevious=0;
        int secondPrevious=0;
        
     
       for(int i=1;i<heights.length;i++){

        int jumpOne=firstPrevious+Math.abs(heights[i]-heights[i-1]);

        int jumpTwo=Integer.MAX_VALUE;

         if(i>1){
           jumpTwo=secondPrevious+ Math.abs(heights[i]-heights[i-2]);
         }
         int currentSum=Math.min(jumpOne,jumpTwo);

         secondPrevious=firstPrevious;
         firstPrevious=currentSum;
       }

       return firstPrevious;

    }
}