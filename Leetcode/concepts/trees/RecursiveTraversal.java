import java.util.*;

class Node {
    Node left;
    Node right;
    int value;

    Node(int x) {
        value = x;
        left = right = null;
    }

}

public class RecursiveTraversal {

    // LEFT => ROOT => RIGHT
    public static void inOrderTraversal(Node node, ArrayList<Integer> res){
        // core logic comes here

        if(node == null) return;

        // go through the left most

        inOrderTraversal(node.left, res);

        // add it to the result
        res.add(node.value);

        inOrderTraversal(node.right, res);
    }

    // ROOT => LEFT => RIGHT
    public static void preOrderTraversal(Node node, ArrayList<Integer> res){
        // core logic comes here

        if(node == null) return;

        
        // add it to the result
        res.add(node.value);
        
        // go through the left most
        preOrderTraversal(node.left, res);
        
        preOrderTraversal(node.right, res);
    }

    // LEFT => RIGHT => ROOT
    public static void postOrderTraversal(Node node, ArrayList<Integer> res){
        // core logic comes here
        if(node == null) return;
        
        // go through the left most
        postOrderTraversal(node.left, res);
        
        // go through the right most
        postOrderTraversal(node.right, res);
        
        // add it to the result
        res.add(node.value);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> res = new ArrayList<>();

        // System.out.println("<<<<<<<<<<<<<<,");
        // inOrderTraversal(root, res);

        preOrderTraversal(root, res);

        System.out.println("THE TRAVERSED INDOREDER ISS ::" + res);
    }
}
//     1
//   2   3 
//  4 5 6 7