class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        targetSum(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
    public void targetSum(int[] candidates,int remain,List<List<Integer>> ans,List<Integer> temp,int start){
      
         if(remain == 0){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<candidates.length;i++){
                if(remain < candidates[i]) continue;
                temp.add(candidates[i]);
                targetSum(candidates,remain-candidates[i],ans,temp,i);
                temp.remove(temp.size()-1);
            }
        }
       
    }
}