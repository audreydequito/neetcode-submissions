class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == '.') continue;

                String sqKey = (i/3) + "," + (j/3);

                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                boxes.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[i][j])){
                    return false;
                }

                rows.get(i).add(board[i][j]); // getting each hashset & adding it to
                cols.get(j).add(board[i][j]);
                boxes.get(sqKey).add(board[i][j]);
                    
                
            }
        }
        return true;

    }
}
