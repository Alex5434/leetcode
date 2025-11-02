/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (57.99%)
 * Likes:    31894
 * Dislikes: 2047
 * Total Accepted:    4.3M
 * Total Submissions: 7.4M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * You are given an integer array height of length n. There are n vertical
 * lines drawn such that the two endpoints of the i^th line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {

    // btrute force approach
    // public static int maxArea(int[] height) {

    // int maxCapacity = 0;

    // for (int i = 0; i < height.length; i++) {
    // // int currentLow = height[i];

    // for (int j = i + 1; j < height.length; j++) {
    // System.out.println("CURRENT LOW :: " + height[i] + " J VALUE :: " + height[j]
    // + " MIN ::: " + Math.min(height[i], height[j]) * (j - i));
    // System.out.println("JJJJJJ :: " + j + " IIIII:: " + i);
    // maxCapacity = Math.max(maxCapacity, Math.min(height[i], height[j]) * (j -
    // i));
    // }
    // System.out.println();
    // }

    // return maxCapacity;
    // }

    public static int maxArea(int[] height) {

        int maxCapacity = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minValue = Math.min(height[left], height[right]);
            maxCapacity = Math.max(maxCapacity, minValue * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }

    public static void main(String[] args) {
        int arr[] = { 1,8,6,2,5,4,8,3,7 };
        System.out.println("MAX RESULT ISS ::" + maxArea(arr));
    }
}
// @lc code=end

// 2 8 6 8 1
