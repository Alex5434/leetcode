/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (33.67%)
 * Likes:    34069
 * Dislikes: 3181
 * Total Accepted:    5.2M
 * Total Submissions: 13.7M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());

        Arrays.sort(nums);

        System.out.println("Arrays sorted ::" + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int left = i, right = i;

            int currentPointerSum = nums[i];

            while (left >= 0 || right <= nums.length) {
                System.out.println("LEFT :: " + left + " RIGHT :: " + right);
                if (currentPointerSum < 0 ) {
                    currentPointerSum += nums[]
                    right++;
                } else if (currentPointerSum == 0) {
                    System.out.println("Found the match ::: " + nums[i] + " " + nums[right] + " " + nums[left]);
                    break;
                } else {
                    left--;
                }

                // if (left < 0) {
                // right++;
                // } else if (right > nums.length) {
                // left--;
                // } else {
                // left--;
                // right++;
                // }

                // currentPointerSum += nums[]

            }

        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }
}
// @lc code=end
