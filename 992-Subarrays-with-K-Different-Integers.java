class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return cntAtMost(nums,k) - cntAtMost(nums,k-1);
    }
    public int cntAtMost(int[] nums,int k){
        int freq[] = new int[nums.length+1];
        int cnt = 0, l = 0,r = 0;
        int distinct = 0;
        
        while(r < nums.length){
            if(freq[nums[r]] == 0) distinct++; // new num encountered 
            freq[nums[r]]++;

            while(distinct > k){
                freq[nums[l]]--;
                if(freq[nums[l]] == 0) distinct --;
                l++;
            }

            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}