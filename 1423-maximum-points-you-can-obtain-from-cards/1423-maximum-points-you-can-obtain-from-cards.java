class Solution {
    public int maxScore(int[] cards, int k) {
        int tot_score=0;
        for(int i=0;i<cards.length;i++){
            tot_score+=cards[i];
        }
        if(k==cards.length) return tot_score;


        int n=cards.length-k;
        //find smallest subsequence of len n
        int summ=Integer.MAX_VALUE;
        int left=0;
        int right=left+n-1;
        while(right<cards.length){
            summ=Math.min(summ,sum(cards,left,right));
            left++;
            right=left+n-1;
        }
        return tot_score-summ;

    }
    private int sum(int[] cards,int left,int right){
        int sum=0;
        if((right-left)%2==0){
            sum+=cards[left];
            left++;
        }
        while(left<right){
            sum+=cards[left];
            sum+=cards[right];
            left++;
            right--;
        }
        return sum;
    }
}