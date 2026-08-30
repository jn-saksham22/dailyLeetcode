class Solution {
    public int jump(int[] nums) {
        int jumps = 0,l = 0,r = 0;
        while(r < nums.length-1){
            int maxIdx = 0;
            for(int i=l;i<=r;i++){
                maxIdx = Math.max(maxIdx,i+nums[i]);
            }
            l = r+1;
            r = maxIdx;
            jumps++;
        }
        return jumps;
    }
}