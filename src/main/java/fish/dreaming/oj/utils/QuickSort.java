/**
 * 
 */
package fish.dreaming.oj.utils;

/**
 * @author tao
 *
 */
public class QuickSort {
	private static boolean isEmpty(int[] n) {
		return n == null || n.length == 0;
	}

	public static void quickSort(int[] n) {
		if (isEmpty(n)) {
			return;
		}
		quickSort(n, 0, n.length - 1);
	}

	public static void quickSort(int[] n, int l, int h) {
		if (isEmpty(n)) {
			return;
		}
		if (l < h) {
			int pivot = partion(n, l, h);
			quickSort(n, l, pivot - 1);
			quickSort(n, pivot + 1, h);
		}
	}

	private static int partion(int[] n, int start, int end) {
		int tmp = n[start];
		while (start < end) {
			while (n[end] >= tmp && start < end) {
				end--;
			}
			if (start < end) {
				n[start++] = n[end];
			}
			while (n[start] < tmp && start < end) {
				start++;
			}
			if (start < end) {
				n[end--] = n[start];
			}
		}
		n[start] = tmp;
		return start;
	}
}
