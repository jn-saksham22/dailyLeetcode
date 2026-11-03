class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int ans = 0;

        for(int num : nums){
            if(num > max) max = num;  
            
            ans += num;
        }
        return n*max - ans;
    }
}