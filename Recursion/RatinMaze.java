class Solution {
    public void solve(int [][] grid,int i, int j,String path,int n,List<String>ans){
 
        if(i==n-1 && j==n-1){
         ans.add(path);
         return;
        }
        if(grid[i][j]==0)return;
 
        grid[i][j]=0;
 
        if(i>0){
          solve(grid,i-1,j,path+"U",n,ans);
        }
        if(i<n-1){
          solve(grid,i+1,j,path+"D",n,ans);
        }
        if(j>0){
          solve(grid,i,j-1,path+"L",n,ans);
        }
        if(j<n-1){
          solve(grid,i,j+1,path+"R",n,ans);
        }
 
        grid[i][j]=1;
 
    }
 
     public List<String> findPath(int[][] grid) {
         //your code goes here
 
         List<String>ans=new ArrayList<>();
         
         int n=grid.length;
 
         if(grid[0][0]==0 || grid[n-1][n-1]==0){
             return ans;
         }
 
         solve(grid,0,0,"",n,ans);
 
         Collections.sort(ans);
 
         return ans;
         
     }
 }