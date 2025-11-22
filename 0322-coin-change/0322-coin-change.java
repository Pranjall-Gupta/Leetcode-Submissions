class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n=coins.length;
        int inf=(int)1e9;
        int ans[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0)    ans[i][j]=0;
              
                else if(i==0) { //first coinnnnnnnnn
                    ans[i][j]= j%coins[i]==0? j/coins[i]:inf;
                }
                else{
                    //we aren't considering the curr coin here
                    int nottake=ans[i-1][j];
                    //consider the coin here
                    int take=inf;
                    if(j>=coins[i]) take=1+ans[i][j-coins[i]];
                    ans[i][j]=Math.min(nottake , take);
                }
            }
        }
        return ans[n-1][amount]>=inf?-1:ans[n-1][amount];
    }
}