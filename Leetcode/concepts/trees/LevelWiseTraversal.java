import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }

}

public class LevelWiseTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Find the level of queue

            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();    
                temp.add(node.val);
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> res = new ArrayList<>();

        // System.out.println("<<<<<<<<<<<<<<,");
        // inOrderTraversal(root, res);

        // preOrderTraversal(root, res);

        System.out.println("THE TRAVERSED INDOREDER ISS ::" + levelOrder(root));
    }
}
