/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (60.22%)
 * Likes:    35383
 * Dislikes: 653
 * Total Accepted:    3.2M
 * Total Submissions: 4.8M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 *      1
 * 1    1
 * 1  1 1
 * 11 111
 * 11 111
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    
    // 📝 Valid brute force worst case O(n^2) so need to optimize this to O(n)
    
    // public static int trap(int[] height) {

    //     if(height.length <= 1){
    //         return 0;
    //     }

    //     int leftMax = height[0];
    //     int rightMax = height[1];
    //     int waterStored = 0;

    //     for (int i = 1; i < height.length; i++) {
    //         rightMax = Math.max(rightMax, height[i]);
    //     }

    //     // fn to find the max left and max right

    //     for (int i = 1; i < height.length; i++) {
    //         int currentWater = Math.min(leftMax, rightMax) - height[i];
    //         if (currentWater > 0) {
    //             waterStored += currentWater;
    //         }
    //         leftMax = Math.max(leftMax, height[i]);

    //         if (height[i] >= rightMax) {
    //             rightMax = 0;
    //             for (int j = i + 1; j < height.length; j++) {
    //                 rightMax = Math.max(rightMax, height[j]);
    //             }
    //         }
    //     }

    //     return waterStored;
    // }

    // ✅ Solved in O(n) by calculating the left and right MAX index at each index
    public static int trap(int[] height) {
        int curLeft = 0 , curRight = 0; 
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        int result = 0;

        for(int i = 0; i < n; i++){
            curLeft = Math.max(curLeft, height[i]);
            leftMax[i] = curLeft;
        }
        for(int i = n - 1; i >= 0; i--){
            curRight = Math.max(curRight, height[i]);
            rightMax[i] = curRight;
        }

        for(int i = 0; i < n; i++){
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height = { 6 };
        int[] height = { 4,2,0,3,2,5 };

        System.out.println(trap(height));
        // trap(height);
    }
}
// @lc code=end
