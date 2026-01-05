class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(s.length()<p.length()) return ans;
        int k=p.length();
        int need[]=new int[26];
        int win[]=new int[26];

        for(char c:p.toCharArray()){
            need[c-'a']++;
        }

        for(int i=0;i<k;i++)
            win[s.charAt(i)-'a']++;
        
        if(Arrays.equals(need,win)) ans.add(0);

        for(int right=k;right<s.length();right++){
            int left=right-k;

            win[s.charAt(right)-'a']++;
            win[s.charAt(left)-'a']--;

            if(Arrays.equals(need,win)) ans.add(left+1);
        }
        return ans;
    }
}