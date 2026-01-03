class Solution {
    public int countNegatives(int[][] grid) {
        int rows=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int r=0;r<rows;r++){
            int i=col-1;
            while(i>=0 && grid[r][i]<0){count++;i--;}
        }
        return count;
    }
}