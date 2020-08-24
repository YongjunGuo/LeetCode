package BianryTree.Q111_二叉树最小深度;

/*
* 给定一个二叉树，找出其最小深度。
* 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
* */


import java.util.LinkedList;
import java.util.Queue;

public class solution {
    public int DFS(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null ){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(DFS(root.left), min_depth);
        }
        if(root.right != null){
            min_depth = Math.min(DFS(root.right), min_depth);
        }

        return min_depth + 1;

    }
    public class QueueNode{
        TreeNode node;
        int depth;
        public QueueNode(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int BFS(TreeNode root){
        if(root == null ){
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while(!queue.isEmpty()){
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if(node.left == null && node.right == null){
                return depth;
            }
            if(node.left != null){
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if(node.right != null){
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        //System.out.println(new solution().DFS(root));
        System.out.println(new solution().BFS(root));
    }
}
