/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (62.83%)
 * Likes:    18901
 * Dislikes: 839
 * Total Accepted:    3.2M
 * Total Submissions: 4.9M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * 
 * Output: [1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * 
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);
        List<Integer>[] freqBucket = new List[nums.length + 1];
        int[] resultArray = new int[k];

        // [{1, 2}, {2, 3}]

        int freqCounter = 1;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1 < nums.length) && nums[i] == nums[i + 1]) {
                freqCounter++;
            } else {

                if (freqBucket[freqCounter] != null) {
                    freqBucket[freqCounter].add(nums[i]);
                } else {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(nums[i]);
                    freqBucket[freqCounter] = newList;
                }
                freqCounter = 1;
            }
        }

        //
        for (int i = freqBucket.length - 1; i >= 0; i--) {
            if (k == 0) {
                return resultArray;
            }

            if (freqBucket[i] != null) {
                List<Integer> parseList = freqBucket[i];
                for (Integer num : parseList) {
                    if (k == 0) {
                        return resultArray;
                    }
                    resultArray[--k] = num;
                }

            }

        }


        return resultArray;
    }

    public static void main(String[] args) {
        int arr[] = { 1 };
        int k = 1;

        int[] result =  topKFrequent(arr, k);

        System.out.println("Arrays to strong ::" + Arrays.toString(result));

    }
}
// @lc code=end
