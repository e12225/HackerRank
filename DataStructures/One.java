/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/

    boolean checkBST(Node root){
        return ValidateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean ValidateBST(Node root,int min,int max){

        if((root != null) && (root.left.data < root.data && root.right.data > root.data)){
//      condition satisfied, now moving down to the left node as the root and the right node as the root
        return ValidateBST(root.left,min,root.data-1) && ValidateBST(root.right,root.data+1,max);

        } else {

            return false;
        }
    }
