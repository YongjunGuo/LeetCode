package BianryTree.Q109_有序链表转换二叉搜索树;

public class LIstNode {
    int val;
    LIstNode next;
    LIstNode() {}
    LIstNode(int val){
        this.val = val;
    }
    LIstNode(int val, LIstNode next){
        this.val = val;
        this.next = next;
    }
}
