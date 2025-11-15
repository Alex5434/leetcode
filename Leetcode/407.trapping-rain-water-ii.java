/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 *
 * https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (47.68%)
 * Likes:    4955
 * Dislikes: 167
 * Total Accepted:    257.1K
 * Total Submissions: 402.6K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * Given an m x n integer matrix heightMap representing the height of each unit
 * cell in a 2D elevation map, return the volume of water it can trap after
 * raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * Output: 4
 * Explanation: After the rain, water is trapped between the blocks.
 * We have two small ponds 1 and 3 units trapped.
 * The total volume of water trapped is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: heightMap =
 * [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * Output: 10
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 10^4
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    public static int trapRainWater(int[][] heightMap) {
        int curLeft = 0, curRight = 0, curTop = 0, curBottom = 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        int[][] leftMax = new int[rows][cols], rightMax = new int[rows][cols];
        int[][] topMax = new int[rows][cols], bottomMax = new int[rows][cols];

        int result = 0;

        // for left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                curLeft = Math.max(curLeft, heightMap[i][j]);
                leftMax[i][j] = curLeft;
            }
            curLeft = 0;
        }

        // for right
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                curRight = Math.max(curRight, heightMap[i][j]);
                rightMax[i][j] = curRight;
            }
            curRight = 0;
        }

        // for left
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                curTop = Math.max(curTop, heightMap[j][i]);
                topMax[j][i] = curTop;
            }
            curTop = 0;
        }

        // for right
        for (int i = 0; i < cols; i++) {
            for (int j = rows - 1; j >= 0; j--) {
                curBottom = Math.max(curBottom, heightMap[j][i]);
                bottomMax[j][i] = curBottom;
            }
            curBottom = 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += Math.min(Math.min(leftMax[i][j], rightMax[i][j]), Math.min(topMax[i][j], bottomMax[i][j])) - heightMap[i][j];
                
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        
        // int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        
        int[][] heightMap = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        System.out.println(trapRainWater(heightMap));
    }
}
// @lc code=end
