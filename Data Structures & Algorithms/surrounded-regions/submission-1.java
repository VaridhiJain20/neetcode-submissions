class Solution {
    public void solve(char[][] board) {
       for(int i=0; i<board.length; i++){
        dfs(i,0, board);
        dfs(i, board[0].length-1, board);
       }

       for(int i=0; i<board[0].length; i++){
        dfs(0,i, board);
        dfs( board.length-1, i, board);
       }

       for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            if(board[i][j]=='.'){
                board[i][j]='O';
            }
            else if(board[i][j]=='O'){
                board[i][j]='X';
            }
        }
       }
    }

    int dr[]={-1,1,0,0};
    int dc[]={0,0,-1,1};

    public void dfs(int i, int j, char[][]board){
        if(board[i][j]=='O'){
            board[i][j]='.';
        }
        else{
            return;
        }
        for(int k=0; k<4; k++){
            int nr=i+dr[k];
            int nc= j+dc[k];

            if(nr<0 ||nr>= board.length|| nc<0|| nc>=board[0].length){
                continue;
            }
            dfs(nr, nc, board);
        }
    }
}
