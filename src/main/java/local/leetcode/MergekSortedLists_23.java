package local.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head;
        PriorityQueue<ListNode> nodeHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node: lists){
            if(node!=null)
                nodeHeap.add(node);
        }
        ListNode temp= null;
        if(!nodeHeap.isEmpty()){
            temp= nodeHeap.poll();
            if(temp.next!=null)
                nodeHeap.add(temp.next);
        }
        head= temp;
        while (!nodeHeap.isEmpty()){
            temp.next = nodeHeap.peek();
            temp = nodeHeap.poll();
            if(temp.next!=null)
                nodeHeap.add(temp.next);
        }
        return head;
    }
}
