//List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
//at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Question3 {

    // Iterative approach
    public ArrayList<LinkedList<TreeNode>> depth(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }
        while (current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for ( TreeNode parent: parents
                 ) {
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    public void print(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        Iterator<LinkedList<TreeNode>> iterator = result.listIterator();
            while (iterator.hasNext()){
                System.out.print("Nodes at depth: "+ depth + " -> ");
                LinkedList<TreeNode> list = iterator.next();
                Iterator<TreeNode> iterator1 = list.listIterator();
                while (iterator1.hasNext()){
                    TreeNode treeNode = iterator1.next();
                    System.out.print(treeNode.val + " ");
                }
                System.out.println();
                depth++;
            }
    }

    //Recursive approach for the solution
    public ArrayList<LinkedList<TreeNode>> depthRecursive(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        findDepth(root,result,0);
        return result;
    }

    public void findDepth(TreeNode node, ArrayList<LinkedList<TreeNode>> result, int level){
        if(node == null)
            return;
        LinkedList<TreeNode> list = null;
        if(result.size() == level){
            list = new LinkedList<TreeNode>();
            result.add(list);
        }
        else {
            list = result.get(level);
        }
        list.add(node);
        findDepth(node.left,result,level++);
        findDepth(node.right,result,level++);
    }

    public static void main(String[] args) {
        Question3 obj = new Question3();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<LinkedList<TreeNode>> result = obj.depth(root);
        obj.print(result);

        System.out.println();
        ArrayList<LinkedList<TreeNode>> result2 = obj.depthRecursive(root);
        obj.print(result);

    }
}
