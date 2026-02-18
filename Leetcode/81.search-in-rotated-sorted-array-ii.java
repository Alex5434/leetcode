/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (37.33%)
 * Likes:    9548
 * Dislikes: 1117
 * Total Accepted:    1.2M
 * Total Submissions: 3M
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * There is an integer array nums sorted in non-decreasing order (not
 * necessarily with distinct values).
 * 
 * Before being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and
 * become [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true
 * if target is in nums, or false if it is not in nums.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * 
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums is guaranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 * 
 * 
 * 
 * Follow up: This problem is similar to Search in Rotated Sorted Array, but
 * nums may contain duplicates. Would this affect the runtime complexity? How
 * and why?
 * 
 */

// @lc code=start
class Solution {
    public static boolean search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            System.out.println("THE LEFT :: " + l + " MIDDDD :: " + m + " RIGHT ::: " + r);
            if (nums[m] == target) {
                return true;
            } else if (nums[l] == nums[m]) {
                l++;
            } else if (nums[r] == nums[m]) {
                r--;
            } 
            else if (nums[m] <= nums[r]) {
                // right half is sorted
                // if()
                if(nums[m] <= target && target <= nums[r]){
                    l = m + 1;
                } else {
                    r  = m - 1;
                }
            } else if (nums[l] <= nums[m]) {
                // left half is sorted
                if(nums[l] <= target && target <= nums[m]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return false;
    }

    // 2,5,6,0,0,1,2

    // check if the middle element is the target element

    // find left or right half is sorted

    public static void main(String[] args) {
        // int nums[] = { 2, 5, 6, 0, 0, 1, 2 };
        int nums[] = { 1,1,3,1 };
        int target = 3;

        System.out.println("RESULT  ::: " + search(nums, target));
    }
}
// @lc code=end
