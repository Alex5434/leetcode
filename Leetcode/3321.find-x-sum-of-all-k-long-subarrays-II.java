
/*
You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

Count the occurrences of all elements in the array.
Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
Calculate the sum of the resulting array.
Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

 

Example 1:

Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

Output: [6,10,12]

Explanation:

For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.
Example 2:

Input: nums = [3,8,7,8,7,5], k = 2, x = 2

Output: [11,15,15,15,12]

Explanation:

Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].

 

Constraints:

1 <= n == nums.length <= 50
1 <= nums[i] <= 50
1 <= x <= k <= nums.length

 */
// @lc code=start

import java.util.*;

class Solution {

    /*
     * 
     * // Semi Optimal approach using sliding window (Failed for hard tags)
     * public static void findXSum(int[] nums, int windowSum, int x) {
     * Map<Integer, Integer> freq = new HashMap<>();
     * int[] resultArray = new int[nums.length - windowSum + 1];
     * 
     * int left = 0, right = 0;
     * 
     * for (right = 0; right < windowSum; right++) {
     * freq.merge(nums[right], 1, Integer::sum);
     * }
     * 
     * int result = processSubArray(freq, windowSum, x);
     * resultArray[0] = result;
     * 
     * // process the map here once
     * 
     * while (right < nums.length) {
     * 
     * // add
     * freq.merge(nums[right], 1, Integer::sum);
     * 
     * // remove
     * freq.merge(nums[left], 1, (a, b) -> a - b);
     * 
     * int result1 = processSubArray(freq, windowSum, x);
     * resultArray[++left] = result1;
     * // process the map here once
     * 
     * // System.out.println("AFTER THE LOOP STATEMENT ::: " + freq + "\n" +
     * treeMap);
     * right++;
     * 
     * }
     * 
     * System.out.println("THE FINAL FRE ISSS ::" + Arrays.toString(resultArray));
     * 
     * }
     * 
     * public static int processSubArray(Map<Integer, Integer> freq, int windowSize,
     * int x) {
     * // perform the sort function
     * 
     * List<Map.Entry<Integer, Integer>> myList = new ArrayList<>(freq.entrySet());
     * 
     * myList.sort((a, b) -> {
     * if(a.getValue().equals(b.getValue())){
     * return b.getKey() - a.getKey();
     * } else{
     * return b.getValue() - a.getValue();
     * }
     * });
     * 
     * Map<Integer, Integer> sorted = new LinkedHashMap<>();
     * 
     * for(Map.Entry<Integer, Integer> e: myList){
     * sorted.put(e.getKey(), e.getValue());
     * }
     * 
     * int sum = 0;
     * int count = 0;
     * 
     * for(Map.Entry<Integer, Integer> map: sorted.entrySet()){
     * if(count == x){
     * break;
     * }
     * sum += map.getKey() * map.getValue();
     * count++;
     * }
     * 
     * 
     * // if windowSize >= x
     * // sum all the elements and return the sum
     * 
     * // else
     * // pick the first x elements
     * // sum the x elements and return
     * return sum;
     * }
     */

    public static long[] findXSum(int[] nums, int windowSize, int x) {
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> sortedFreq = new TreeMap<>(Comparator.reverseOrder());

        long[] resultArray = new long[nums.length - windowSize + 1];

        int left = 0, right = 0;

        for (right = 0; right < windowSize; right++) {
            addNumber(nums[right], freq, sortedFreq);
        }
        computeResult(x, sortedFreq);
        // System.out.println("LLLLLLL :: " + sortedFreq);

        long result = computeResult(x, sortedFreq);
        resultArray[left] = result;

        while (right < nums.length) {
            // System.out.println("BEFORE :: " + sortedFreq);
            // System.out.println("ELEMENT TO ReMOVE :::::::" + nums[left] + " ::::::: addd
            // " + nums[right]);

            removeElement(nums[left], freq, sortedFreq);
            addNumber(nums[right], freq, sortedFreq);

            // System.out.println("AFTER :: " + sortedFreq);

            left++;
            
            long result1 = computeResult(x, sortedFreq);
            resultArray[left] = result1;
            right++;
        }

        // compute the sorting function

        return resultArray;
    }

    public static long computeResult(int x, TreeMap<Integer, TreeSet<Integer>> sortedFreq) {
        int count = 0;
        long sum = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> e : sortedFreq.entrySet()) {
            // System.out.println("kkkkkk" + e.getKey() + " " + e.getValue());
            TreeSet<Integer> numSet = e.getValue();

            for (Integer ele : numSet) {
                if(count == x){
                    return sum;
                }

                sum += (long) e.getKey() * ele;
                count++;
            }

        }

        return sum;
    }

    public static void removeElement(int num, Map<Integer, Integer> freq,
            TreeMap<Integer, TreeSet<Integer>> sortedFreq) {

        int oldFreq = freq.getOrDefault(num, 0);
        if (oldFreq == 0)
            return;

        TreeSet<Integer> oldSet = sortedFreq.get(oldFreq);
        oldSet.remove(num);

        if (oldSet.isEmpty()) {
            sortedFreq.remove(oldFreq);
        }

        int newFreq = oldFreq - 1;

        if (newFreq == 0) {
            // if frequency is 0 remove the element from array
            freq.remove(num);
        } else {
            freq.put(num, newFreq);
            sortedFreq.computeIfAbsent(newFreq, f -> new TreeSet<>(Comparator.reverseOrder())).add(num);
        }

    }

    public static void addNumber(int num, Map<Integer, Integer> freq, TreeMap<Integer, TreeSet<Integer>> sortedFreq) {
        int oldFreq = freq.getOrDefault(num, 0);
        int newFreq = oldFreq + 1;

        freq.put(num, newFreq);

        // compute for already exsisting treeset
        if (oldFreq > 0) {
            TreeSet<Integer> oldSet = sortedFreq.get(oldFreq);
            oldSet.remove(num);

            if (oldSet.isEmpty()) {
                sortedFreq.remove(oldFreq);
            }
        }

        // enter the value for new tree set
        sortedFreq.computeIfAbsent(newFreq, f -> new TreeSet<>(Comparator.reverseOrder())).add(num);
    }

    public static void main(String[] args) {
        // int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000 };
        // int k = 6, x = 6;

        // [1,1,2,2,3,4,2,3], k = 6, x = 2

        // int[] nums = { 1, 1, 2, 2, 3, 4, 2, 3 };
        // int k = 6, x = 2;

        int[] nums = { 3, 8, 7, 8, 7, 5 };
        int k = 2, x = 2;

        long result[] = findXSum(nums, k, x);

        System.out.println("array RESULT ISSSSSS :::: "+ Arrays.toString(result));
    }
}
// @lc code=end
