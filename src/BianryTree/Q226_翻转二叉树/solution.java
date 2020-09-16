package BianryTree.Q226_翻转二叉树;

/*
* 翻转一棵二叉树。
* */
public class solution {
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);


        root.left = node1;
        root.right = node2;
        solution solution = new solution();
        solution.invertTree(root);

        System.out.println(root.val + " " + root.left.val + " " + root.right.val);
    }
}
