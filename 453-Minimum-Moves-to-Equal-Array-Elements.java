class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        int minEl = nums[0];

        int sum = 0;
        for(int num : nums){
            if(num < minEl) minEl = num;

            sum += num;
        }
        return sum - (minEl * n);
    }
}