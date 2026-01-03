class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]) return false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(target>matrix[rows-1][cols-1]) return false;
        for(int r=0;r<rows;r++){
            int left=0,right=cols-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(matrix[r][mid]==target) return true;
                else if(matrix[r][mid]>target) right=mid-1;
                else left=mid+1;
            }
        }
        return false;
    }
}