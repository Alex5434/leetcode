/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (62.87%)
 * Likes:    12249
 * Dislikes: 498
 * Total Accepted:    1.4M
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,2,3,4]'
 *
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * 
 * 
 * Reorder the list to be on the following form:
 * 
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * 
 * You may not modify the values in the list's nodes. Only nodes themselves may
 * be changed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 5 * 10^4].
 * 1 <= Node.val <= 1000
 * 
 * 
 */

// @lc code=start

import java.util.List;

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

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

// Reverse the list and 
class Solution {
    public static ListNode removeMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode resultNode = null;

        while(fast != null && fast.next != null){
            resultNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        resultNode.next = slow.next;

        // System.out.println("SLOW VALUE IS ::" + newSlow.val);



        // System.out.println("THE GREATE REMOVE MIDDLE");

        return resultNode;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        // head.next.next = new ListNode(4);
        // head.next.next.next = new ListNode(7);
        // head.next.next.next.next = new ListNode(1);
        // head.next.next.next.next.next = new ListNode(2);
        // head.next.next.next.next.next.next = new ListNode(6);

        ListNode newHead = removeMiddle(head);

        printList(newHead);
    }
}
// @lc code=end

