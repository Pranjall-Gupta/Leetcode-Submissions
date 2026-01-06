class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
       Map<String,List<String>> map=new HashMap<>();
       for(String wrd:str){
            String key=asc_form(wrd);
            List<String> list=map.getOrDefault(key,new ArrayList<>());
            list.add(wrd);
            map.put(key,list);
       }
       List<List<String>> ans=new ArrayList<>();
    //    for(List<String> str:map.values())
    //         ans.add(str);
        ans.addAll(map.values());
        return ans;
    }
    private String asc_form(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String key = new String(arr);
        return key;
    }
}