class Solution {
    public int change(int amount, int[] coins) {
        int iterate[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j==0) iterate[i][j]=1;
                else if(j<coins[i] && i!=0) iterate[i][j]=iterate[i-1][j];
                else if(i==0){
                    iterate[i][j]=(j%coins[i]==0)?1:0;
                }
                else{
                    iterate[i][j]=iterate[i-1][j]+iterate[i][j-coins[i]];
                }
            }
        }
        return iterate[coins.length-1][amount];
    }
}