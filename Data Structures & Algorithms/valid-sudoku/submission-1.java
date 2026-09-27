// class Solution {
//     public boolean isValidSudoku(char[][] board) {

//         Map<Integer, Set<Character>> rows = new HashMap<>();
//         Map<Integer, Set<Character>> cols = new HashMap<>();
//         Map<String, Set<Character>> boxes = new HashMap<>();

//         for (int i = 0; i < board.length; i++){
//             for (int j = 0; j < board.length; j++){
//                 if (board[i][j] == '.') continue;

//                 String sqKey = (i/3) + "," + (j/3);

//                 if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
//                 cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
//                 boxes.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[i][j])){
//                     return false;
//                 }

//                 rows.get(i).add(board[i][j]); // getting each hashset & adding it to
//                 cols.get(j).add(board[i][j]);
//                 boxes.get(sqKey).add(board[i][j]);
                    
                
//             }
//         }
//         return true;

//     }
// }

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
