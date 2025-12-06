class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        return binary(nums,target,left,right);
    }
    private int binary(int[] nums,int target,int left,int right){
        if(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                return binary(nums,target,left,mid-1);
            else
                return binary(nums,target,mid+1,right);
        }
        return -1;
    }
}