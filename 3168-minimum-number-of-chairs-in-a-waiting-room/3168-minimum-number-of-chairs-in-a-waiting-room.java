class Solution {
    public int minimumChairs(String s) {
        int count=0;
        int i=0;
        int ans=0;
        while(i<s.length()){
            if(s.charAt(i)=='E') count++;
            else if(s.charAt(i)=='L') {
                ans=Math.max(ans,count);
                count--;
            }
            i++;
        }
        if(count>0) ans=Math.max(ans,count);
        return ans;
    }
}