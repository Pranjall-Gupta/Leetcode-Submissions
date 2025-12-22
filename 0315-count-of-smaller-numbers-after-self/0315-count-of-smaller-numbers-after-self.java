class Solution {
    class FenwickTree{
        int bit[];
        FenwickTree(int n){
            bit=new int[n+1];
        }
        void update(int i,int delta){
            while(i<bit.length){
                bit[i]+=delta;
                i+=(i&-i);
            }
        }
        int query(int i){
            int sum=0;
            while(i>0){
                sum+=bit[i];
                i-=(i&-i);
            }
            return sum;
        }
    }
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> count=new ArrayList<>();
        if(nums.length==0) return count;
        int n=nums.length;

        int[]sorted=nums.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> rank=new HashMap<>();
        int r=1;
        for(int num:sorted){
            if(!rank.containsKey(num))
                rank.put(num,r++);
        }
        
        FenwickTree ft=new FenwickTree(rank.size());
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            int idx=rank.get(nums[i]);
            ans[i]=ft.query(idx-1);
            ft.update(idx,1);
        }
        for(int x:ans) count.add(x);
        
        return count;
    }
}