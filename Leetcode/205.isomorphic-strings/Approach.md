Solution 1 - Two HashMaps
Input: s = "egg", t = "add"
Simply, each character of both strings should be a pair, that means their indices should be the same.

To keep character and its index, we use two hashMaps.

char_index_s = {}
char_index_t = {}
First of all

s = "egg", t = "add"
     ↑          ↑

e and a should be index 0

char_index_s = {e: 0}
char_index_t = {a: 0}
Next compare the indices of e and a. They are the same which is no porblem.

Move next

s = "egg", t = "add"
      ↑          ↑

g and d should be index 1

char_index_s = {e: 0, g: 1}
char_index_t = {a: 0, d: 1}
Compare the indices of g and d. They are the same which is no porblem.

Move next

s = "egg", t = "add"
       ↑          ↑

char_index_s = {e: 0, g: 1}
char_index_t = {a: 0, d: 1}
g and d should be index 1, because we already found the characters at index 1. To prove that, we have g and d in HashMaps.

Compare g and d. They are index 1 which is no problem.

Now we reach end of strings.

return True
Let's see false case. You will understand algorithm deeply. What if the last characters are a and d.

s = "ega", t = "add"
       ↑          ↑

char_index_s = {e: 0, g: 1, a: 2}
char_index_t = {a: 0, d: 1}
In that case, a is a new character, so add a to HashMap with index 2. We already found d at index 1, so we don't add this time.

Next, compare indices of a and d.

a is index 2
d is index 1
They are different indices, that means we already use d with other character.

return False


Complexity
This is based on Python. Ohter might be different.

Time complexity: O(n)
n is length of input string

Space complexity: O(1)
s and t consist of any valid ascii character.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> charIndexS = new HashMap<>();
        HashMap<Character, Integer> charIndexT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charIndexS.containsKey(s.charAt(i))) {
                charIndexS.put(s.charAt(i), i);
            }

            if (!charIndexT.containsKey(t.charAt(i))) {
                charIndexT.put(t.charAt(i), i);
            }

            if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
                return false;
            }
        }

        return true;        
    }
}
Step by Step Algorithm
Initialization:

char_index_s = {}
char_index_t = {}
Explanation: Two empty dictionaries (char_index_s and char_index_t) are initialized. These dictionaries will store the first index at which each character appears in the strings s and t, respectively.
Loop Through the Characters:

for i in range(len(s)):
Explanation: A for loop iterates over the range of the length of the string s. The variable i represents the current index of the characters being processed from both strings.
Check for Characters in s:

if s[i] not in char_index_s:
    char_index_s[s[i]] = i
Explanation: For the character at index i in string s, the code checks if that character is already a key in char_index_s. If it is not, it adds the character as a key and sets its value to the current index i. This records the first occurrence of the character in s.
Check for Characters in t:

if t[i] not in char_index_t:
    char_index_t[t[i]] = i
Explanation: Similarly, for the character at index i in string t, the code checks if it is not already a key in char_index_t. If it is not present, the character is added to the dictionary with its index i. This records the first occurrence of the character in t.
Compare Indices:

if char_index_s[s[i]] != char_index_t[t[i]]:
    return False
Explanation: The code checks whether the index of the current character from s in char_index_s matches the index of the corresponding character from t in char_index_t. If they do not match, it means that the characters are not isomorphic (i.e., they do not maintain the same character mapping), so the function returns False.
Final Return:

return True
Explanation: If the loop completes without finding any discrepancies, it means that the strings s and t are isomorphic. The function returns True, indicating that there is a one-to-one mapping of characters between the two strings.
Solution 2 - One HashMap
In solution 2, we use one HashMap. We keep characters in s as a key and characters in t as a value.

Input: s = "egg", t = "add"
First of all, we found e and a. Since we don't have any data in char_map, just add e and a to it.

s = "egg", t = "add"
     ↑          ↑

char_map = {e: a}
Next, we found g and d.

s = "egg", t = "add"
      ↑          ↑

char_map = {e: a}

Do we have "g" as a key in char_map? → No
Do we have "d" as a value in char_map  → No
Then, add "g" and "d".

char_map = {e: a, g: d}
s = "egg", t = "add"
       ↑          ↑

char_map = {e: a, g: d}

Do we have "g" as a key in char_map? → yes

char_map[g] != "d" → no
that means we have the same pair before, no problem

char_map = {e: a, g: d}
Finish iteration.

return True
Why do we check all values?
Somebody is wondering why we check all values? Let's see this example quickly.

Input: s = "egc", t = "add"
Let's iterate throguh one by one without checking values.

s = "egc", t = "add"
     ↑          ↑

Do we have "e" as a key in char_map? → no
char_map = {e: a}

---------------------------
s = "egc", t = "add"
      ↑          ↑

Do we have "g" as a key in char_map? → no
char_map = {e: a, g: d}

---------------------------
s = "egc", t = "add"
       ↑          ↑

Do we have "c" as a key in char_map? → no
char_map = {e: a, g: d, c: d}
return True
That's wrong. d created two pairs.

"g" and "d"
"c" and "d"
That happened because we didn't check values. Let's check them.

s = "egc", t = "add"
       ↑          ↑

Do we have "c" as a key in char_map? → no
char_map = {e: a, g: d}

Let's check values.
Do we have "d" as a value in char_map? → yes
That's how we know d created two pairs which is not allowed.

return False
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (charMap.containsKey(sc)) {
                if (charMap.get(sc) != tc) {
                    return false;
                }
            } else if (charMap.containsValue(tc)) {
                return false;
            }

            charMap.put(sc, tc);
        }

        return true;        
    }
}
Complexity
This is based on Python. Ohter might be different.

Time complexity: O(n)
n is length of input string. For values(), it's O(128) in the worst case.

Space complexity: O(1)
s and t consist of any valid ascii character.

Step by Step Algorithm
Initialize an Empty Dictionary

char_map = {}
This line creates an empty dictionary called char_map.
This dictionary will store character mappings between the strings s and t.
char_map is used to track how characters in s are being mapped to corresponding characters in t.
Iterate Through Both Strings Simultaneously

for sc, tc in zip(s, t):
The zip(s, t) function pairs corresponding characters from s and t into tuples.
For each tuple (sc, tc), sc represents a character from s and tc represents the corresponding character from t.
The for loop iterates through each character pair one-by-one.
Check if sc (Character from s) is Already Mapped

if sc in char_map:
This line checks if sc (the character from s) is already a key in the char_map.
If sc is found in char_map, it means there is an existing mapping between sc and some character from t.
Verify the Existing Mapping

if char_map[sc] != tc:
    return False
If sc is already mapped, this line checks if the existing mapping (char_map[sc]) matches the current character from t (tc).
If it doesn’t match, the function returns False because this means the same character from s is trying to map to a different character in t, violating the isomorphism property.
Check if the Character tc (from t) is Already Mapped by Another Character

elif tc in char_map.values():
    return False
This line checks if the current character from t (tc) is already a value in char_map.
If tc is already mapped to some other character from s, it means a character from t is mapped by more than one character from s.
This also violates the isomorphism property, so the function returns False.
Create a New Mapping Between sc and tc

char_map[sc] = tc
If neither of the above conditions is met, it means sc is not in char_map and tc is not already mapped by another character.
This line creates a new mapping from sc to tc in the dictionary.
If No Violations are Found, the Strings are Isomorphic

return True
If the function successfully iterates through all the character pairs without finding any violations, it returns True.
This indicates that s and t are isomorphic.
Bonus
If number of unique characters are the same and number of unqiue pairs are the same, we can return true.

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(s)) == len(set(t)) == len(set(zip(s,t)))
For eaxample,

s = "egg", t = "add"

set(s) → "eg"
set(t) → "ad"
set(zip(s,t)) → (e,a), (g,d)
Why do we need set(zip(s,t))?
There are cases where number of unique characters are the same but unique pairs are invalid.

Let's see this example.

s = "bba", t = "aba"

set(s) → "ba"
set(t) → "ab"
set(zip(s,t)) → (b,a), (b,b), (a,a)
We use b for a(= (b,a)) and b (= (b,b)) when we create unique pairs. That is invalid.

If we check only

len(set(s)) == len(set(t))
We will return true but expected return value should be false.

