/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		int lastVal = head.val;
		ListNode pointer = head;
		while (pointer.next != null) {
			if (pointer.next.val == lastVal) {
				pointer.next = pointer.next.next;
			} else {
				lastVal = pointer.next.val;
				pointer = pointer.next;
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
