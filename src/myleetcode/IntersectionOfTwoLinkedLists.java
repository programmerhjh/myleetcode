package myleetcode;

import java.util.Stack;

import entity.ListNode;

/**
 * 相交链表
 * 分别压栈，同时出栈
 * @author acer
 *
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aListNode = headA;
        ListNode bListNode = headB;
        ListNode result = null;
        Stack<ListNode> aStack = new Stack<>();
        Stack<ListNode> bStack = new Stack<>();
        while (aListNode != null || bListNode != null) {
        	if (aListNode != null) {
				aStack.push(aListNode);
				aListNode = aListNode.next;
			}
        	if (bListNode != null) {
				bStack.push(bListNode);
				bListNode = bListNode.next;
			}
		}
        while (!aStack.isEmpty() && !bStack.isEmpty()) {
        	ListNode popA = aStack.pop();
        	ListNode popB = bStack.pop();
        	if (popA.val != popB.val) {
        		break;
			}
        	result = popA;
        }
		return result;
    }
	
}
