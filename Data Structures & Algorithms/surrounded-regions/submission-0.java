class Solution {
    public void solve(char[][] board) {
        for(int i=1; i<board.length-1; i++){
            for(int j=1; j<board[0].length-1; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
