package myleetcode;

import entity.ListNode;

/**
 * 环形链表
 * 追赶相遇
 * @author acer
 *
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next ==null || head.next.next ==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
	
}

