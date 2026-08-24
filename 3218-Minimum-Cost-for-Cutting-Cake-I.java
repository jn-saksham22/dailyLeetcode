class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Integer[] hor = new Integer[horizontalCut.length];
        Integer[] ver = new Integer[verticalCut.length];
        for(int i=0;i<hor.length;i++){
            hor[i] = horizontalCut[i];
        }
        for(int i=0;i<ver.length;i++){
            ver[i] = verticalCut[i];
        }

        Arrays.sort(hor, Collections.reverseOrder());
        Arrays.sort(ver, Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost = 0;
        while(h < hor.length && v < ver.length){
            if(ver[v] <= hor[h]){
                cost += (hor[h] * vp);
                hp++;
                h++;
            }
            else{
                cost += (ver[v]*hp);
                vp++;
                v++;
            }
        }
        while(h < hor.length){
            cost += (hor[h] * vp);
                hp++;
                h++; 
        }
        while(v < ver.length){
            cost += (ver[v]*hp);
                vp++;
                v++; 
        }
        return cost;
    }
}