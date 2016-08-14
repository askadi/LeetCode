/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length<1 || grid ==null)
            return 0;
        int m=grid.length;
        int n = grid[0].length;
        int[][] dp =  new int[m][n];
        int i=0,j=0;
        dp[0][0] = grid[0][0];
        for(i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(i=1;i<m;i++)
            for(j=1;j<n;j++){
                if(dp[i-1][j] < dp[i][j-1])
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                else
                    dp[i][j] = dp[i][j-1] + grid[i][j];
            }
        return dp[m-1][n-1];
    }
}