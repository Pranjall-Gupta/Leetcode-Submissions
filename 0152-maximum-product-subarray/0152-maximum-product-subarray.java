class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int Max_prod=nums[0],Min_prod=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=Max_prod;
                Max_prod=Min_prod;
                Min_prod=temp;
            }
            Max_prod=Math.max(Max_prod*nums[i],nums[i]);
            Min_prod=Math.min(Min_prod*nums[i],nums[i]);
            ans=Math.max(ans,Max_prod);
        }
        return ans;

    }
}