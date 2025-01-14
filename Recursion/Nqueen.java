class Solution {
    public static boolean safe(List<String>board,int row,int  col){
        int r=row;
        int c=col;
       //top check
        while(r>=0){
            if(board.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;
        }

         r=row;
         c=col;
        
        //left diagonal
        while(r>=0&& c>=0){
            if(board.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;
            c--;
        }

         r=row;
         c=col;
         //right diagonal
        while(r>=0 && c<board.size()){
           if(board.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;
            c++;
        }

        return  true;
    }
    public void solve(int row,List<List<String>>ans,List<String>board){
        if(row==board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0;col<board.size();col++){

             if(safe(board,row,col)){
                char [] charArray=board.get(row).toCharArray();
                charArray[col]='Q';
                board.set(row,new String(charArray));
               
               // Recursively place queens in the next columns
                solve(row+1,ans,board);
                // Remove the queen and backtrack
                charArray[col]='.';
                board.set(row,new String(charArray));
             }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        //your code goes here
        List<List<String>>ans=new ArrayList<>();
        List<String>board=new ArrayList<>();
         
        String rowInit = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(rowInit);
        }

        solve(0,ans,board);

        return ans;

    }
}