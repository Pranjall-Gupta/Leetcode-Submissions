class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){

                if(board[r][c]=='.'){

                    for(char ch='1';ch<='9';ch++){
                        if(isValid(board,r,c,ch)){

                            board[r][c]=ch;

                            if(solve(board)) return true;

                            board[r][c]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board,int r,int c,char ch){
        for(int i=0;i<9;i++){
            if(board[r][i]==ch) return false;
            if(board[i][c]==ch) return false;

            int row=3*(r/3)+i/3;
            int col=3*(c/3)+i%3;

            if(board[row][col]==ch) return false;
        }
        return true;
    }
}