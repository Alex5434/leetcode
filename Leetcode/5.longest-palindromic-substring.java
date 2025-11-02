/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (36.07%)
 * Likes:    31177
 * Dislikes: 1919
 * Total Accepted:    4M
 * Total Submissions: 11.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = loopAndExpand(s, i, i);
            int even = loopAndExpand(s, i, i + 1);

            int max_len = Math.max(odd, even);

            if(max_len > end - start){
                start = i -  (max_len - 1) /2;
                end = i + max_len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    public static int loopAndExpand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        longestPalindrome("bccba");
    }
}
// @lc code=end
