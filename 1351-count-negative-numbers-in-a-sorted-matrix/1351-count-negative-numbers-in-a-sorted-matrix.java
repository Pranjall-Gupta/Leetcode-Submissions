class Solution {
    public int countNegatives(int[][] grid) {
        int rows=grid.length;
        int col=grid[0].length;
        int count=0;
        //staircase
        int r=0,c=col-1;
        while(r<rows && c>=0){
            if(grid[r][c]<0){
                count+=(rows-r);
                c--;
            }else 
                r++;
        }
        return count;
    }
}