class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for(int num : nums){
           sum += num;
        }
        int curr = 0;

        for(int j=nums.length-1;j>=0;j--){
            sum -= nums[j];
            curr += nums[j];
            ans.add(nums[j]);

            if(curr > sum){
                return ans;
            }
        }
        return ans;
    }
}