package local.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumofaLinkedList_2130 {
    public int pairSum(ListNode head) {
        int maxSum=0;
        List<Integer> values = new ArrayList<>();
        while (head!=null){
            values.add(head.val);
            head=head.next;
        }
        int size=values.size();
        for(int i=0;i<size;i++){
            maxSum= Math.max(maxSum, values.get(i)+values.get(size-1-i));
        }
        return maxSum;
    }
}
