class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc_cnt = 0;
        int desc_cnt = 0;

        for(int i=1;i<n;i++){
            if(nums[i] == (nums[i-1]+1)%n)  asc_cnt++;
            if(nums[i-1] == (nums[i]+1)%n)  desc_cnt++;
        }

        if(asc_cnt == n-1 && nums[0]==0) {
            return 0;
        }
        if(asc_cnt == n-1){
            int left = n - nums[0];
            int right = 1 + (nums[n-1]+1) +1;
            return Math.min(left, right);
        }
        
        if(desc_cnt == n-1){
            int left = n - nums[n-1] + 1;
            int right = (nums[0]+1)%n +1;

            return Math.min(left, right);
        }
        return -1;
    }
}