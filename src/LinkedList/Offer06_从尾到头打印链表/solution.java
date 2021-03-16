package LinkedList.Offer06_从尾到头打印链表;

/*
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
* */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public  class solution {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null ){
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for(int i = 0;i < size;i++){
            print[i] = stack.pop().val;
        }
    return print;
    }

    public static void main(String args[]) throws Exception{

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        solution s = new solution();
        int[] arr = s.reversePrint(n1);
        System.out.println(Arrays.toString(arr));
/*        for(Integer a  : arr)
            System.out.println(a);*/

    }

}
