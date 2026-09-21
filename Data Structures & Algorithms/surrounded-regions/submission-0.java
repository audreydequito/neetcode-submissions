class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O'){
                dfs(i,0,board);
            }
            if (board [i][n-1] == 'O'){
                dfs(i,n-1,board);
            }
        }
        for (int i = 0; i < n; i++){
            if (board [0][i] == 'O'){
                dfs(0,i,board);
            }
            if (board [m-1][i] == 'O'){
                dfs(m-1,i,board);
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] =='O'){
                    board[i][j] = 'X';

                }else if (board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        int m = board.length;
        int n = board[0].length;

        if (r<0 || r>=m || c>=n || c<0){
            return;
        }
        if (board[r][c] != 'O'){
            return;
        }
        board[r][c] = '#';
        dfs(r-1,c,board);
        dfs(r+1,c,board);
        dfs(r,c-1,board);
        dfs(r,c+1,board);
    }
}
