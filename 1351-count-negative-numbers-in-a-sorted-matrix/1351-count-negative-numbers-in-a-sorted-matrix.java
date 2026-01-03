class Solution {
    public int countNegatives(int[][] grid) {
        int rows=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]<0) count++;
            }
        }
        return count;
    }
}