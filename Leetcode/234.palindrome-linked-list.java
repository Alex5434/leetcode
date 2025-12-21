/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (56.15%)
 * Likes:    18001
 * Dislikes: 965
 * Total Accepted:    2.7M
 * Total Submissions: 4.7M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
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

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    // Brute for not optimal
    // public static boolean isPalindrome(ListNode head) {
    //     ListNode temp = head;
    //     ListNode head2 = reverseList(head);
    //     printList(head2);
    //     // printList(head2);
    //     while (head != null) {
    //         System.out.println("HEAD VAL : " + head.val + " :: " + head2.val);
    //         if(head.val != head2.val){
    //             return false;
    //         }

    //         head = head.next;
    //         head2 = head2.next;
    //         System.out.println("HEAD VAL :: " + head.val + " :: ");
    //     }

    //     return true;

    // }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }

        return prev;
    }
    

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // printList(head2);
        // printList(head2);

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseList(slow);
        // slow.next = null;

        // printList(head);
        // printList(head2);
        
        while (head != null && head2 != null) {
            // System.out.println("HEAD VAL : " + head.val + " :: " + head2.val);
            if(head.val != head2.val){
                return false;
            }

            head = head.next;
            head2 = head2.next;
            // System.out.println("HEAD VAL :: " + head.val + " :: ");
        }


        return true;

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
        head.next.next.next = new ListNode(1);
        // head.next.next.next.next = new ListNode(1);
        // printList(head);
        
        System.out.println("IS PALINDROME :: " + isPalindrome(head));
    }
}
// @lc code=end

