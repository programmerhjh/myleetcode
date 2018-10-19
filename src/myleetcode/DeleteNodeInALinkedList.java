package myleetcode;

import entity.ListNode;

/**
 * 删除链表中的节点
 * @author acer
 *
 */
public class DeleteNodeInALinkedList {

	public void deleteNode(ListNode node) {
		node.val=node.next.val;
        node.next=node.next.next;
    }
	
}
