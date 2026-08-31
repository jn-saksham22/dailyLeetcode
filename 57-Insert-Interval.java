class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> interList = new ArrayList<>(Arrays.asList(intervals));
        interList.add(newInterval);
        Collections.sort(interList, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
        int[] curr = interList.get(0);
        for(int i=1;i<interList.size();i++){
            int[] interval = interList.get(i);
            if(curr[1] >= interval[0]){
                curr[1] = Math.max(curr[1],interval[1]);
            }else{
                res.add(curr);
                curr = interval;
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}