/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (67.90%)
 * Likes:    25149
 * Dislikes: 1636
 * Total Accepted:    4.1M
 * Total Submissions: 6M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    // O(n) optimal solution but not
    public static int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len], suffix = new int[len];

        prefix[0] = 1;
        suffix[len - 1] = 1;

        // fill the prefix array

        for (int i = 1; i < suffix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // fill the suffix array
        for (int i = len - 2; i >= 0; i--) {
            // len = 3 2 1 0
            suffix[i] = suffix[i + 1] * nums[i];
            System.out.println("THE SUFFIX :: " + Arrays.toString(suffix));
        }

        System.out.println("PREFIX :: " + Arrays.toString(prefix));
        System.out.println("SUFFiX :: " + Arrays.toString(suffix));

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        System.out.println("III :: " + Arrays.toString(ans));
        return nums;
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);

        int cur = 1;

        for (int i = 0; i < len; i++) {
            result[i] *= cur;
            cur *= nums[i];
        }

        cur = 1;

        for (int i = len - 1; i >= 0; i--) {
            result[i] *= cur;
            cur *= nums[i];
        }

        // System.out.println("THE RESULT ARRAY ISSSSSS::::" + Arrays.toString(result));

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        productExceptSelf(arr);
    }
}
// @lc code=end

