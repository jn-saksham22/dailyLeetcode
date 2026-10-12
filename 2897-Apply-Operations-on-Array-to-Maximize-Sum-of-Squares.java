class Solution {
    public int maxSum(List<Integer> nums, int k) {
       long mod = 1_000_000_007;
       int cnt[] = new int[32];
       for(int x : nums){
          for(int b=0;b<32;b++) 
            cnt[b] += x >> b & 1;
       }
       long res = 0;
       for(int i=0;i<k;i++){
         long curr = 0;
         for(int b=0;b<32;b++)
           if(cnt[b] > i) curr |= 1L << b;
           
           res = (res + curr*curr) % mod;
         
       }
       return (int)res;
    }
}