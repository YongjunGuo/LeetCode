package BianryTree.Q110_平衡二叉树;

/*
* 给定一个二叉树，判断它是否是高度平衡的二叉树。
* */

public class solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1 ){
            return -1;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(new solution().isBalanced(root));
    }
}
