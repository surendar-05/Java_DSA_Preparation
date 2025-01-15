class Solution {
    
    public boolean isSafe(int col,int node,List<List<Integer>>list,int [] colors){

        for(int neighbour:list.get(node)){
            if(colors[neighbour]==col){
                return false;
            }
        }

        return true;
    }
    public boolean solve(int node,int m,int n,int [] colors,List<List<Integer>>list){
        if(node==n){
            return true;
        }
       
       for(int i=1;i<=m;i++){
          
          if(isSafe(i,node,list,colors)){
            colors[node]=i;


            if(solve(node+1,m,n,colors,list)){
                return true;
            }

            colors[node]=0;
          }
       }
      return false;
    }
    boolean graphColoring(int[][] edges, int m, int n) {
        //your code goes here

        List<List<Integer>>list=new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int [] arr:edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        int [] colors=new int [n];

        boolean ans=solve(0,m,n,colors,list);

        return ans;
    }
}