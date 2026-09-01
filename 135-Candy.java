class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int ans = 0;
        l[0] = 1 ;
        r[n-1] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1])
               l[i] = l[i-1]+1;
            else l[i] = 1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                r[i] = r[i+1]+1;
            else r[i] = 1;
        }
        for(int i=0;i<n;i++){
            ans += Math.max(l[i],r[i]);
        }
        return ans;
    }
}