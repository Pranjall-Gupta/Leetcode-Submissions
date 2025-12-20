class Solution {
    public int maxScore(int[] cards, int k) {
        int lsum=0,rsum=0;
        int max;
        for(int i=0;i<k;i++) lsum+=cards[i];
        max=lsum;
        int ridx=cards.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cards[i];
            rsum+=cards[ridx--];
            max=Math.max(max,lsum+rsum);
        }
        return max;

    }

}