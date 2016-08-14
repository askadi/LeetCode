/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
            return 0;
        int min = Integer.MAX_VALUE;
        int threeSum =0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int start =i+1,end=nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == target){
                    return sum;
                }
                int diff = Math.abs(sum-target);
                if(min>diff){
                    min=diff;
                    threeSum=sum;
                }
                if(sum>target)
                    end--;
                else
                    start++;
            }
        }
        return threeSum;
    }
}
