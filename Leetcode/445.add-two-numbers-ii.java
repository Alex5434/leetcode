/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (61.85%)
 * Likes:    6134
 * Dislikes: 302
 * Total Accepted:    559.9K
 * Total Submissions: 899.7K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 * 
 * Follow up: Could you solve it without reversing the input lists?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // reverse l1
        ListNode rl1 = reverseList(l1);
        printList(rl1);
        // reverse l2
        ListNode rl2 = reverseList(l2);
        printList(rl2);

        int carry = 0;

        ListNode sumReverse = new ListNode(0);

        ListNode tempHead = sumReverse;

        // add the two list
        while (rl1 != null || rl2 != null || carry != 0) {
            int sum = carry;

            if (rl1 != null) {
                sum += rl1.val;
                rl1 = rl1.next;
            }
            if (rl2 != null) {
                sum += rl2.val;
                rl2 = rl2.next;
            }

            tempHead.next = new ListNode(sum % 10);
            tempHead = tempHead.next;
            carry = sum / 10;
        }

        // reverse the result list
        ListNode result = reverseList(sumReverse.next);

        return result;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        // head1.next.next.next = new ListNode(3);

        ListNode result = addTwoNumbers(head, head1);

        printList(result);

    }
}
// @lc code=end