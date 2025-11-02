/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (68.08%)
 * Likes:    11264
 * Dislikes: 252
 * Total Accepted:    1.1M
 * Total Submissions: 1.5M
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start

class Solution {

    // public static boolean isPalindrome(String s) {

    // for (int i = 0; i < (s.length()) / 2; i++) {
    // System.out.println("JJJJJJJ :: " + s.charAt(i) + " OO " + s.charAt(s.length()
    // - i - 1));
    // if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
    // return false;
    // }
    // }
    // return true;
    // }

    // public static int countSubstrings(String s) {
    // ArrayList<String> stringMap = new ArrayList<>();

    // for (int i = 0; i < s.length(); i++) {
    // for (int j = i; j < s.length(); j++) {
    // System.out.println("THE I AND J ISSSSSSS " + i + " " + j);
    // System.out.println("Substring :: " + s.substring(i, j + 1));

    // boolean isPalin = isPalindrome(s.substring(i, j + 1));
    // System.out.println("PLANINNNN :: " + isPalin);
    // if (isPalin) {
    // stringMap.add(s.substring(i, j + 1));
    // }
    // }
    // System.out.println();
    // }

    // System.out.println("stirngMappp :: " + stringMap);

    // return stringMap.size();
    // }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, i, count);
            System.out.println("CCC :: " + count);
            findPalindrome(s, i, i + 1, count);
            System.out.println("BBB :: " + count);
        }
        System.out.println("the count isssss" + count);
        return count;  
    }

    public static void findPalindrome(String s, int l, int r, int count) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            System.out.println("!!!!!!!!!!!" + count);
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));

    }
}
// @lc code=end