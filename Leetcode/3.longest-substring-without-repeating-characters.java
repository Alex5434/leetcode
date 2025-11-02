
import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (34.19%)
 * Likes:    42559
 * Dislikes: 2068
 * Total Accepted:    7.8M
 * Total Submissions: 21M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {

    // Brute force approach

    // public static int lengthOfLongestSubstring(String s) {
    //     int right = s.length();
    //     int maxFrequecy = 0;

    //     for (int left = 0; left < right; left++) {
            
    //         int temp = left;
    //         HashSet<Character> charSet = new HashSet<>();
    //         int tempFrequency = 0 ;

    //         while(temp != right && !charSet.contains(s.charAt(temp))){
    //             charSet.add(s.charAt(temp));
    //             temp++;
    //             tempFrequency++;
    //         }
    //         maxFrequecy = Math.max(tempFrequency, maxFrequecy);
    //     }
    //     return maxFrequecy;
    // }

    // Optimal approach using sliding window two pointer approach
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();

        int left=0, right=0, maxlen=0;

        while (right < s.length()) {
            if(!seen.contains(s.charAt(right))){
                seen.add(s.charAt(right));
                maxlen = Math.max(maxlen, right - left + 1);
                right++;
            } else{
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxlen;
    }


    public static void main(String[] args) {
        String s = "pwwkew";

        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
// @lc code=end

