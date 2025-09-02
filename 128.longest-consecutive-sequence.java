
import java.util.Arrays;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (47.40%)
 * Likes:    21770
 * Dislikes: 1179
 * Total Accepted:    2.7M
 * Total Submissions: 5.8M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,0,1,2]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public static int longestConsecutive(int[] nums) {

        if(nums.length <= 0){
            return 0;
        }

        Arrays.sort(nums);
        int maxSequence = 0;
        int currentLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i + 1] == nums[i] + 1) {
                currentLength++;
            } else {
                maxSequence = Math.max(currentLength, maxSequence);
                currentLength = 0;
            }
        }
        maxSequence = Math.max(currentLength, maxSequence);
        return maxSequence + 1;
    }

    public static void main(String[] args) {
        int arr[] = {  };

        System.out.println("RESULT ISSSS : " + longestConsecutive(arr));
    }
}
// @lc code=end
