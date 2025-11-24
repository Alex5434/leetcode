/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (63.87%)
 * Likes:    21993
 * Dislikes: 783
 * Total Accepted:    4.9M
 * Total Submissions: 7.4M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * The input is generated such that a majority element will exist in the
 * array.
 * 
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

// @lc code=start

import java.util.*;

class Solution {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int maxFreq = 0, curFreq = 0;
        int maxEle = 0;


        for (int i = 0; i < nums.length - 1; i++) {
            // the elements are same
            // System.out.println("CURRR FREE ::");
            if (nums[i] == nums[i + 1]) {
                curFreq++;
            } else {
                curFreq = 0;
            }
            
            if (maxFreq < curFreq) {
                maxEle = nums[i];
                maxFreq = curFreq;
            }
        }

        return maxEle;
    }

    public static void main(String[] args) {
        // int arr[] = {1, 1, 2, 2, 2, 3, 4, 5};
        // int arr[] = {3, 3, 4};
        // int arr[] = {3, 3, 2};
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
// @lc code=end



