class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int max = 0;
        long total = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }
        if (total <= k) return 0;

        long[] cnt = new long[max + 1];
        for (int d : diff) cnt[d]++;

        for (int v = max; v > 0 && k > 0; v--) {
            if (cnt[v] == 0) continue;
            long move = Math.min(cnt[v], k);
            cnt[v] -= move;
            cnt[v - 1] += move;
            k -= move;
        }

        long res = 0;
        for (int v = 1; v <= max; v++) {
            res += cnt[v] * v * v;
        }
        return res;
    }
}