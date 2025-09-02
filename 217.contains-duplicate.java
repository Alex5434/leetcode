
import java.util.HashSet;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (61.17%)
 * Likes:    13086
 * Dislikes: 1337
 * Total Accepted:    5.4M
 * Total Submissions: 8.5M
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The element 1 occurs at the indices 0 and 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * All elements are distinct.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * 
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };

        boolean result = containsDuplicate(arr);

        System.out.println("RESULT ISS :: " + result);
    }
}
// @lc code=end
