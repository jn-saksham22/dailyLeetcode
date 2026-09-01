class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l = new int[n];
        l[0] = 1 ;
  
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1])
               l[i] = l[i-1]+1;
            else l[i] = 1;
        }
        int curr = 1, r = 1;
        int ans = Math.max(1,l[n-1]);
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                curr = r+1;
            else curr = 1;
            r = curr; 
            ans += Math.max(curr,l[i]);
        }
        
        return ans;
    }
}