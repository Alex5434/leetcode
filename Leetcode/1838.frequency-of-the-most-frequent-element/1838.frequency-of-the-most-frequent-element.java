
import java.util.Arrays;

/*
 * @lc app=leetcode id=1838 lang=java
 *
 * [1838] Frequency of the Most Frequent Element
 *
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
 *
 * algorithms
 * Medium (46.62%)
 * Likes:    5294
 * Dislikes: 280
 * Total Accepted:    219.7K
 * Total Submissions: 497.1K
 * Testcase Example:  '[1,2,4]\n5'
 *
 * The frequency of an element is the number of times it occurs in an array.
 * 
 * You are given an integer array nums and an integer k. In one operation, you
 * can choose an index of nums and increment the element at that index by 1.
 * 
 * Return the maximum possible frequency of an element after performing at most
 * k operations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element
 * two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a
 * frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a
 * frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has
 * a frequency of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    // public static int maxFrequency(int[] nums, int k) {
    // Arrays.sort(nums);
    // for (int i = nums.length - 1; i >=0 ; i--) {
    // System.out.println("LLLLLL "+ nums[i] + " " + i);
    // int credits = k;
    // int[] tempArray = new int[i + 1];
    // tempArray[i] = nums[i];
    // for (int j = i - 1 ; j >= 0 ; j--) {
    // int difference = nums[j+1] - nums[j];
    // System.out.println("DIFFERENCE IS"+ difference);
    // if(difference <= credits){
    // //
    // tempArray[j] = nums[j] + difference;
    // credits -= difference;
    // } else{
    // tempArray[j] = nums[j];
    // }
    // System.out.println("THE TEMP J ARRAY IS" + nums[j] + " " + difference);
    // }
    // System.out.println("ARRAYS TO BE DECUED :::" + Arrays.toString(tempArray));
    // }
    // return 1;
    // }


    // Solved the max frequency with the sliding window approach
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, maxLength = 0;
        long currentSum = 0;
        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            currentSum += target;

            while (((right - left + 1) * target) - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 1, 5, 1, 3, 2 };
        int size = 3;

        int result = maxFrequency(arr, size);
        System.out.println(result);
    }

}
// @lc code=end
