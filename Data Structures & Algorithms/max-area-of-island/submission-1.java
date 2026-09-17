class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxSum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                maxSum=Math.max(maxSum, dfs(grid,i,j));
                }
            }
        }
        return maxSum;
    }
    public int dfs(int[][] grid,int row, int col){
        int n= grid.length;
        int m = grid[0].length;

        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
        int area = 1;

        area+= dfs(grid,row-1,col);
        area+= dfs(grid,row,col+1);
        area+= dfs(grid,row+1,col);
        area+= dfs(grid,row,col-1);
    return area;
    }
}