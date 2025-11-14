class Solution {
    public String largestNumber(int[] nums) {
        String arr[]=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i]=Integer.toString(nums[i]);

        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                String str1=arr[i]+arr[j];
                String str2=arr[j]+arr[i];

                if(str2.compareTo(str1)>0){
                    //swap
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }    
        }

        String ans="";
        for(String s:arr) ans+=s;

        int flag=1;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i) != '0') flag=0;
        }
        if(flag==1) return "0";
        return ans;
    }
}