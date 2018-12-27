/**
 * 
 */
package myleetcode;

import entity.ListNode;

/**
 * 环形链表 II
 * @author HJH
 *
 * @date 2018年12月27日
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			System.out.println("no cycle");
			return null;
		}
		int pos = -1;
		ListNode p = head, q = head, t = head;
		while (p.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				pos = 0;
				break;
			}
		}
		if (p != q) {
			System.out.println("no cycle");
			return null;
		}
		if (pos == -1) {
			System.out.println("no cycle");
			return null;
		} else {
			while (t != q) {
				t = t.next;
				p = p.next;
			}
			p = p.next;
			t = head;
			while (t != p) {
				t = t.next;
				pos ++;
			}
			System.out.println("tail connects to node index " + pos);
			return p;
		}
    }
}
