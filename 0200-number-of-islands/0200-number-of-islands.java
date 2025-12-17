class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1') {
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>grid.length-1 || c> grid[0].length-1) return;

        if(grid[r][c]=='0') return;

        grid[r][c]='0';
        
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}