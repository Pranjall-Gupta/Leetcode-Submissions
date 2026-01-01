class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0;
        for(int w:weights){
            l=Math.max(l,w);
            h+=w;
        }
        int ans=h;

        while(l<=h){
            int mid=l+(h-l)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                h=mid-1;
            }else
                l=mid+1;
        }
        return ans;
    }
    private boolean canShip(int[] weights,int days,int wt){
        int currLoad=0;
        int userdate=1;
        for(int w:weights){
            if(w+currLoad>wt){
                userdate++;
                currLoad=w;
            }else
                currLoad+=w;
        }
        return userdate<=days;
    }
}