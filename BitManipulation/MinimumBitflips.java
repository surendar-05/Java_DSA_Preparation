class Solution {
    public int minBitsFlip(int start, int goal) {
        //your code goes here
      
      int answer=start^goal;
      int count=0;

      while(answer>0){
        count+=(answer&1);//if(answer%2)==1;
        answer=answer>>1;//answer=answer/2;
      }
      
      return count;
    }
}