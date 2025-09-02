/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (34.87%)
 * Likes:    19652
 * Dislikes: 796
 * Total Accepted:    1.7M
 * Total Submissions: 4.9M
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any subarray of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    // public static int maxProduct(int[] nums) {
    // int maxSoFar = nums[0]; // Max product seen so far
    // int maxEndingHere = nums[0]; // Max product ending at current index
    // int minEndingHere = nums[0]; // Min product ending at current index

    // System.out.println("Initial Values:");
    // System.out.println("maxSoFar = " + maxSoFar);
    // System.out.println("maxEndingHere = " + maxEndingHere);
    // System.out.println("minEndingHere = " + minEndingHere);
    // System.out.println("--------------------------------");

    // for (int i = 1; i < nums.length; i++) {
    // int current = nums[i];
    // int temp = maxEndingHere; // store current max before updating

    // // Calculate new max and min
    // maxEndingHere = Math.max(current, Math.max(current * maxEndingHere, current *
    // minEndingHere));
    // minEndingHere = Math.min(current, Math.min(current * temp, current *
    // minEndingHere));

    // // Update maxSoFar
    // maxSoFar = Math.max(maxSoFar, maxEndingHere);

    // // Debug logs
    // System.out.println("At index " + i + " (num = " + current + "):");
    // System.out.println(" Temp maxEndingHere (before update) = " + temp);
    // System.out.println(" New maxEndingHere = " + maxEndingHere);
    // System.out.println(" New minEndingHere = " + minEndingHere);
    // System.out.println(" Updated maxSoFar = " + maxSoFar);
    // System.out.println("--------------------------------");
    // }

    // return maxSoFar;
    // }

    // Optimal solution
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            int temp = maxEndingHere;
            maxEndingHere = Math.max(currentNum, Math.max(currentNum * maxEndingHere, currentNum * minEndingHere));
            minEndingHere = Math.min(currentNum, Math.min(currentNum * temp, currentNum * minEndingHere));

            maxProduct = Math.max(maxProduct, maxEndingHere);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] input = { -2, -1, -2, 3, 8};
        int result = maxProduct(input);
        System.out.println("RESULT IS :: " + result);

    }
}
// @lc code=end