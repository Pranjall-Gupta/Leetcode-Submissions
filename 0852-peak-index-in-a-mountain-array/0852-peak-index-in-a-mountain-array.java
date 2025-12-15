class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<arr[mid+1])//increase slope
                left=mid+1;
            else //decrease slope
                right=mid;
        }
        return left;//or right both same
    }
}