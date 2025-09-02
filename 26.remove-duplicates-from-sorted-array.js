/*
 * @lc app=leetcode id=26 lang=javascript
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let j = 1
    for (let i = 1; i < nums.length; i++){
        if(nums[i] != nums[i-1]){
            nums[j] = nums[i];
            j++;
        }
    }
    return j;
};
// @lc code=end


let nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] // Input array
let expectedNums = [0, 1, 2, 3, 4]; // The expected answer with correct length

let k = removeDuplicates(nums); // Calls your implementation
console.log(`nums`, nums);
// console.log(`nums`, nums);
// console.log(`KKKKKKKK`, k);
// for (let i = 0; i < k; i++) {
//     if (nums[i] == expectedNums[i]) {
//         console.log(`true`);
//     }
// }