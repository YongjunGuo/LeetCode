package BianryTree.Q109_有序链表转换二叉搜索树;


/*
* 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
* */

public class Solution {
    public TreeNode sortedListToBST(ListNode head){
        return buildTree(head,null);
    }
    public TreeNode buildTree(ListNode left, ListNode right){
        if(left == right){
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String args[]){
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(new Solution().sortedListToBST(n1));

    }
}
