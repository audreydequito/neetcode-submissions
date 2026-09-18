class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0, fresh = 0;
        int rows = grid.length, cols = grid[0].length;


        // initalization for counting number of fresh oranges
        // populating the queue which has the rotten orange coordinates
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    fresh++;
                } else if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        if (fresh == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        //iterate through entire Queue
        while (!queue.isEmpty() && fresh > 0){ //think of it as one iteration is per min
            // how many oranges can spread this minute!
            int size = queue.size(); //take snapshot of the current queue size (num of orange)

            // process the oranges currently in the queue (at this time frame + min)
            // think of the ones at the same level (the ones that turned rotten @ the same time)
            for (int i = 0; i < size; i++){

                //take the next item in the queue
                int[] rotten = queue.poll(); 

                //the rotten orange is looked at in all directions (4 different)
                //to find the neighbors that could become rotten
                for (int[] dir : dirs){
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1]; 

                    //for each direction check if next is fresh orange
                    if (x >= 0 && x < rows && y>= 0 && y < cols && grid[x][y]==1){
                        grid[x][y] = 2; //bcz next to rotten orange it becomes rotten
                        fresh--; //so we decrease the number of fresh oranges 

                        //then we offer the rotten orange to the queue (to later check its neighbors)
                        queue.offer(new int[]{x,y}); 
                    }
                }
            } 
            // by the end of this for loop, all the 4D adjacent neighbor fresh oranges are turned rotten and all added into Queue (this makes it BFS)
            time++;

        }

        return fresh == 0 ? time : -1;

    }
}
