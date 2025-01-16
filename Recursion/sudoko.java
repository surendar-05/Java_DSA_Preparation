class Solution {
    public boolean areRulesMet(char[][]board,int row,int col,char digit){
        for(int i=0;i<9;i++){
            if(board[row][i]==digit ||board[i][col]==digit){
                return  false;
            }
        }

        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        
         for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    // Digit already in 3x3 sub-box
                    return false;  
                }
            }
        }
        return true;

    }
    public boolean solve(char[][] board){
        int n=9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(char digit='1';digit<='9';digit++){
                        if(areRulesMet(board,i,j,digit)){
                            board[i][j]=digit;

                            if(solve(board)){
                                return true;
                            }
                           
                                board[i][j]='.';
                            
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        //your code goes here
        solve(board);
       
    }
}