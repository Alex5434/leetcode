/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (53.68%)
 * Likes:    14578
 * Dislikes: 461
 * Total Accepted:    1.4M
 * Total Submissions: 2.5M
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * You are given an m x n grid where each cell can have one of three
 * values:
 * 
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * 
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [
 *  [2,1,1],
 *  [0,1,1],
 *  [1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never
 * rotten, because rotting only happens 4-directionally.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {

    public static int orangesRotting(int[][] grid) {
        int minutes = 0;
        int rows = grid.length, cols = grid[0].length;

        int freshCount = 0;

        // decalre a queue
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        System.out.println("Queue size ::"+ queue.size());
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            // first loop to start rotting from all location
            for (int i = 0; i < size; i++) {
                int[] rottenCell = queue.poll();

                int r = rottenCell[0];
                int c = rottenCell[1];

                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR < 0 || newC < 0 || newR >= rows || newC >= cols || grid[newR][newC] != 1) {
                        continue;
                    }

                    grid[newR][newC] = 2;
                    freshCount--;
                    queue.offer(new int[] { newR, newC });
                }

            }
            System.out.println("LLLLLLLLL :: " + Arrays.deepToString(grid));
            minutes++;

        }
        return freshCount > 0 ? -1 : minutes;

    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 2, 1, 1 },
        // { 0, 1, 1 },
        // { 1, 0, 1 }
        // };

        // int[][] grid = {
        // { 2, 1, 1 },
        // { 1, 1, 0 },
        // { 0, 1, 1 }
        // };

        // {
        // { 2, 1, 1 },
        // { 0, 1, 1 },
        // { 1, 0, 1 }
        // };

        int[][] grid = { 
            { 2, 1, 1 }, 
            { 1, 1, 1 }, 
            { 0, 1, 2 } };
        
            int result = orangesRotting(grid);
        System.out.println("KKKKKKKKKKKKKKK " + result);
    }
}
// @lc code=end
