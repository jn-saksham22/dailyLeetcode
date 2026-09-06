class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        sum(candidates,target,ans,new ArrayList<Integer>(),0);

        return ans;
    }
    public void sum(int[] candidates,int remain,List<List<Integer>> ans,List<Integer> temp,int idx){
        if(remain < 0) return;

        if(remain == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > remain) break;
            
            temp.add(candidates[i]);
            sum(candidates,remain-candidates[i],ans,temp,i+1);
            
            temp.remove(temp.size()-1);
        }
    }
}