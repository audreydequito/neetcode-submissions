class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    int currArea = traverseIsland(grid, i, j);
                    if (maxArea < currArea){
                        maxArea = currArea;
                    }
                }
            }
        }
        return maxArea;
    }

    private int traverseIsland(int[][] grid, int i, int j){
        if (grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (i > 0){
            up = traverseIsland(grid, i-1, j);
        }
        if (i < grid.length-1){
            down = traverseIsland(grid, i+1, j);
        }
        if (j > 0){
            left = traverseIsland(grid, i, j-1);
        }
        if(j < grid[i].length-1){
            right = traverseIsland(grid, i, j+1);
        }
        return 1 + up + down + left + right;
    }
}
