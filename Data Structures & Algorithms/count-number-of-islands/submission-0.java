class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    traverseIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;

    }

    private void traverseIsland(char[][] grid, int i, int j){
        if (grid[i][j] == '0'){ //base case search through land not water
            return;
        }

        grid[i][j] = '0'; //mark as 0 (visited)

        //boundary checks

        if(i > 0){
            traverseIsland(grid, i-1, j);
        }
        if(i < grid.length-1){
            traverseIsland(grid, i+1, j);
        }
        if(j > 0){
            traverseIsland(grid, i, j-1);
        }
        if(j < grid[i].length-1){
            traverseIsland(grid, i, j+1);
        }
    }
}
