/*
 Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if(nums.length<1)
            return permutations;
        dfs(permutations,0,nums);
        return permutations;
    }
    public void dfs(List<List<Integer>> permutations, int index,int[] nums){
        if(nums.length == index){
            ArrayList<Integer> t = convertArrayToList(nums);
            permutations.add(t);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            dfs(permutations,index+1,nums);
            swap(nums,index,i);
        }
        return;
    }
    private ArrayList<Integer> convertArrayToList(int[] num) {
	ArrayList<Integer> item = new ArrayList<Integer>();
	for (int h = 0; h < num.length; h++) {
		item.add(num[h]);
	}
	return item;
}
    public void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
}
