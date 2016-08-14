/*
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1};
        if(nums.length<1)
            return range;
        int index = binarySearch(nums,0,nums.length,target);
        if(index < 0)
            return range;
        int start = index,end=index;
        while(start>=0)
        if((nums[start] == target))
            start--;
        else
            break;
        while(end<nums.length)
        if((nums[end] == target))
            end++;
        else
            break;
        range[0] = ++start;
        range[1] = --end;
        return range;
    }
    public int binarySearch(int[] nums,int low,int high,int key){
        int mid = (high+low)/2;
        if(low<high){
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] < key)
                return binarySearch(nums,low+1,high,key);
            else
                return binarySearch(nums,low,high-1,key);
        }
        return -1;
    }
}
