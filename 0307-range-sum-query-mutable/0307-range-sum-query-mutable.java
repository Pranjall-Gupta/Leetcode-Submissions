class NumArray {
    int[] bit;
    int n;
    int nums[];
    public NumArray(int[] nums) {
        this.n=nums.length;
        this.nums=nums.clone();
        bit=new int[n+1];

        for(int i=0;i<n;i++){
            updateBIT(i+1,nums[i]);
        }
    }
    private void updateBIT(int index,int delta){
        while(index<=n){
            bit[index]+=delta;
            index+=(index & -index);
        }
    }
    private int queryBIT(int index){
        int sum=0;
        while(index>0){
            sum+=bit[index];
            index-=(index & -index);
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int diff=val-nums[index];
        nums[index]=val;
        updateBIT(index+1,diff);
    }
    
    public int sumRange(int left, int right) {
        return queryBIT(right+1)-queryBIT(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */