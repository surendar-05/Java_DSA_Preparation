class Solution {
    public boolean solve(char[][] board, String word, int i, int j, int index) {
         if (index == word.length()) {
             return true;
         }
 
         if (i<0 || j<0 || i>=board.length || j >= board[0].length ||
             word.charAt(index) != board[i][j]) {
             return false;
         }
 
         char temp = board[i][j];
         board[i][j] = ' ';
 
             boolean ans=solve(board, word, i + 1, j, index + 1)||
                       solve(board, word, i - 1, j, index + 1)||
                       solve(board, word, i, j+1, index + 1) ||
                       solve(board, word, i, j-1, index + 1);
 
                   board[i][j]=temp;
 
 
                   return ans;
     }
 
    public
     boolean exist(char[][] board, String word) {
         // your code goes here
 
         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[0].length; j++) {
                 if (board[i][j] == word.charAt(0)) {
                     if (solve(board, word,i, j,0)) {
                         return true;
                     }
                 }
             }
            
         }
      return false;    
     }
     
 }