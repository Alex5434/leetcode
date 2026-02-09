/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (59.19%)
 * Likes:    12730
 * Dislikes: 237
 * Total Accepted:    1.1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 1,1,3,3,4,4,7,8,8
     * 0 1 2 3 4 5 6 7 8
     *  */ 
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;

            // if m%2 == 0 =>  arr[m] == arr[m + 1]
            // else arr[m] = arr[m] == arr[m - 1]

            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] == nums[m - 1]) {
                    r = m - 1;
                } else{
                    l = m + 1;
                }
            }
        }

        System.out.println("KKKK" + r);
        return nums[l + 1];
    }

    public static void main(String [] args){
        int arr[] = {3,3,7,7,10,11,11};

        singleNonDuplicate(arr);
    }
}
// @lc code=end

