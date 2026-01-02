/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (44.83%)
 * Likes:    18355
 * Dislikes: 874
 * Total Accepted:    4.4M
 * Total Submissions: 8.7M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r){
            // int mid = (left + right) / 2 // traditional
            int mid = ((r - l) / 2) + l;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // System.out.println("LLLL " + l + " :: " + r);

        return l;
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,6};

        searchInsert(arr, 0);
    }
}
// @lc code=end

