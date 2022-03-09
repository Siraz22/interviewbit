import java.util.*;

// Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    // "Technologies are invented to make our lives easier - not our choices."
    // -Adam Jensen, Deus Ex

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (ListNode head : a) {
            ListNode iter = head;
            while (iter != null) {
                pq.add(iter.val);
                iter = iter.next;
            }
        }

        ListNode answerHead = new ListNode(pq.poll());
        ListNode iter = answerHead;
        while (pq.size() > 0) {
            int val = pq.poll();
            iter.next = new ListNode(val);
            iter = iter.next;
        }
        return answerHead;
    }
}