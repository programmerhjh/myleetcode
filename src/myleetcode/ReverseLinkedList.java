package myleetcode;

import entity.ListNode;

/**
 * 反转链表
 * @author acer
 *
 */
public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode start = new ListNode(head.val), temp = null;
		start.next = temp;
		head = head.next;
		while(head != null) {
			ListNode t = start;
			temp = t;
			start = new ListNode(head.val);
			start.next = temp;
			head = head.next;
		}
		return start;
    }

}
