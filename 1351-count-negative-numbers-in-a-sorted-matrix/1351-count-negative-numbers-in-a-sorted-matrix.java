class Solution {
    public int countNegatives(int[][] grid) {
        int rows=grid.length;
        int col=grid[0].length;
        
        int count=0;
        for(int r=0;r<rows;r++){
            int firstNeg=col;
            int left=0,right=col-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(grid[r][mid]<0){
                    firstNeg=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            count+=(col-firstNeg);
        }
        return count;
    }
}