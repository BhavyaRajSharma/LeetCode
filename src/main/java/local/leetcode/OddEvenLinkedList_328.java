package local.leetcode;

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode startOddHead=head;
        ListNode startEvenHead=null;
        ListNode oddHead=head;
        ListNode evenHead=null;
        int i=0;
        while (head.next!=null){
            head=head.next;
            if(i++%2==0){
                if(startEvenHead==null){
                    startEvenHead= head;
                    evenHead=head;
                }
                else {
                    evenHead.next=head;
                    evenHead=evenHead.next;
                }
            }
            else{
                oddHead.next=head;
                oddHead=oddHead.next;
            }
        }
        if(startOddHead == null) startOddHead=startEvenHead;
        oddHead.next=startEvenHead;
        if(evenHead!=null){
            evenHead.next=null;
        }
        return startOddHead;
    }
}
