class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        int minEl = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] < minEl) minEl = nums[i];
        }
        int op = 0;
        for(int i=0;i<n;i++){
            op += nums[i] - minEl;
        }
        return op;
    }
}