package local.leetcode;


 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryForward){
        if (l1!=null && l2 !=null){
            l1.val = l1.val + l2.val + carryForward;
            carryForward = l1.val / 10;
            l1.val %= 10;
            l1.next = addTwoNumbers(l1.next, l2.next, carryForward);
        }
        else if(l1!=null){
            l1.val += carryForward;
            carryForward = l1.val / 10;
            l1.val %= 10;
            if(carryForward == 1)
                l1.next = addTwoNumbers(l1.next, null, carryForward);
        }
        else if (l2!=null){
            l1=l2;
            l1.val += carryForward;
            carryForward = l1.val / 10;
            l1.val %= 10;
            if(carryForward == 1)
                l1.next = addTwoNumbers(l1.next, null, carryForward);
        }
        else{
            l1 = (carryForward == 1) ? new ListNode(carryForward) : null;
        }
        return l1;
    }
}
