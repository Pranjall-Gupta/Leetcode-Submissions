class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=1;
        int left=0;
        for(int right=1;right<nums.length;right++){
            if(nums[right]>nums[right-1]){
                ans=Math.max(ans,right-left+1);
            }else{
                left=right;
            }
        }
        return ans;
    }
}