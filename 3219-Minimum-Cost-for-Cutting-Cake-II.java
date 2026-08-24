class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
       
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int h=m-2,v=n-2;
        int hp=1,vp=1;
        long cost = 0;
        while(h >=0 && v >=0){
            if(verticalCut[v] <= horizontalCut[h]){
                cost += (horizontalCut[h] * vp);
                hp++;
                h--;
            }
            else{
                cost += (verticalCut[v]*hp);
                vp++;
                v--;
            }
        }
        while(h >=0){
            cost += (horizontalCut[h] * vp);
                hp++;
                h--; 
        }
        while(v >=0){
            cost += (verticalCut[v]*hp);
                vp++;
                v--; 
        }
        return cost;
    }
}