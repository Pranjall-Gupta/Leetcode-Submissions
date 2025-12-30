class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(k==1 && nums.length==1) return nums[0];
        int sum=0;
        double ans=Integer.MIN_VALUE;
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            count++;
            if(count==k){
                ans=Math.max(ans,(double)sum/k);
                count--;
                sum-=nums[left];
                left++;
            }
        }
        return ans;
    }
}