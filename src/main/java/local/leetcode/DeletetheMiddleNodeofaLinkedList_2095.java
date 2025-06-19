package local.leetcode;

public class DeletetheMiddleNodeofaLinkedList_2095 {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        deleteMiddleNode(head);
        return head;
    }
    public void deleteMiddleNode(ListNode head) {
        ListNode res=head;
        ListNode prev=null;
        while(head!=null){
            head=head.next;
            if(head!=null) {
                head = head.next;
                prev=res;
                res=res.next;
            }
        }
        prev.next=res.next;
    }
}
