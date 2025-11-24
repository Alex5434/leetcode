/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 *
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
 *
 * algorithms
 * Easy (39.65%)
 * Likes:    2685
 * Dislikes: 295
 * Total Accepted:    297.8K
 * Total Submissions: 747K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]'
 *
 * You are given an integer array coordinates, coordinates[i] = [x, y], where
 * [x, y] represents the coordinate of a point. Check if these points make a
 * straight line in the XY plane.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {

    public static boolean checkStraightLine(int[][] coordinates) {
        int[] startPoint = coordinates[0];
        int[] lastPoint = coordinates[coordinates.length - 1];

        int slope = (Math.abs(lastPoint[1] - startPoint[1]))/(Math.abs(lastPoint[0] - startPoint[0]));

        for(int i = 1; i < coordinates.length - 1; i++){
            int[] first = coordinates[i];
            int[] last = coordinates[i + 1];
            
            int currentSlope = Math.abs(last[1] - first[1])/Math.abs(last[0] - first[0]);
            
            if(slope != currentSlope){
                return false;
            }
        }
        
        return true;
    }
    // System.out.println("FIRST :: " + Arrays.toString(first) + " SECOND :: "+ Arrays.toString(last));
    
    public static void main(String[] args){
        // int [][] points = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        // int [][] points = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int [][] points = {{0,0},{0,1},{0,-1}};

        boolean status = checkStraightLine(points);
        System.out.println("LLL::" + status);
    }
}
// @lc code=end

