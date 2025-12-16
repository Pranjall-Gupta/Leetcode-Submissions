class Solution {
    public int numSub(String s) {
        long count=0;
        int i=0;
        long ans=0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                count++;
                i++;
            }
            else{
                if(count>0){
                    ans+=(count*(count+1))/2;
                }
                count=0;
                i++;
            }
        }
        if(count>0)
            ans+=(count*(count+1))/2;
        return (int)(ans%1_000_000_007);
    }
}