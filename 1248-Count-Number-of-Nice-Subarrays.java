class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       int n = nums.length;
       int psum[] = new int[n+1];
       int ans = 0 , t = 0;
       psum[0] = 1;
       for(int num : nums){
          t += num & 1;

          if(t - k >= 0){
              ans += psum[t-k];
          }
          psum[t]++;
       }
       return ans;
    }
}