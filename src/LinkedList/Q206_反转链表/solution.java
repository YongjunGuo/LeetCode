package LinkedList.Q206_反转链表;


import java.util.LinkedList;
import java.util.List;

/*反转一个单链表。
        示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
        */
public class solution {


/*
* 迭代法
* */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

/*
* 递归法
* */
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String args[]) throws Exception{
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode newnode = new solution().reverseList2(n1);
        while (newnode.next != null) {
            System.out.print(newnode.val);
            System.out.print("->");
            newnode = newnode.next;
        }
        System.out.print(newnode.val);
        System.out.println();

    }


}
