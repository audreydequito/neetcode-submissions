class Solution {
    int rows = 0, cols = 0;

    Set<List<Integer>> pac = new HashSet<>();
    Set<List<Integer>> atl = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        // Top and bottom edges
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights[0][c], heights);
            dfs(rows - 1, c, atl, heights[rows - 1][c], heights);
        }

        // Left and right edges
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, cols - 1, atl, heights[r][cols - 1], heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                List<Integer> cell = Arrays.asList(r, c);

                if (pac.contains(cell) && atl.contains(cell)) {
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(
        int r,
        int c,
        Set<List<Integer>> visit,
        int prevHeight,
        int[][] heights
    ) {

        // Bounds check first!
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        List<Integer> cell = Arrays.asList(r, c);

        if (visit.contains(cell) || heights[r][c] < prevHeight) {
            return;
        }

        // Mark this cell as visited
        visit.add(cell);

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : dirs) {
            dfs(
                r + dir[0],
                c + dir[1],
                visit,
                heights[r][c],
                heights
            );
        }
    }
}