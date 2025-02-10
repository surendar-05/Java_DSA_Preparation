class Solution {
    public boolean lemonadeChange(int[] bills) {
        //your code goes here
        int balance=0;
        

        for(int i=0;i<bills.length;i++){
           
           if(balance<bills[i]-5){
            return false;
           }

            balance=(balance+bills[i])-(bills[i]-5);        
        }
        
        return true;
    }
}