/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (70.36%)
 * Likes:    13368
 * Dislikes: 3425
 * Total Accepted:    3.2M
 * Total Submissions: 4.6M
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,0,1]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is
 * the missing number in the range since it does not appear in nums.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is
 * the missing number in the range since it does not appear in nums.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * 
 * Output: 8
 * 
 * Explanation:
 * 
 * n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is
 * the missing number in the range since it does not appear in
 * nums.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 * 
 * 
 * 
 * Follow up: Could you implement a solution using only O(1) extra space
 * complexity and O(n) runtime complexity?
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println("THE SORTED ARRAY ISS ::: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                
                return i;
            }
        }

        return ++nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3 };
        int result = missingNumber(input);
        System.out.println("INPUT RESULT IS :: " + result);
    }
}
// @lc code=end
