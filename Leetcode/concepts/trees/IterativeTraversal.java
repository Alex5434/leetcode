import java.util.*;

class Node {
    TreeNode left;
    TreeNode right;
    int value;

    Node(int x) {
        value = x;
        left = right = null;
    }

}

public class IterativeTraversal {

    // LEFT => ROOT => RIGHT
    public static void inOrderTraversal(TreeNode node, ArrayList<Integer> res){
        // core logic comes here
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while(cur != null || !stack.isEmpty()){

            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            // process the leftmost node
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
    }

    // ROOT => LEFT => RIGHT
    public static void preOrderTraversal(TreeNode node, ArrayList<Integer> res){
        // core logic comes here
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()){

            TreeNode cur = stack.pop();

            res.add(cur.val);

            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    // LEFT => RIGHT => ROOT
    public static void postOrderTraversal(TreeNode node, ArrayList<Integer> res){
        // core logic comes here
        if(node == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()){

            TreeNode cur = stack.pop();

            res.add(cur.val);

            if(cur.left != null){
                stack.push(cur.left);
            }

            if(cur.right != null){
                stack.push(cur.right);
            }
        }

        Collections.reverse(res);
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

        inOrderTraversal(root, res);

        System.out.println("THE TRAVERSED INDOREDER ISS ::" + res);
    }
}
//     1
//   2   3 
//  4 5 6 7