/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (71.88%)
 * Likes:    10469
 * Dislikes: 217
 * Total Accepted:    1.1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]'
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected
 * 4-directionally.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * 
 * 
 */

// @lc code=start

class Solution {

    static int loopCounter = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    loopCounter = 0;
                    dfs(grid, r, c);
                    maxArea = Math.max(maxArea, loopCounter);
                }
            }
        }
        return maxArea;
    }

    public static void dfs(int[][] grid, int r, int c) {
        if (r < 0 && c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }

        loopCounter++;
        grid[r][c] = 0;

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }


    public static void main(String[] args) {

        // int[][] grid = {
        // { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
        // { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
        // { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

        // int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0 } };

        // int result = maxAreaOfIsland(grid);
        // System.out.println("KKKKKKKKKKKKKKK" + result);
    }
}
// @lc code=end
