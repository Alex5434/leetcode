/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (43.34%)
 * Likes:    9818
 * Dislikes: 2219
 * Total Accepted:    1.8M
 * Total Submissions: 3.9M
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * 011
 * 011
 * Output: true
 * 
 * Explanation:
 * 
 * The strings s and t can be made identical by:
 * 
 * 
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * 
 * 0
 * 0
 * Output: false
 * 
 * Explanation:
 * 
 * The strings s and t can not be made identical as 'o' needs to be mapped to
 * both 'a' and 'r'.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * 
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (chars.containsKey(first)) {
                if (chars.get(first) != second) {
                    return false;
                }
            } else if (chars.containsValue(second)) {
                return false;
            }
            chars.put(first, second);
        }
        return true;
    }

    public static void main(String[] args) {
        // badc baba
        boolean result = isIsomorphic("egc", "add");
        System.out.println("The result os" + result);
    }
}
// @lc code=end
