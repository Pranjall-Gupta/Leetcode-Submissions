class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int n:nums){
            low=Math.max(low,n);
            high+=n;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(check(nums,mid,k)){
                high=mid;
            }else
                low=mid+1;
        }
        return low;
    }
    private boolean check(int[] nums,int limit,int k){
        int usedPiece=1,sum=0;
        for(int n:nums){
            if(sum+n>limit){
                usedPiece++;
                sum=n;
                if(usedPiece>k) return false;
            }else
                sum+=n;
        }
        return true;
    }
}