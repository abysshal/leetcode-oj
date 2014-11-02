/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		int i = num.length - 1;
		while (i > 0 && num[i - 1] >= num[i]) {
			i--;
		}
		if (i == 0) {
			quickSort(num);
		} else {
			int next = binarySearchBiggerReverse(num, num[i - 1], i,
					num.length - 1);
			if (next > 0) {
				int tmp = num[i - 1];
				num[i - 1] = num[next];
				num[next] = tmp;
				quickSort(num, i, num.length - 1);
			}
		}
	}

	public static int binarySearchBiggerReverse(int srcArray[], int key,
			int startOffset, int endOffset) {
		int mid;
		while (startOffset < endOffset) {
			mid = endOffset - (endOffset - startOffset) / 2;
			if (key < srcArray[mid]) {
				startOffset = mid;
			} else if (key >= srcArray[mid]) {
				endOffset = mid - 1;
			}
		}
		if (startOffset == endOffset && srcArray[startOffset] > key) {
			return startOffset;
		} else {
			return -1;
		}
	}

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
