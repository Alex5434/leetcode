/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (43.13%)
 * Likes:    20832
 * Dislikes: 882
 * Total Accepted:    3.9M
 * Total Submissions: 7.7M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Got the approach though missed in the edge cases pretty good 
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode slow = head;
    //     int linkedLength = 0;

    //     while(slow != null){
    //         slow = slow.next;
    //         linkedLength++;
    //     }
    //     int nodeIndexToRemove = (linkedLength - n) - 1;

    //     ListNode resultNode = head;

    //     for(int i = 0; i < nodeIndexToRemove; i++){
    //         // 0 1 2 3 4
    //         // 1 2 3 4 5
    //         // n = 2
    //         // 1 2 4 5

    //         if(i == nodeIndexToRemove - 1){
    //             // 
    //             resultNode = resultNode.next.next;
    //         }

    //         resultNode = resultNode.next;

    //     }

    //     return resultNode;
    // }

    // Final answer :: optimsized
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int linkedLength = 0;

        while(slow != null){
            slow = slow.next;
            linkedLength++;
        }
        int nodeIndexToRemove = linkedLength - n;

        if (nodeIndexToRemove == 0) {
            return head.next;
        }

        ListNode resultNode = head;
        ListNode operationNode = resultNode;

        for(int i = 0; i < nodeIndexToRemove - 1; i++){
            operationNode = operationNode.next;
        }
        
        operationNode.next = operationNode.next.next;

        return resultNode;
    }
}
// @lc code=end

