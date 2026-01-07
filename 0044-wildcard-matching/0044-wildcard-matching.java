class Solution {
    public boolean isMatch(String s, String p) {
        int checkS=0,checkP=0;
        int startIdx=-1,matchIdx=-1;

        while(checkS<s.length()){
            if(checkP<p.length() && (s.charAt(checkS)==p.charAt(checkP) || p.charAt(checkP)=='?')){ checkS++; checkP++; }
            else if(checkP<p.length() && p.charAt(checkP)=='*'){
                startIdx=checkP;
                matchIdx=checkS;
                checkP++;
            }
            else if(startIdx!=-1){
                checkP=startIdx+1;
                matchIdx++;
                checkS=matchIdx;
            }
            
            else return false;
        }
        while(checkP<p.length() && p.charAt(checkP)=='*') checkP++;
        return checkP==p.length();
       
    }
}