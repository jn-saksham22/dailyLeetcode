class Solution {
    public int lengthOfLIS(int[] nums) {
        int res[] = new int[nums.length];
        int size = 0;
        for(int n : nums){
            int l = 0,r = size-1;
            while(l <= r){
                int mid = l+(r-l)/2;
                if(res[mid] < n) l = mid+1;
                else r = mid-1;
            }
            res[l] = n;
            if(l == size) size++;
        }
        return size;
    }
}