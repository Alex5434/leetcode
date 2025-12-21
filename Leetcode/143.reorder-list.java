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
    /*
    * 📝 I tried to combine the original and reversed list until the half of the list length
    * Not bad but can br much inproved. Instead of reversing the entire list reverse the second half
    * and merge it will be the solution.
    */

    // public static ListNode reveseList(ListNode head){
    //     ListNode prev = null;
    //     ListNode cur = head;

    //     while(cur != null){
    //         ListNode tempCur = cur.next;
    //         cur.next = prev;
    //         prev = cur;
    //         cur = tempCur;
    //     }

    //     while(cur != null){
    //         System.out.println("LLLL " + cur.val);
    //         cur = cur.next;
    //     }
        
    //     return cur;
    // }
    // public void reorderList(ListNode head) {
    //     ListNode original = head;
    //     ListNode rotatedList = reverseList(head);
    //     int listLength;

    //     ListNode lengthFindNode =  head;
        
    //     while(lengthFindNode != null){
    //         listLength++;
    //         lengthFindNode = lengthFindNode.next;
    //     }

    //     System.out.println("THE LENGTH OF THE LIST IS ::: " + listLength);

    //     ListNode resultNode = head;

    //     for (int i = 0; i < listLength / 2; i++) {
    //         System.out.println("LOOPING ::");
    //         resultNode.next = rotatedList;
    //         rotatedList = rotatedList.next;
    //         original = original.next;
    //         resultNode.next = original;
    //     }

    // }

    // Worked Learned the solution from the leetcode 
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }

        return prev;
    }

    public static void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        // find the mid using slow and fast pointer

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // after this
        // 1 2 3 4 5
        //     s   f

        // going to reverse the second half of the list
        ListNode head2 = reverseList(slow.next);
        slow.next = null;

        // printList(head);
        // printList(head2);

        // merge the list
        // 1 -> 2 -> 3 
        // 5 -> 4 

        // 1 -> 5

        while (head != null && head2 != null) {
            // need the next of both since we are going to remove the next link
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;

            // 5 -> 2
            head2.next = head.next;
            // 1 -> 5 -> 2
            head.next = head2;

            // 1 -> 5 -> 2 -> 
            head = temp1;
            // head2 => 4 -> null
            head2 = temp2;
        }

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
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        printList(head);
    }
}
// @lc code=end

