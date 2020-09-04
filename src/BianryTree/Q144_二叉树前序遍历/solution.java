package BianryTree.Q144_二叉树前序遍历;

/*
* 给定一个二叉树，返回它的 前序 遍历
* */

import java.util.*;
public class solution {
    public List<Integer> preorderTravelsal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        return output;
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n1.right = n3;

        System.out.println(new solution().preorderTravelsal(root));

    }

}
