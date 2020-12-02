/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkNode(Node root, int min, int max) {
        return root.data > min
            && root.data < max
            && (root.left == null || checkNode(root.left, min, Math.min(max, root.data)))
            && (root.right == null || checkNode(root.right, Math.max(min, root.data), max));
        
    }
