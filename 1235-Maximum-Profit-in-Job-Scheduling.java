class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int act[][] = new int[profit.length][3];
        int n = profit.length;
        for(int i=0;i<profit.length;i++){
            act[i][0] = startTime[i];
            act[i][1] = endTime[i];
            act[i][2] = profit[i];
        }
        Arrays.sort(act, (a,b) -> a[1]-b[1]);
         
        int dp[] = new int[n+1];
        int end[] = new int[n];
        for(int i=0;i<n;i++)
          end[i] = act[i][1];
        
        for(int i=1;i<=n;i++){
            int curr[] = act[i-1];
            int j = search(end,i-1,curr[0]);
            dp[i] = Math.max(dp[i-1],curr[2]+dp[j+1]);
        }
        return dp[n];
    }
    private int search(int[] end,int h,int tar){
        int l = 0, res = -1;
        while(l < h){
            int mid = l+(h-l)/2;
            if(end[mid] <= tar){
                res = mid;
                l = mid+1;
            }
            else h = mid;
        }
        return res;
    }
}