package myleetcode;

import entity.ListNode;

/**
 * 合并两个有序链表
 * @author acer
 *
 */
public class MergeTwoSortedLists {

	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode result = new ListNode(0);
		ListNode temp = result;
		if (l1.val > l2.val) {
			result.val = l2.val;
			l2 = l2.next;
		} else {
			result.val = l1.val;
			l1 = l1.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				temp.next = l2;
				l2 = l2.next;
			} else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		if (l1 == null) {
			while (l2 != null) {
				temp.next = l2;
				temp = temp.next;
				l2 = l2.next;
			}
		} else {
			while (l1 != null) {
				temp.next = l1;
				temp = temp.next;
				l1 = l1.next;
			}
		}
		return result;
    }
	
}



