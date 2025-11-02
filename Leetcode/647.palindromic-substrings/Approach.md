✅ Optimized Approach

The standard way is to expand around the center:

A palindrome mirrors around its center.

A string of length n has 2n - 1 possible centers (each character + between characters).

For each center, expand outward while the substring is a palindrome.

This gives O(n²) time and O(1) extra space.

Here’s the optimized Java solution:

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}

🔍 Example Walkthrough (s = "aaa")

Centers:

"a" (index 0) → palindrome

"a" (index 1) → palindrome

"a" (index 2) → palindrome

"aa" (0–1) → palindrome

"aa" (1–2) → palindrome

"aaa" (0–2) → palindrome

Total = 6, which matches the expected output.

👉 Your brute-force version is good for learning, but for Leetcode 647, you’ll need the expand-around-center version above.

Do you want me to also show you the DP (Dynamic Programming) version (O(n²) time & space)