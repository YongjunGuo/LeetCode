package BianryTree.Q94_二叉树的中序遍历;

/*
* 给定一个二叉树，返回它的中序遍历。
* */



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class solution {

    /*
     * 递归
     *  */
    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    /*
     * 栈的迭代
     * */
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while(root != null || !stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    /*
    * Morris遍历算法
    * */
    public List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while(root != null){
            if(root.left != null){
                predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(new solution().inorderTraversal3(root));
    }


}
