Nice — you’re asking about LeetCode 139 – Word Break. Let’s walk through how to solve it. I’ll explain the reasoning step by step before thinking about code.

🔹 Problem Restatement

You’re given:

A string s

A dictionary of words wordDict (list of strings)

You need to check if s can be segmented into one or more words that are all in the dictionary.

Example

s = "leetcode", wordDict = ["leet","code"]
Output: true   // because "leet code"

🔹 Key Observations

At each position in the string, you want to know:
“Can I cut the string here, such that the left part is valid and the right part starts with a dictionary word?”

This screams Dynamic Programming (DP), because:

Subproblems: Can substring s[0..i] be broken into words?

Build up to solve for the full string.

🔹 DP Approach

We’ll use a boolean DP array:

dp[i] = true if substring s[0..i-1] can be segmented.

Steps:

Initialize:

dp[0] = true (empty string is valid).

For each index i from 1 → n:

Check every word in the dictionary:

If word length fits, and dp[i - word.length()] == true, and substring matches the word → mark dp[i] = true.

Return dp[n].

🔹 Example Walkthrough

s = "applepenapple", wordDict = ["apple","pen"]

dp[0] = true

i=5 → substring "apple" matches, dp[5] = true

i=8 → "pen" matches after "apple", so dp[8] = true

i=13 → "apple" matches after "applepen", so dp[13] = true

Final answer: dp[13] = true

🔹 Complexity

Let n = len(s), m = max length of a word in dict, k = size of wordDict.

Time: O(n * k * m) (in practice, usually fine).

Space: O(n).

What dp[i] means

dp[i] == true means the prefix s[0..i-1] can be segmented into words from wordDict.

dp[0] = true because the empty prefix is trivially segmented.

Note: s.substring(j, i) in Java returns the substring starting at index j inclusive and ending at i exclusive.

Initial state

s = "leetcode", length n = 8

dp has size n+1 = 9 → indices 0..8

Start:
dp = [ true, false, false, false, false, false, false, false, false ]

Walkthrough by i
i = 1 (consider prefix "l")

j = 0: dp[0] is true. Check s.substring(0,1) → "l".
"l" not in wordSet.

No other j values.

dp[1] stays false.

i = 2 (prefix "le")

j = 0: dp[0] true → s.substring(0,2) = "le" → not in set.

j = 1: dp[1] false → skip (because dp[j] && ... short-circuits).

dp[2] stays false.

i = 3 (prefix "lee")

j = 0: s.substring(0,3) = "lee" → not in set.

j = 1: dp[1] false → skip.

j = 2: dp[2] false → skip.

dp[3] stays false.

i = 4 (prefix "leet")

j = 0: dp[0] true → s.substring(0,4) = "leet" → IN wordSet!
So set dp[4] = true and break.

dp becomes: [ true, false, false, false, true, false, false, false, false ]

i = 5 (prefix "leetc")

j = 0: s.substring(0,5) = "leetc" → not in set.

j = 1..3: dp[1..3] are false → skipped.

j = 4: dp[4] true → check s.substring(4,5) = "c" → not in set.

No match → dp[5] = false.

i = 6 (prefix "leetco")

j = 0: "leetco" not in set.

j = 1..3: dp[1..3] false → skipped.

j = 4: dp[4] true → s.substring(4,6) = "co" → not in set.

dp[6] = false.

i = 7 (prefix "leetcod")

j = 4: dp[4] true → s.substring(4,7) = "cod" → not in set.

No match → dp[7] = false.

i = 8 (prefix "leetcode")

j = 4: dp[4] true → s.substring(4,8) = "code" → IN wordSet!
Set dp[8] = true and break.

Final dp:

[ true, false, false, false, true, false, false, false, true ]


Return dp[8] == true → answer is true.

Why this works (short form)

For each i, we look for some j < i such that:

dp[j] is true (so s[0..j-1] can be segmented), and

s[j..i-1] is a dictionary word.

If both hold, then s[0..i-1] can be segmented → dp[i] = true.

The break saves work — once you prove dp[i] is true you don't need more checks.