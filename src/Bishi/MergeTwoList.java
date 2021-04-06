package Bishi;

/*
* 合并两个有序链表
* */

public class MergeTwoList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode mergeTwoLIst(ListNode l1,ListNode l2){
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLIst(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLIst(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        ListNode newNode = new MergeTwoList().mergeTwoLIst(n1,n4);
        while (newNode.next != null) {
            System.out.print(newNode.val);
            System.out.print("->");
            newNode = newNode.next;
        }
        System.out.print(newNode.val);
        System.out.println();
    }

}
