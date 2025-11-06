/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Time to Make Rope Colorful
 *
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
 *
 * algorithms
 * Medium (62.96%)
 * Likes:    4008
 * Dislikes: 146
 * Total Accepted:    303.3K
 * Total Submissions: 475K
 * Testcase Example:  '"abaac"\n[1,2,3,4,5]'
 *
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string
 * colors where colors[i] is the color of the i^th balloon.
 * 
 * Alice wants the rope to be colorful. She does not want two consecutive
 * balloons to be of the same color, so she asks Bob for help. Bob can remove
 * some balloons from the rope to make it colorful. You are given a 0-indexed
 * integer array neededTime where neededTime[i] is the time (in seconds) that
 * Bob needs to remove the i^th balloon from the rope.
 * 
 * Return the minimum time Bob needs to make the rope colorful.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: colors = "abaac", neededTime = [1,2,3,4,5]
 * Output: 3
 * Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
 * Bob can remove the blue balloon at index 2. This takes 3 seconds.
 * There are no longer two consecutive balloons of the same color. Total time =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: colors = "abc", neededTime = [1,2,3]
 * Output: 0
 * Explanation: The rope is already colorful. Bob does not need to remove any
 * balloons from the rope.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: colors = "aabaa", neededTime = [1,2,3,4,1]
 * Output: 2
 * Explanation: Bob will remove the balloons at indices 0 and 4. Each balloons
 * takes 1 second to remove.
 * There are no longer two consecutive balloons of the same color. Total time =
 * 1 + 1 = 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == colors.length == neededTime.length
 * 1 <= n <= 10^5
 * 1 <= neededTime[i] <= 10^4
 * colors contains only lowercase English letters.
 * 
 * 
 */

// @lc code=start

class Solution {

    // Approach failed and only work for two consistent color
    // public static int minCost(String colors, int[] neededTime) {
    // HashMap<Character, Integer> myMap = new HashMap<>();

    // int minimunTime = 0;
    // int currentTime = 0;

    // for (int i = 0; i < neededTime.length - 1; i++) {

    // myMap.put(colors.charAt(i), i);

    // if (colors.charAt(i) != colors.charAt(i + 1)) {
    // continue;
    // }

    // // get the cost of both the elements
    // int firstCost = neededTime[i];
    // int secondCost = neededTime[i + 1];

    // System.out.println("THE FIRST AND THE SECOND ELEMENT ISS ::::::::" +
    // firstCost + " :: " + secondCost);

    // currentTime = Math.min(firstCost, secondCost);
    // minimunTime += currentTime;

    // i++;
    // }

    // System.out.println("MINIMUM time osss ::::::" + minimunTime);

    // return minimunTime;
    // }

    /* Trying two pointer approach */
    // public static int minCost(String colors, int[] neededTime) {

    // int minMinute = 0;
    // int currentMaxElement = 0;

    // int left = 0, right = 1;

    // while (right < colors.length()) {
    // char f = colors.charAt(left);
    // currentMaxElement = neededTime[left];
    // int windowSum = neededTime[left];
    // if (f == colors.charAt(right)) {
    // while (right < colors.length() && f == colors.charAt(right)) {
    // windowSum += neededTime[right];
    // currentMaxElement = Math.max(currentMaxElement, neededTime[right]);
    // right++;
    // }
    // left = right - 1;
    // minMinute += windowSum - currentMaxElement;
    // } else {
    // left++;
    // right++;
    // }
    // }

    // return minMinute;
    // }

    public static int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int maxTimeInGroup = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Same color → remove the smaller one
                totalTime += Math.min(maxTimeInGroup, neededTime[i]);
                maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[i]);
            } else {
                // New color → reset group
                maxTimeInGroup = neededTime[i];
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        String colors = "aaabc";
        int[] needTime = { 2, 1, 4, 2, 3 };

        // String colors = "bbbaaa";
        // int[] needTime = { 4, 9, 3, 8, 8, 9 };
        // String colors = "aabaa";
        // int[] needTime = { 1, 2, 3, 4, 1 };

        // String colors = "abc";
        // int[] needTime = { 1, 2, 3 };

        // String colors = "abaac";
        // int[] needTime = { 1, 2, 3, 4, 5 };

        int result = minCost(colors, needTime);

        System.out.println("KKKKKKKKKKKKK" + result);
    }
}
// @lc code=end
