class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n+1];
        int[] nxt = new int[n+1];

        for(int i=0;i<n;i++){
            boolean desc = i < n-1 && nums[i] > nums[i+1];
            pre[i+1] = pre[i] + (desc ? 1 : 0);
        }
         nxt[n] = n;
        for (int i = n - 1; i >= 0; i--) {
            boolean desc = i < n - 1 && nums[i] > nums[i + 1];
            nxt[i] = desc ? i : nxt[i + 1];
        }

        int res = 0;

        for(int k=1; k<=n; k++){
            if(n % k != 0) continue;

            boolean valid = true;
            long prevHi = Long.MIN_VALUE;

            for(int s=0;s<n; s+= k){
                int e = s + k -1;
                int d = pre[e] - pre[s];
                int lo, hi;

                if(d == 0){
                    lo = nums[s];
                    hi = nums[e];
                }
                else if(d == 1 && nums[e] <= nums[s]){
                    int p = nxt[s];
                    lo = nums[p+1];
                    hi = nums[p];
                }else{
                    valid = false;
                    break;
                }
                if(prevHi > lo) {valid = false; break;}
                prevHi = hi;
            }
            if(valid) res += k;
        }
        return res;
    }
}