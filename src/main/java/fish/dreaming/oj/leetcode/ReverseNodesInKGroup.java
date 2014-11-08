/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.Stack;

/**
 * @author tao
 *
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null) {
			return head;
		}
		ListNode lastTail = null;
		ListNode tail = head;
		int count = 0;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (tail != null) {
			stack.push(tail);
			tail = tail.next;
			count++;
			if (count >= k) {
				while (!stack.isEmpty()) {
					ListNode tmp = stack.pop();
					if (lastTail != null) {
						lastTail.next = tmp;
					} else {
						head = tmp;
					}
					lastTail = tmp;
				}
				lastTail.next = tail;
				count = 0;
			}
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
