//Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
////this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//node never differ by more than one.
package TreesAndGraphs;

public class Question4 {

    // Using recursive calls
    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;

        int heightDifference = (getHeight(root.left) - getHeight(root.right));
        if (Math.abs(heightDifference) > 1){
            return false;
        }else {
             return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int getHeight(TreeNode root){
        if (root == null)
            return -1;
        return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }

    //

    public static void main(String[] args) {
        Question4 obj = new Question4();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(obj.isBalanced(root));
    }
}
