/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (74.75%)
 * Likes:    14352
 * Dislikes: 293
 * Total Accepted:    4.8M
 * Total Submissions: 6.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static int maxDepth(TreeNode root) {

        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()){

            int queueSize = queue.size();
            count++;
            for(int i = 0; i < queueSize; i++){
                TreeNode curNode = queue.poll();

                if(curNode.left != null){
                    queue.offer(curNode.left);
                }

                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
        }
        System.out.println("LLLL" + count);
        return count;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        root.right.right.right = new TreeNode(7);

        maxDepth(root);
    }
}
// @lc code=end

