/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length==0 || candidates == null){
            return res;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(candidates,target,0,res,cur);
        HashSet<List<Integer>> h = new HashSet<List<Integer>>(res);
        res.clear();
        res.addAll(h);
        return res;
    }
    public void dfs(int[] candidates, int target,int index,List<List<Integer>> res,ArrayList<Integer> cur){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target<candidates[i])
                return;
            cur.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}
